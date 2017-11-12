package co.com.kallsonys.ejb;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;

import java.io.InputStreamReader;
import java.math.BigInteger;
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
import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;

import co.com.kallsonys.interfaces.IRProducts;
import co.com.kallsonys.util.ArrayUtil;
import co.com.kallsonys.util.GenericDao;
import co.com.kallsonys.interfaces.ILProducts;

import co.com.kallsonys.dto.request.CreateProductRequestDTO;
import co.com.kallsonys.dto.request.GetCategByLstIdProductRequestDTO;
import co.com.kallsonys.dto.request.RequestProductDetailDTO;
import co.com.kallsonys.dto.response.GetCategByLstIdProductResponseDTO;
import co.com.kallsonys.dto.response.GetCategoriesByLstIdProductResponseDTO;
import co.com.kallsonys.dto.response.GetProductByIdResponseDTO;
import co.com.kallsonys.dto.response.ProducerResponseDTO;
import co.com.kallsonys.dto.response.ProductDetailResponseDTO;
import co.com.kallsonys.dto.response.ProductResponseDTO;
import co.com.kallsonys.entity.Images;
import co.com.kallsonys.entity.Products;
import co.com.kallsonys.helpers.ProductsHelper;

/**
 * Session Bean implementation class ImposicionISEJB
 */
@Stateless(name = "ProductEJB")
@LocalBean
public class ProductEJB implements ILProducts, IRProducts {

	private final static Logger logger = Logger.getLogger(ProductEJB.class.getName());

	@PersistenceContext(unitName = "persistenceUnit")
	private EntityManager em;

	private static String ipSolr = "192.168.1.182";

	@Override
	public List<ProductDetailResponseDTO> getProductDetail(RequestProductDetailDTO requestProductDetail) {
		logger.debug("ProductEJB::consutarMultas(SolicitudConsultaMultasDTO)");

		List<ProductDetailResponseDTO> listRpdDTO = new ArrayList<ProductDetailResponseDTO>();
		try {

			Map<String, Object> param = new HashMap<String, Object>();

			StringBuilder query = new StringBuilder();
			query.append("SELECT pr.name AS name,");
			query.append(" pr.description AS description,");
			query.append(" pr.price AS price,");
			query.append(" pr.externalidentifier AS externalidentifier,");
			query.append(" pd.producer AS producer,");
			query.append(" cat.category AS category,");
			query.append(" im.finalpath AS urlImage,");
			query.append(" im.base64 AS imageBase64");
			query.append(" FROM products pr");
			query.append(" INNER JOIN images im ON im.idproduct = pr.id");
			query.append(" INNER JOIN producers pd ON pr.idproducer = pd.id");
			query.append(" INNER JOIN productscategories pcat ON pcat.idproduct = pr.id");
			query.append(" INNER JOIN categories cat ON cat.id = pcat.idproduct");
			query.append(" WHERE 1 = 1");

			if (requestProductDetail.getIdProduct() != null) {
				query.append("AND pr.id = :idProduct ");
				param.put("idProduct", requestProductDetail.getIdProduct());
			}

			Query querySQL = em.createNativeQuery(query.toString());

			for (Entry<String, Object> parameter : param.entrySet()) {
				querySQL.setParameter(parameter.getKey(), parameter.getValue());
			}

			@SuppressWarnings({ "unchecked" })
			List<Object[]> productList = querySQL.getResultList();
			ProductDetailResponseDTO rpdDTO = null;

			if (productList != null && !productList.isEmpty()) {

				for (Object[] obligacion : productList) {

					// Arma obligacion que va a enviar al proceso
					rpdDTO = new ProductDetailResponseDTO();
					if (obligacion[0] != null) {
						rpdDTO.setName((String) obligacion[0]);
					}

					if (obligacion[1] != null) {
						rpdDTO.setDescription((String) obligacion[1]);
					}

					if (obligacion[2] != null) {
						rpdDTO.setPrice((String) obligacion[2]);
					}
					if (obligacion[3] != null) {
						rpdDTO.setExternalidentifier(String.valueOf(obligacion[3]));
					}
					if (obligacion[4] != null) {
						rpdDTO.setProducer((String) obligacion[4]);
					}
					if (obligacion[5] != null) {
						rpdDTO.setCategory((String) obligacion[5]);
					}
					if (obligacion[6] != null) {
						rpdDTO.setUrlImage((String) obligacion[6]);
					}
					if (obligacion[7] != null) {
						rpdDTO.setImageBase64((String) obligacion[7]);
					}

					listRpdDTO.add(rpdDTO);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listRpdDTO;
	}

	@Override
	public CreateProductRequestDTO createProduct(CreateProductRequestDTO productRequest) {

		Products product = ProductsHelper.buildProdutsEntity(productRequest, false);

		em.persist(product);

		productRequest.setId(product.getId());
		productRequest.setIdImages(this.addImages(productRequest.getImages(), product));

		// TODO METER AL SOLR
		this.consultarPrefactura();

		return productRequest;
	}

	@Override
	public GetProductByIdResponseDTO getProductById(Integer idProduct) {
		logger.debug("ProductEJB::consutarMultas(SolicitudConsultaMultasDTO)");

		GetProductByIdResponseDTO getProductByIdResponseDTO = new GetProductByIdResponseDTO();

		StringBuilder jpql = new StringBuilder();
		Map<String, Object> filtros = new HashMap<>();
		jpql.append("SELECT p FROM Products p");
		jpql.append(" LEFT JOIN FETCH p.idproducer pr");
		jpql.append(" LEFT JOIN FETCH p.listImages img");
		jpql.append(" WHERE p.id = :idProduct");
		filtros.put("idProduct", idProduct);

		GenericDao<Products> dao = new GenericDao<Products>(Products.class, em);
		List<Products> resultadoConsulta = dao.buildAndExecuteQuery(jpql, filtros);

		List<ProductResponseDTO> lstProductResponseDTO = new ArrayList<ProductResponseDTO>();
		ProductResponseDTO productResponseDTO = new ProductResponseDTO();

		List<String> lstImages = new ArrayList<String>();

		if (resultadoConsulta.isEmpty()) {

			getProductByIdResponseDTO.setResponse(false);
			getProductByIdResponseDTO.setResponseDescription("failed");
			getProductByIdResponseDTO.setListProducts(lstProductResponseDTO);
			return getProductByIdResponseDTO;
		}

		for (Products product : resultadoConsulta) {
			productResponseDTO = new ProductResponseDTO();
			productResponseDTO.setId(product.getId());
			productResponseDTO.setName(product.getName());
			productResponseDTO.setDescription(product.getDescription());
			productResponseDTO.setExternalIdentifier(product.getExternalidentifier());
			productResponseDTO.setPrice(product.getPrice());

			productResponseDTO.setProducer(new ProducerResponseDTO());

			if (product.getIdproducer() != null) {
				productResponseDTO.getProducer().setId(product.getIdproducer().getId());
				productResponseDTO.getProducer().setProducer(product.getIdproducer().getProducer());
			}

			if (!product.getListImages().isEmpty()) {

				for (Images image : product.getListImages()) {

					lstImages.add(image.getBase64());
				}
				productResponseDTO.setImages(lstImages);
			}

			lstProductResponseDTO.add(productResponseDTO);

		}

		getProductByIdResponseDTO.setResponse(true);
		getProductByIdResponseDTO.setResponseDescription("success");
		getProductByIdResponseDTO.setListProducts(lstProductResponseDTO);

		return getProductByIdResponseDTO;

	}

	@Override
	public CreateProductRequestDTO updateProduct(CreateProductRequestDTO productRequest) {

		Products product = ProductsHelper.buildProdutsEntity(productRequest, true);
		em.merge(product);

		if (productRequest.getId() != null && productRequest.getIdImages() != null
				&& !productRequest.getIdImages().isEmpty()) {
			this.deleteImages(productRequest.getIdImages(), product);

		}

		if (!productRequest.getImages().isEmpty()) {
			productRequest.setIdImages(this.addImages(productRequest.getImages(), product));
		}

		return productRequest;
	}

	/**
	 * 
	 * @param lstIdImages
	 */
	private void deleteImages(List<Integer> lstIdImages, Products product) {
		Images image;
		for (Integer idImage : lstIdImages) {
			image = new Images();
			image.setId(idImage);
			image.setProducts(product);
			em.remove(em.contains(image) ? image : em.merge(image));
		}
	}

	/**
	 * 
	 * @param lstImages
	 * @param product
	 * @return
	 */
	private List<Integer> addImages(List<String> lstImages, Products product) {
		List<Integer> idImages = new ArrayList<Integer>();
		if (!lstImages.isEmpty()) {
			Images img = new Images();

			for (String imageBase64 : lstImages) {
				img.setFinalpath("");
				img.setBase64(imageBase64);
				img.setProducts(product);
				em.persist(img);
				idImages.add(img.getId());
			}
		}
		return idImages;
	}

	public void consultarPrefactura() {

		ClientRequest request = new ClientRequest(
				"http://192.168.1.182:8984/solr/productsCore/select?indent=on&q=*:*&wt=json&sort=id%20asc&rows=10&start=0");

		request.accept("application/json");
		// request.body("application/json", consultaPrefacturaWSDTO);

		try {

			ClientResponse<String> response = request.get(String.class);

			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			}

			BufferedReader br = new BufferedReader(
					new InputStreamReader(new ByteArrayInputStream(response.getEntity().getBytes())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	@Override
	public GetCategoriesByLstIdProductResponseDTO getCategByLstIdProduct(GetCategByLstIdProductRequestDTO request) {
		logger.debug("ProductEJB::GetCategByLstIdProductResponseDTO(GetCategByLstIdProductRequestDTO)");

		GetCategoriesByLstIdProductResponseDTO response = new GetCategoriesByLstIdProductResponseDTO();
		GetCategByLstIdProductResponseDTO categ = new GetCategByLstIdProductResponseDTO();
		response.setCategories(new ArrayList<GetCategByLstIdProductResponseDTO>());

		StringBuilder query = new StringBuilder();
		Map<String, Object> param = new HashMap<String, Object>();

		if (request == null) {
			response.setResponse(false);
			response.setResponseDescription("missing data");
			return response;
		}

		//String strIdsProducts = ArrayUtil.converListToString(request.getListIdProducts());

		query.append("WITH Results_CTE AS (");
		query.append(" SELECT c.category, ");
		query.append(" count(*) as quantity, ");
		query.append(" c.id, ");
		query.append(" ROW_NUMBER() OVER(ORDER BY count(*) DESC) AS RowNum");
		query.append(" FROM categories AS c");
		query.append(" INNER JOIN productscategories AS pc ON c.id = pc.idcategory");
		query.append(" INNER JOIN products AS p ON pc.idproduct = p.id");
		query.append(" WHERE p.id in (" + request.getStrIdsProducts() + ")");
		query.append(" GROUP BY c.category, c.id )");
		query.append(" SELECT * FROM Results_CTE WHERE RowNum >= :initialPage AND RowNum <= :finalPage");

		if (request.getInitialPage() != null) {
			param.put("initialPage", request.getInitialPage());
		} else {
			response.setResponse(false);
			response.setResponseDescription("missing initialPage");
			return response;
		}

		if (request.getFinalPage() != null) {
			param.put("finalPage", request.getFinalPage());
		} else {
			response.setResponse(false);
			response.setResponseDescription("missing finalDate");
			return response;
		}
		try {
			Query querySQL = em.createNativeQuery(query.toString());

			for (Entry<String, Object> parameter : param.entrySet()) {
				querySQL.setParameter(parameter.getKey(), parameter.getValue());
			}

			@SuppressWarnings({ "unchecked" })
			List<String> productList = querySQL.getResultList();

			List<Object[]> categorytList = querySQL.getResultList();

			if (categorytList != null && !categorytList.isEmpty()) {

				for (Object[] category : categorytList) {
					categ = new GetCategByLstIdProductResponseDTO();

					if (category[0] != null) {
						categ.setCategory((String) category[0]);
					}

					if (category[1] != null) {
						categ.setQuantity((Integer) category[1]);
					}

					if (category[2] != null) {
						categ.setId((Integer) category[2]);
					}

					response.getCategories().add(categ);
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		response.setResponse(true);
		response.setResponseDescription("success");
		

		return response;

	}

}
