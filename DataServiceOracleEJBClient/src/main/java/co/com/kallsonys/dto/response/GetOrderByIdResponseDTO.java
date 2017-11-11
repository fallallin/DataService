package co.com.kallsonys.dto.response;

import java.io.Serializable;

public class GetOrderByIdResponseDTO implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;

	private Boolean response;
	private String responseDescription;
	private OrderRelationResponseDTO orderRelation;

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

	public OrderRelationResponseDTO getOrderRelation() {
		return orderRelation;
	}

	public void setOrderRelation(OrderRelationResponseDTO orderRelation) {
		this.orderRelation = orderRelation;
	}

}
