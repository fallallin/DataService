package co.com.kallsonys.dto.response;

import java.io.Serializable;

public class CreateCampaignResponseDTO implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;

	private String response;
	private Integer idProduct;
	private Boolean status;

	public CreateCampaignResponseDTO() {
		super();

	}

	public CreateCampaignResponseDTO(String response, Integer idProduct, Boolean status) {
		super();
		this.response = response;
		this.idProduct = idProduct;
		this.status = status;
	}

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

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

}
