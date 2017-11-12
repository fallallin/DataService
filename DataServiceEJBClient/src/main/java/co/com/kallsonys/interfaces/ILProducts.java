package co.com.kallsonys.interfaces;

import java.util.List;

import javax.ejb.Local;

import co.com.kallsonys.dto.request.CreateProductRequestDTO;
import co.com.kallsonys.dto.request.GetCategByLstIdProductRequestDTO;
import co.com.kallsonys.dto.request.RequestProductDetailDTO;
import co.com.kallsonys.dto.response.GetCategoriesByLstIdProductResponseDTO;
import co.com.kallsonys.dto.response.GetProductByIdResponseDTO;
import co.com.kallsonys.dto.response.ProductDetailResponseDTO;

@Local
public interface ILProducts {
	
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
	
	/**
	 * 
	 * @param request
	 * @return
	 * @author FALLALLIN
	 */
	public GetCategoriesByLstIdProductResponseDTO getCategByLstIdProduct(GetCategByLstIdProductRequestDTO request);
}
