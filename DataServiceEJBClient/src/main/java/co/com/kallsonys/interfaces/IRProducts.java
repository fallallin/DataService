package co.com.kallsonys.interfaces;

import java.util.List;

import javax.ejb.Remote;

import co.com.kallsonys.dto.request.CreateProductRequestDTO;
import co.com.kallsonys.dto.request.RequestProductDetailDTO;
import co.com.kallsonys.dto.response.CreateProducResponseDTO;
import co.com.kallsonys.dto.response.GetProductByIdResponseDTO;
import co.com.kallsonys.dto.response.ProductDetailResponseDTO;

@Remote
public interface IRProducts {

	/**
	 * 
	 * @param requestProductDetail
	 * @return
	 * @author FALLALLIN
	 */
	public List<ProductDetailResponseDTO> getProductDetail(RequestProductDetailDTO requestProductDetail) ;
	
	/**
	 * 
	 * @param productRequest
	 * @return
	 * @author FALLALLIN
	 */
	public CreateProductRequestDTO createProduct(CreateProductRequestDTO  productRequest);
	
	/**
	 * 
	 * @param idProduct
	 * @return
	 * @author FALLALLIN
	 */
	public GetProductByIdResponseDTO getProductById(Integer idProduct);
	
	/**
	 * 
	 * @param productRequest
	 * @return
	 * @author FALLALLIN
	 */
	public CreateProductRequestDTO updateProduct(CreateProductRequestDTO productRequest);
}