package co.com.kallsonys.dto.response;

import java.io.Serializable;

public class SetCustomerResponseDTO implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;

	private Boolean response;
	private String responseDescription;
	private CustomerResponseDTO customer;

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

	public CustomerResponseDTO getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerResponseDTO customer) {
		this.customer = customer;
	}

}
