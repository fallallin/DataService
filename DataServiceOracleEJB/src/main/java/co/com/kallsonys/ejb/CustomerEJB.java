package co.com.kallsonys.ejb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.logging.Logger;

import co.com.kallsonys.dto.request.CustomerRequestDTO;
import co.com.kallsonys.dto.response.AddressesResponseDTO;
import co.com.kallsonys.dto.response.CustomerResponseDTO;
import co.com.kallsonys.dto.response.CustomerTypeResponseDTO;
import co.com.kallsonys.dto.response.GetCustomerByIdResponseDTO;
import co.com.kallsonys.dto.response.RolResponseDTO;
import co.com.kallsonys.dto.response.SetCustomerResponseDTO;
import co.com.kallsonys.dto.response.StatusResponseDTO;
import co.com.kallsonys.entity.CustomerTypes;
import co.com.kallsonys.entity.CustomersAddresses;
import co.com.kallsonys.entity.Orders;
import co.com.kallsonys.entity.Roles;
import co.com.kallsonys.entity.Status;
import co.com.kallsonys.entity.Users;
import co.com.kallsonys.helpers.AddressesHelper;
import co.com.kallsonys.interfaces.ILCustomer;
import co.com.kallsonys.interfaces.ILLocation;
import co.com.kallsonys.interfaces.IRCustomer;
import co.com.kallsonys.interfaces.IRLocation;
import co.com.kallsonys.util.GenericDao;

/**
 * Session Bean implementation class ImposicionISEJB
 */
@Stateless(name = "CustomerEJB")
@LocalBean
public class CustomerEJB implements ILCustomer, IRCustomer {

	private final static Logger logger = Logger.getLogger(CustomerEJB.class.getName());

	@PersistenceContext(unitName = "persistenceUnitOracle")
	private EntityManager em;

	@Override
	public GetCustomerByIdResponseDTO getCustomer(CustomerRequestDTO customerDTO) {

		GetCustomerByIdResponseDTO getCustomerByIdResponseDTO = new GetCustomerByIdResponseDTO();

		logger.debug(LocationEJB.class.getName().concat("::getAllCountries()"));
		StringBuilder jpql = new StringBuilder();
		Map<String, Object> filtros = new HashMap<>();
		jpql.append("SELECT c FROM Users c");
		jpql.append(" LEFT JOIN FETCH c.status s");
		jpql.append(" LEFT JOIN FETCH c.rol r");
		jpql.append(" LEFT JOIN FETCH c.customerType ct");
		jpql.append(" WHERE 1 = 1");

		List<CustomerResponseDTO> listCustomersDTO = new ArrayList<CustomerResponseDTO>();
		CustomerResponseDTO customerResponseDTO = new CustomerResponseDTO();

		if (customerDTO != null) {
			if (customerDTO.getId() != null) {
				jpql.append(" AND c.id = :idCustomer ");
				filtros.put("idCustomer", customerDTO.getId());
			}

			if (customerDTO.getIdentification() != null) {
				jpql.append(" AND c.identification = :identification ");
				filtros.put("identification", customerDTO.getIdentification());
			}

			if (customerDTO.getEmail() != null) {
				jpql.append(" AND c.email = :email ");
				filtros.put("email", customerDTO.getEmail());
			}

			if (customerDTO.getLogin() != null) {
				jpql.append(" AND c.login = :login ");
				filtros.put("login", customerDTO.getLogin());
			}

		} else {
			getCustomerByIdResponseDTO.setResponse(false);
			getCustomerByIdResponseDTO.setResponseDescription("failture");
			getCustomerByIdResponseDTO.setListCustomers(listCustomersDTO);
			return getCustomerByIdResponseDTO;
		}

		GenericDao<Users> dao = new GenericDao<Users>(Users.class, em);
		List<Users> resultadoConsulta = dao.buildAndExecuteQuery(jpql, filtros);
		if (!resultadoConsulta.isEmpty()) {
			for (Users user : resultadoConsulta) {

				customerResponseDTO = new CustomerResponseDTO();
				customerResponseDTO.setId(user.getId());
				customerResponseDTO.setName(user.getName());
				customerResponseDTO.setLastName(user.getLastname());
				customerResponseDTO.setIdentification(user.getIdentification());
				customerResponseDTO.setEmail(user.getEmail());
				customerResponseDTO.setPhoneNumber(user.getPhonenumber());
				customerResponseDTO.setLogin(user.getLogin());
				customerResponseDTO.setPassword(user.getPassword());

				customerResponseDTO.setRol(new RolResponseDTO());

				if (user.getRol() != null) {
					customerResponseDTO.getRol().setIdRol(user.getRol().getId());
					customerResponseDTO.getRol().setRol(user.getRol().getRol());
				}

				customerResponseDTO.setStatus(new StatusResponseDTO());

				if (user.getStatus() != null) {
					customerResponseDTO.getStatus().setIdStatus(user.getStatus().getId());
					customerResponseDTO.getStatus().setStatus(user.getStatus().getStatus());
				}

				customerResponseDTO.setCustomerType(new CustomerTypeResponseDTO());

				if (user.getCustomerType() != null) {
					customerResponseDTO.getCustomerType().setIdCustomerType(user.getCustomerType().getId());
					customerResponseDTO.getCustomerType().setCustomerType(user.getCustomerType().getUsertype());
				}
				
				customerResponseDTO.setAddress(getAddressByIdUser(user.getId()));

				listCustomersDTO.add(customerResponseDTO);
			}
		}

		getCustomerByIdResponseDTO.setResponse(true);
		getCustomerByIdResponseDTO.setResponseDescription("success");
		getCustomerByIdResponseDTO.setListCustomers(listCustomersDTO);
		return getCustomerByIdResponseDTO;
	}

	@Override
	public SetCustomerResponseDTO setCustomer(CustomerRequestDTO customerRequest) {

		SetCustomerResponseDTO setCustomerResponseDTO = new SetCustomerResponseDTO();

		if (customerRequest == null) {
			setCustomerResponseDTO.setResponse(false);
			setCustomerResponseDTO.setResponseDescription("failture");
			setCustomerResponseDTO.setCustomer(new CustomerResponseDTO());

			return setCustomerResponseDTO;
		}

		Users user = new Users();

		user.setId(customerRequest.getId());
		user.setName(customerRequest.getName());
		user.setLastname(customerRequest.getLastName());
		user.setEmail(customerRequest.getEmail());
		user.setPhonenumber(customerRequest.getPhoneNumber());
		user.setLogin(customerRequest.getLogin());
		user.setPassword(customerRequest.getPassword());

		user.setRol(new Roles());

		if (customerRequest.getRol() != null) {
			user.getRol().setId(customerRequest.getRol().getIdRol());
			user.getRol().setRol(customerRequest.getRol().getRol());
		}

		user.setStatus(new Status());

		if (customerRequest.getStatus() != null) {
			user.getStatus().setId(customerRequest.getStatus().getIdStatus());
			user.getStatus().setStatus(customerRequest.getStatus().getStatus());
		}

		user.setCustomerType(new CustomerTypes());

		if (customerRequest.getCustomerType() != null) {
			user.getCustomerType().setId(customerRequest.getCustomerType().getIdCustomerType());
			user.getCustomerType().setUsertype(customerRequest.getCustomerType().getCustomerType());
		}

		em.persist(user);

		return this.buildSetCustomerResponseDTO(user);

	}

	private SetCustomerResponseDTO buildSetCustomerResponseDTO(Users user) {

		SetCustomerResponseDTO setCustomerResponseDTO = new SetCustomerResponseDTO();

		setCustomerResponseDTO.setResponse(true);
		setCustomerResponseDTO.setResponseDescription("success");
		setCustomerResponseDTO.setCustomer(new CustomerResponseDTO());
		setCustomerResponseDTO.getCustomer().setId(user.getId());
		setCustomerResponseDTO.getCustomer().setName(user.getName());
		setCustomerResponseDTO.getCustomer().setLastName(user.getLastname());
		setCustomerResponseDTO.getCustomer().setEmail(user.getEmail());
		setCustomerResponseDTO.getCustomer().setPhoneNumber(user.getPhonenumber());
		setCustomerResponseDTO.getCustomer().setLogin(user.getLogin());
		setCustomerResponseDTO.getCustomer().setPassword(user.getPassword());
		setCustomerResponseDTO.getCustomer().setStatus(new StatusResponseDTO());
		setCustomerResponseDTO.getCustomer().getStatus().setIdStatus(user.getStatus().getId());
		setCustomerResponseDTO.getCustomer().getStatus().setStatus(user.getStatus().getStatus());
		setCustomerResponseDTO.getCustomer().setRol(new RolResponseDTO());
		setCustomerResponseDTO.getCustomer().getRol().setIdRol(user.getRol().getId());
		setCustomerResponseDTO.getCustomer().getRol().setRol(user.getRol().getRol());
		setCustomerResponseDTO.getCustomer().setCustomerType(new CustomerTypeResponseDTO());
		setCustomerResponseDTO.getCustomer().getCustomerType().setIdCustomerType(user.getCustomerType().getId());
		setCustomerResponseDTO.getCustomer().getCustomerType().setCustomerType(user.getCustomerType().getUsertype());

		return setCustomerResponseDTO;
	}

	public AddressesResponseDTO getAddressByIdUser(Integer idUser) {

		logger.debug(LocationEJB.class.getName().concat("::getAddressByIdUser()"));
		StringBuilder jpql = new StringBuilder();
		Map<String, Object> filtros = new HashMap<>();
		jpql.append("SELECT ca FROM CustomersAddresses ca");
		jpql.append(" LEFT JOIN FETCH ca.customer c");
		jpql.append(" LEFT JOIN FETCH ca.address a");
		jpql.append(" LEFT JOIN FETCH a.city ct");
		jpql.append(" LEFT JOIN FETCH a.state st");
		jpql.append(" LEFT JOIN FETCH a.country cy");
		jpql.append(" WHERE 1 = 1");

		List<CustomerResponseDTO> listCustomersDTO = new ArrayList<CustomerResponseDTO>();
		AddressesResponseDTO addressesResponseDTO = new AddressesResponseDTO();

		if (idUser != null) {
			jpql.append(" AND c.id = :idUser ");
			filtros.put("idUser", idUser);
		}
		
		
		GenericDao<CustomersAddresses> dao = new GenericDao<CustomersAddresses>(CustomersAddresses.class, em);
		List<CustomersAddresses> resultadoConsulta = dao.buildAndExecuteQuery(jpql, filtros);
		if (!resultadoConsulta.isEmpty()) {
			addressesResponseDTO = AddressesHelper.buildAddressesResponseDTO( resultadoConsulta.get(0).getAddress());
		}
		
		
		
		return addressesResponseDTO;

	}
}
