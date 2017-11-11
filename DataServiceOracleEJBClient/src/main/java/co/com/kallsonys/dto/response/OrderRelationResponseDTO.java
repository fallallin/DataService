package co.com.kallsonys.dto.response;

import java.io.Serializable;

public class OrderRelationResponseDTO implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;

	private OrderResponseDTO order;
	private CustomerResponseDTO customer;

	public OrderResponseDTO getOrder() {
		return order;
	}

	public void setOrder(OrderResponseDTO order) {
		this.order = order;
	}

	public CustomerResponseDTO getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerResponseDTO customer) {
		this.customer = customer;
	}

}
