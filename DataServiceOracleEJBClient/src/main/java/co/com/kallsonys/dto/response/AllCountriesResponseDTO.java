package co.com.kallsonys.dto.response;

import java.io.Serializable;
import java.util.List;

public class AllCountriesResponseDTO implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;

	private Boolean response;
	private String responseDescription;
	private List<CountriesResponseDTO> listCountries;

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

	public List<CountriesResponseDTO> getListCountries() {
		return listCountries;
	}

	public void setListCountries(List<CountriesResponseDTO> listCountries) {
		this.listCountries = listCountries;
	}

}
