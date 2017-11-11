package co.com.kallsonys.dto.response;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class OrderResponseDTO implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Date orderDate;
	private BigDecimal price;
	private String comments;
	private StatusResponseDTO status;
	private AddressesResponseDTO address;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public StatusResponseDTO getStatus() {
		return status;
	}

	public void setStatus(StatusResponseDTO status) {
		this.status = status;
	}

	public AddressesResponseDTO getAddress() {
		return address;
	}

	public void setAddress(AddressesResponseDTO address) {
		this.address = address;
	}

}
