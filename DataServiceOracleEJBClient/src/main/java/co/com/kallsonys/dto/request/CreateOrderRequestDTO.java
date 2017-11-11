package co.com.kallsonys.dto.request;

import java.io.Serializable;
import java.util.List;

import co.com.kallsonys.dto.request.CustomerRequestDTO;
import co.com.kallsonys.dto.request.OrderRequestDTO;

public class CreateOrderRequestDTO implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;

	private CustomerRequestDTO customer;
	private OrderRequestDTO order;
	private List<ItemRequestDTO> listItems;

	public CustomerRequestDTO getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerRequestDTO customer) {
		this.customer = customer;
	}

	public OrderRequestDTO getOrder() {
		return order;
	}

	public void setOrder(OrderRequestDTO order) {
		this.order = order;
	}

	public List<ItemRequestDTO> getListItems() {
		return listItems;
	}

	public void setListItems(List<ItemRequestDTO> listItems) {
		this.listItems = listItems;
	}

}
