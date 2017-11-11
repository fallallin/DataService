package co.com.kallsonys.dto.response;

import java.io.Serializable;

public class CreateProducResponseDTO implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;

	private String response;
	private Integer idProduct;

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public Integer getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(Integer idProduct) {
		this.idProduct = idProduct;
	}

}
