package co.com.kallsonys.dto.response;

import java.io.Serializable;
import java.util.List;

public class RankingResponseDTO implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;

	private Boolean response;
	private String responseDescription;
	List<ProductRankingResponseDTO> lstProducts;

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

	public List<ProductRankingResponseDTO> getLstProducts() {
		return lstProducts;
	}

	public void setLstProducts(List<ProductRankingResponseDTO> lstProducts) {
		this.lstProducts = lstProducts;
	}

}
