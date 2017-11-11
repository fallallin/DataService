package co.com.kallsonys.services.product;


import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import co.com.kallsonys.dto.request.CreateProductRequestDTO;
import co.com.kallsonys.dto.request.RequestProductDetailDTO;
import co.com.kallsonys.dto.response.GetProductByIdResponseDTO;
import co.com.kallsonys.dto.response.ProductDetailResponseDTO;
import co.com.kallsonys.interfaces.IRProducts;

@Path("/Products")
@Stateless
public class ProductService {
	
    @EJB(
            lookup = "java:global/DataServiceEAR/DataServiceEJB/ProductEJB!co.com.kallsonys.interfaces.IRProducts")
    IRProducts productsEJB;
	

	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON )
	@Produces(MediaType.APPLICATION_JSON )
	public CreateProductRequestDTO createNewProduct(CreateProductRequestDTO product) {
		
		return this.productsEJB.createProduct(product);
	}

	@GET
	@Path("/{ProductId}")
	@Produces(MediaType.APPLICATION_JSON)
	public GetProductByIdResponseDTO getProductById(@PathParam("ProductId") Integer ProductId) {
		return this.productsEJB.getProductById(ProductId);
	}
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON )
	@Produces(MediaType.APPLICATION_JSON )
	public CreateProductRequestDTO updateProduct(CreateProductRequestDTO createProductRequestDTO){
		return this.productsEJB.updateProduct(createProductRequestDTO);
	}
	
	
	@GET
	@Path("/getDetailProduct")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ProductDetailResponseDTO> getDetailProduct(@QueryParam("idProduct") Integer idProduct) {
		
		RequestProductDetailDTO rpd = new RequestProductDetailDTO();
		rpd.setIdProduct(String.valueOf(idProduct));
		
		return this.productsEJB.getProductDetail(rpd);
	}
	
	

}