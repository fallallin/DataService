package co.com.kallsonys.orders;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import co.com.kallsonys.dto.request.CreateOrderRequestDTO;
import co.com.kallsonys.dto.request.CreateProductRequestDTO;
import co.com.kallsonys.dto.request.GetOrdersByDatesRequestDTO;
import co.com.kallsonys.dto.request.ItemRequestDTO;
import co.com.kallsonys.dto.request.ProductRankingRequestDTO;
import co.com.kallsonys.dto.request.RequestProductDetailDTO;
import co.com.kallsonys.dto.response.GetOrderByIdResponseDTO;
import co.com.kallsonys.dto.response.IdProductsListResponseDTO;
import co.com.kallsonys.dto.response.OrderDetailResponseDTO;
import co.com.kallsonys.dto.response.OrderResponseDTO;
import co.com.kallsonys.dto.response.ProductDetailResponseDTO;
import co.com.kallsonys.dto.response.ProductRankingResponseDTO;
import co.com.kallsonys.dto.response.RankingResponseDTO;
import co.com.kallsonys.interfaces.IRItems;
import co.com.kallsonys.interfaces.IROrder;
import co.com.kallsonys.interfaces.IRProducts;

@Path("/Orders")
@Stateless
public class OrderService {

	@EJB(lookup = "java:global/DataServiceEAR/DataServiceOracleEJB/OrderEJB!co.com.kallsonys.interfaces.IROrder")
	IROrder orderEJB;

	@EJB(lookup = "java:global/DataServiceEAR/DataServiceOracleEJB/ItemsEJB!co.com.kallsonys.interfaces.IRItems")
	IRItems itemsEJB;

	@EJB(lookup = "java:global/DataServiceEAR/DataServiceEJB/ProductEJB!co.com.kallsonys.interfaces.IRProducts")
	IRProducts productsEJB;

	@GET
	@Path("/getOrderByNumber")
	@Produces(MediaType.APPLICATION_JSON)
	public OrderDetailResponseDTO getOrderByNumber(@QueryParam("idOrder") Integer idOrder) {
		return this.orderEJB.getOrderByNumber(idOrder);
	}

	@GET
	@Path("/{IdOrder}")
	@Produces(MediaType.APPLICATION_JSON)
	public GetOrderByIdResponseDTO getProductById(@PathParam("IdOrder") Integer IdOrder) {
		return this.orderEJB.getOrderById(IdOrder);
	}

	@GET
	@Path("/getOrdersByDates")
	@Produces(MediaType.APPLICATION_JSON)
	public IdProductsListResponseDTO getOrdersByDates(@QueryParam("initialDate") Date initialDate,
			@QueryParam("finalDate") Date finalDate) {

		GetOrdersByDatesRequestDTO getOrdersByDatesRequestDTO = new GetOrdersByDatesRequestDTO();

		getOrdersByDatesRequestDTO.setInitialDate(initialDate);
		getOrdersByDatesRequestDTO.setFinalDate(finalDate);

		return this.orderEJB.getOrdersByDates(getOrdersByDatesRequestDTO);
	}

	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public OrderResponseDTO createCustomer(CreateOrderRequestDTO createOrderRequestDTO) {

		OrderResponseDTO orderResponseDTO = this.orderEJB.createOrder(createOrderRequestDTO);
		return orderResponseDTO;
	}

	// @PUT
	// @Path("/")
	// @Consumes(MediaType.APPLICATION_JSON )
	// @Produces(MediaType.APPLICATION_JSON )
	// public CreateOrderRequestDTO updateProduct(CreateOrderRequestDTO
	// createOrderRequestDTO){
	// return this.orderEJB.updateOrder(createOrderRequestDTO);
	// }

	@GET
	@Path("/getProductRanking")
	@Produces(MediaType.APPLICATION_JSON)
	public RankingResponseDTO getProductRanking(@QueryParam("initalPage") Integer initalPage,
			@QueryParam("finalPage") Integer finalPage, @QueryParam("initialDate") Date initialDate,
			@QueryParam("finalDate") Date finalDate) {

		ProductRankingRequestDTO rpd = new ProductRankingRequestDTO(initalPage, finalPage, initialDate, finalDate);

		return this.itemsEJB.getProductRanking(rpd);
	}

}
