package co.com.kallsonys.services.customer;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import co.com.kallsonys.dto.request.CustomerRequestDTO;
import co.com.kallsonys.dto.response.GetCustomerByIdResponseDTO;
import co.com.kallsonys.dto.response.SetCustomerResponseDTO;
import co.com.kallsonys.interfaces.IRCustomer;

@Path("/Customer")
@Stateless
public class CustomerService {

	@EJB(lookup = "java:global/DataServiceEAR/DataServiceOracleEJB/CustomerEJB!co.com.kallsonys.interfaces.IRCustomer")
	IRCustomer customerEJB;

	@GET
	@Path("/{CustomerId}")
	@Produces(MediaType.APPLICATION_JSON)
	public GetCustomerByIdResponseDTO getProductById(@PathParam("CustomerId") Integer CustomerId,
			@QueryParam("email") String emailCustomer, @QueryParam("login") String loginCustomer) {

		CustomerRequestDTO customerRequest = new CustomerRequestDTO();
		customerRequest.setId(CustomerId);
		customerRequest.setEmail(emailCustomer);
		customerRequest.setLogin(loginCustomer);

		return this.customerEJB.getCustomer(customerRequest);
	}

	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public SetCustomerResponseDTO createCustomer(CustomerRequestDTO customer) {

		return this.customerEJB.setCustomer(customer);
	}

	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public GetCustomerByIdResponseDTO getCustomer(@QueryParam("email") String emailCustomer,
			@QueryParam("login") String loginCustomer, @QueryParam("identification") String identificationCustomer) {

		CustomerRequestDTO customerRequest = new CustomerRequestDTO();
		customerRequest.setEmail(emailCustomer);
		customerRequest.setLogin(loginCustomer);
		customerRequest.setIdentification(identificationCustomer);

		return this.customerEJB.getCustomer(customerRequest);
	}

}
