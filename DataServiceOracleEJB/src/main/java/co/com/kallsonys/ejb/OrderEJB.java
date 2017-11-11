package co.com.kallsonys.ejb;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.criterion.Order;
import org.jboss.logging.Logger;

import co.com.kallsonys.dto.request.CreateOrderRequestDTO;
import co.com.kallsonys.dto.request.CustomerRequestDTO;
import co.com.kallsonys.dto.request.OrderRequestDTO;
import co.com.kallsonys.dto.response.AddressesResponseDTO;
import co.com.kallsonys.dto.response.CitiesResponseDTO;
import co.com.kallsonys.dto.response.CountriesResponseDTO;
import co.com.kallsonys.dto.response.CustomerResponseDTO;
import co.com.kallsonys.dto.response.CustomerTypeResponseDTO;
import co.com.kallsonys.dto.response.GetOrderByIdResponseDTO;
import co.com.kallsonys.dto.response.OrderDetailResponseDTO;
import co.com.kallsonys.dto.response.OrderRelationResponseDTO;
import co.com.kallsonys.dto.response.OrderResponseDTO;
import co.com.kallsonys.dto.response.RolResponseDTO;
import co.com.kallsonys.dto.response.StatesResponseDTO;
import co.com.kallsonys.dto.response.StatusResponseDTO;
import co.com.kallsonys.entity.Addresses;
import co.com.kallsonys.entity.CustomersOrders;
import co.com.kallsonys.entity.Items;
import co.com.kallsonys.entity.Orders;
import co.com.kallsonys.entity.Users;
import co.com.kallsonys.helpers.CustomerHelper;
import co.com.kallsonys.helpers.ItemsHelper;
import co.com.kallsonys.helpers.OrderHelper;
import co.com.kallsonys.interfaces.ILLocation;
import co.com.kallsonys.interfaces.ILOrder;
import co.com.kallsonys.interfaces.IRLocation;
import co.com.kallsonys.interfaces.IROrder;
import co.com.kallsonys.util.GenericDao;

/**
 * Session Bean implementation class ImposicionISEJB
 */
@Stateless(name = "OrderEJB")
@LocalBean
public class OrderEJB implements ILOrder, IROrder {

	private final static Logger logger = Logger.getLogger(OrderEJB.class.getName());

	@PersistenceContext(unitName = "persistenceUnitOracle")
	private EntityManager em;

	@Override
	public OrderDetailResponseDTO getOrderByNumber(Integer idOrder) {
		logger.debug(OrderEJB.class.getName().concat("::getOrderByNumber(Integer)"));

		OrderDetailResponseDTO orderResponse = new OrderDetailResponseDTO();

		logger.debug(LocationEJB.class.getName().concat("::getAllCountries()"));
		StringBuilder jpql = new StringBuilder();
		Map<String, Object> filtros = new HashMap<>();
		jpql.append("SELECT o FROM Orders o");
		jpql.append(" LEFT JOIN FETCH o.status s");
		jpql.append(" LEFT JOIN FETCH o.address a");
		jpql.append(" LEFT JOIN FETCH a.city ct");
		jpql.append(" LEFT JOIN FETCH a.state st");
		jpql.append(" LEFT JOIN FETCH a.country cy");
		jpql.append(" WHERE 1 = 1");

		if (idOrder != null) {
			jpql.append(" AND o.id = :idOrder ");
			filtros.put("idOrder", idOrder);
		} else {
			orderResponse.setStatus(false);
			orderResponse.setStatusDescription("No exist !!!");
			return orderResponse;
		}

		GenericDao<Orders> dao = new GenericDao<Orders>(Orders.class, em);
		List<Orders> resultadoConsulta = dao.buildAndExecuteQuery(jpql, filtros);
		if (!resultadoConsulta.isEmpty()) {

			orderResponse.setStatus(true);
			orderResponse.setStatusDescription("success");
			orderResponse.setId(resultadoConsulta.get(0).getId());
			orderResponse.setOrderDate(resultadoConsulta.get(0).getOrderDate());
			orderResponse.setPrice(resultadoConsulta.get(0).getPrice());
			orderResponse.setComments(resultadoConsulta.get(0).getComments());
			orderResponse.setStatusOrderDescription(resultadoConsulta.get(0).getStatus().getStatus());
			orderResponse.setAddress(resultadoConsulta.get(0).getAddress().getAddress());
			orderResponse.setCountry(resultadoConsulta.get(0).getAddress().getCountry().getCountry());
			orderResponse.setState(resultadoConsulta.get(0).getAddress().getState().getState());
			orderResponse.setCity(resultadoConsulta.get(0).getAddress().getCity().getCity());
		} else {
			orderResponse.setStatus(false);
			orderResponse.setStatusDescription("No records found !!!");
		}

		return orderResponse;
	}

	@Override
	public GetOrderByIdResponseDTO getOrderById(Integer idOrder) {

		GetOrderByIdResponseDTO getOrderByIdResponseDTO = new GetOrderByIdResponseDTO();
		getOrderByIdResponseDTO.setOrderRelation(new OrderRelationResponseDTO());

		logger.debug(LocationEJB.class.getName().concat("::getAllCountries()"));
		StringBuilder jpql = new StringBuilder();
		Map<String, Object> filtros = new HashMap<>();
		jpql.append("SELECT co FROM CustomersOrders co");
		jpql.append(" LEFT JOIN FETCH co.order o");
		jpql.append(" LEFT JOIN FETCH o.status s");
		jpql.append(" LEFT JOIN FETCH o.address a");
		jpql.append(" LEFT JOIN FETCH a.city ct");
		jpql.append(" LEFT JOIN FETCH a.state st");
		jpql.append(" LEFT JOIN FETCH a.country cy");
		jpql.append(" LEFT JOIN FETCH co.customer c");
		jpql.append(" LEFT JOIN FETCH c.rol r");
		jpql.append(" LEFT JOIN FETCH c.status sc");
		jpql.append(" LEFT JOIN FETCH c.customerType cty");

		jpql.append(" WHERE 1 = 1");

		if (idOrder != null) {
			jpql.append(" AND o.id = :idOrder ");
			filtros.put("idOrder", idOrder);
		} else {
			getOrderByIdResponseDTO.setResponse(false);
			getOrderByIdResponseDTO.setResponseDescription("failture");
			return getOrderByIdResponseDTO;
		}

		GenericDao<CustomersOrders> dao = new GenericDao<CustomersOrders>(CustomersOrders.class, em);
		List<CustomersOrders> resultadoConsulta = dao.buildAndExecuteQuery(jpql, filtros);
		if (!resultadoConsulta.isEmpty()) {

			CustomersOrders customersOrders = resultadoConsulta.get(0);

			if (customersOrders.getCustomer() != null) {
				getOrderByIdResponseDTO.getOrderRelation()
						.setCustomer(CustomerHelper.buildCustomerResponseDTO(customersOrders.getCustomer()));
			} else {
				getOrderByIdResponseDTO.getOrderRelation().setCustomer(new CustomerResponseDTO());
			}

			if (customersOrders.getOrder() != null) {
				getOrderByIdResponseDTO.getOrderRelation()
						.setOrder(OrderHelper.buildOrderResponseDTO(customersOrders.getOrder()));
			} else {
				getOrderByIdResponseDTO.getOrderRelation().setOrder(new OrderResponseDTO());
			}

		}

		getOrderByIdResponseDTO.setResponse(true);
		getOrderByIdResponseDTO.setResponseDescription("success");

		return getOrderByIdResponseDTO;

	}

	@Override
	public OrderResponseDTO createOrder(CreateOrderRequestDTO createOrderRequestDTO) {

		Orders order = OrderHelper.buildOrderEntity(createOrderRequestDTO.getOrder());

		List<Items> itemList = ItemsHelper.buildListItemsEntity(createOrderRequestDTO.getListItems());

		for (Items item : itemList) {
			item.setOrder(order);
		}

		order.setItemList(itemList);
		em.persist(order);

		Users customer = CustomerHelper.buildCustomerEntity(createOrderRequestDTO.getCustomer());
		CustomersOrders customersOrders = new CustomersOrders(null, order, customer);
		em.persist(customersOrders);
		
		return OrderHelper.buildOrderResponseDTO(order);
	}

	@Override
	public void createCustomersOrders(OrderRequestDTO orderRequestDTO, CustomerRequestDTO customerRequestDTO) {
		logger.debug(OrderEJB.class.getName().concat("::createCustomersOrders(OrderRequestDTO, CustomerRequestDTO)"));

		Orders order = OrderHelper.buildOrderEntity(orderRequestDTO);
		Users customer = CustomerHelper.buildCustomerEntity(customerRequestDTO);
		CustomersOrders customersOrders = new CustomersOrders(null, order, customer);
		em.persist(customersOrders);

	}

	@Override
	public CreateOrderRequestDTO upadateOrder(CreateOrderRequestDTO createOrderRequestDTO) {
		logger.debug(OrderEJB.class.getName().concat("::upadateOrder(CreateOrderRequestDTO)"));

		Orders order = OrderHelper.buildOrderEntity(createOrderRequestDTO.getOrder());
		Users customer = CustomerHelper.buildCustomerEntity(createOrderRequestDTO.getCustomer());

		CustomersOrders customersOrders = this.getCustomersOrdersEntity(order.getId(), customer.getId());

		if (customersOrders.getId() != null) {
			customersOrders.setCustomer(customer);
			customersOrders.setOrder(order);

			em.merge(order);
		} else {

		}

		return createOrderRequestDTO;

	}

	public CustomersOrders getCustomersOrdersEntity(Integer idOrder, Integer idCustomer) {

		logger.debug(LocationEJB.class.getName().concat("::getAllCountries()"));
		StringBuilder jpql = new StringBuilder();
		Map<String, Object> filtros = new HashMap<>();
		jpql.append("SELECT co FROM CustomersOrders co");
		jpql.append(" LEFT JOIN FETCH co.order o");
		jpql.append(" LEFT JOIN FETCH o.status s");
		jpql.append(" LEFT JOIN FETCH co.customer c");

		jpql.append(" WHERE 1 = 1");

		if (idOrder != null) {
			jpql.append(" AND o.id = :idOrder ");
			filtros.put("idOrder", idOrder);
		}

		if (idCustomer != null) {
			jpql.append(" AND c.id = :idCustomer ");
			filtros.put("idCustomer", idCustomer);
		}

		GenericDao<CustomersOrders> dao = new GenericDao<CustomersOrders>(CustomersOrders.class, em);
		List<CustomersOrders> resultadoConsulta = dao.buildAndExecuteQuery(jpql, filtros);
		if (!resultadoConsulta.isEmpty()) {
			return resultadoConsulta.get(0);
		}

		return new CustomersOrders();
	}

}
