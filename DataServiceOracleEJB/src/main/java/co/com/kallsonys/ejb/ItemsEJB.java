package co.com.kallsonys.ejb;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.jboss.logging.Logger;

import co.com.kallsonys.dto.request.ItemRequestDTO;
import co.com.kallsonys.dto.request.OrderRequestDTO;
import co.com.kallsonys.dto.request.ProductRankingRequestDTO;
import co.com.kallsonys.dto.response.ItemResponseDTO;
import co.com.kallsonys.dto.response.ProductRankingResponseDTO;
import co.com.kallsonys.dto.response.RankingResponseDTO;
import co.com.kallsonys.entity.Items;
import co.com.kallsonys.helpers.ItemsHelper;
import co.com.kallsonys.interfaces.ILItems;
import co.com.kallsonys.interfaces.IRItems;

/**
 * Session Bean implementation class ImposicionISEJB
 */
@Stateless(name = "ItemsEJB")
@LocalBean
public class ItemsEJB implements ILItems, IRItems {

	private final static Logger logger = Logger.getLogger(ItemsEJB.class.getName());

	@PersistenceContext(unitName = "persistenceUnitOracle")
	private EntityManager em;

	@Override
	public ItemResponseDTO createItem(ItemRequestDTO itemRequestDTO) {
		logger.debug(ItemsEJB.class.getName().concat("::createItem(ItemRequestDTO)"));

		Items item = ItemsHelper.buildItemsEntity(itemRequestDTO);
		em.persist(item);

		return ItemsHelper.buildItemResponseDTO(item);

	}

	@Override
	public List<ItemResponseDTO> createItems(List<ItemRequestDTO> listItemRequestDTO, Integer idOrder) {
		logger.debug(ItemsEJB.class.getName().concat("::createItems(List<ItemRequestDTO>)"));

		List<ItemResponseDTO> listItemResponseDTO = new ArrayList<ItemResponseDTO>();

		if (!listItemRequestDTO.isEmpty()) {

			for (ItemRequestDTO itemRequestDTO : listItemRequestDTO) {
				itemRequestDTO.setOrder(new OrderRequestDTO());
				itemRequestDTO.getOrder().setId(idOrder);
				listItemResponseDTO.add(this.createItem(itemRequestDTO));
			}
		}
		return listItemResponseDTO;
	}

	@Override
	public RankingResponseDTO getProductRanking(ProductRankingRequestDTO productRankingRequestDTO) {
		logger.debug(ItemsEJB.class.getName().concat("::getProductRanking(ProductRankingRequestDTO)"));

		List<ProductRankingResponseDTO> listRpdDTO = new ArrayList<ProductRankingResponseDTO>();

		RankingResponseDTO rankingResponseDTO = new RankingResponseDTO();

		try {

			Map<String, Object> param = new HashMap<String, Object>();

			StringBuilder query = new StringBuilder();
			query.append("SELECT A.externalidentifier, COUNT(*) quantity, max(rowNum) total FROM items A ");
			query.append(" INNER JOIN orders O ON O.ID = A.IDORDER");
			query.append(" WHERE ");
			query.append(" O.ORDERDATE BETWEEN :initialDate AND :finalDate");
			query.append(" AND ");
			query.append(" rowNum BETWEEN :initialPage AND :finalPage ");
			query.append(" GROUP BY A.externalidentifier ORDER BY quantity DESC");

			if (productRankingRequestDTO.getInitialDate() != null) {
				param.put("initialDate", productRankingRequestDTO.getInitialDate());
			}

			if (productRankingRequestDTO.getFinalDate() != null) {
				param.put("finalDate", productRankingRequestDTO.getFinalDate());
			}

			if (productRankingRequestDTO.getInitalPage() != null) {
				param.put("initialPage", productRankingRequestDTO.getInitalPage());
			}

			if (productRankingRequestDTO.getFinalPage() != null) {
				param.put("finalPage", productRankingRequestDTO.getFinalPage());
			}

			Query querySQL = em.createNativeQuery(query.toString());

			for (Entry<String, Object> parameter : param.entrySet()) {
				querySQL.setParameter(parameter.getKey(), parameter.getValue());
			}

			@SuppressWarnings({ "unchecked" })
			List<Object[]> productList = querySQL.getResultList();
			ProductRankingResponseDTO rpdDTO = null;

			if (productList != null && !productList.isEmpty()) {

				for (Object[] product : productList) {

					// Arma obligacion que va a enviar al proceso
					rpdDTO = new ProductRankingResponseDTO();
					if (product[0] != null) {
						rpdDTO.setIdProduct(Integer.valueOf((String) product[0]));
					}

					if (product[1] != null) {
						BigDecimal quantity = (BigDecimal) product[1];
						rpdDTO.setQuantity(quantity.intValueExact());
					}

					if (product[2] != null) {
						BigDecimal quantity = (BigDecimal) product[2];
						rpdDTO.setQuantity(quantity.intValueExact());
					}

					listRpdDTO.add(rpdDTO);
				}
			}
		} catch (Exception e) {
			rankingResponseDTO.setResponse(false);
			rankingResponseDTO.setResponseDescription("failture");

		}
		rankingResponseDTO.setResponse(true);
		rankingResponseDTO.setResponseDescription("success");

		rankingResponseDTO.setLstProducts(listRpdDTO);

		return rankingResponseDTO;

	}

}
