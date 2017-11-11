package co.com.kallsonys.dto.response;

import java.io.Serializable;
import java.util.List;

public class GetProductByIdResponseDTO implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;

	private Boolean response;
	private String responseDescription;
	private List<ProductResponseDTO> listProducts;

	public Boolean getResponse() {
		return response;
	}

	public void setResponse(Boolean response) {
		this.response = response;
	}

	public String getResponseDescription() {
		return responseDescription;
	}

	public void setResponseDescription(String responseDescription) {
		this.responseDescription = responseDescription;
	}

	public List<ProductResponseDTO> getListProducts() {
		return listProducts;
	}

	public void setListProducts(List<ProductResponseDTO> listProducts) {
		this.listProducts = listProducts;
	}

}
