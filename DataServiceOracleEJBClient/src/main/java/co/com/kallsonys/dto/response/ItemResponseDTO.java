package co.com.kallsonys.dto.response;

import java.io.Serializable;
import java.math.BigDecimal;


public class ItemResponseDTO  implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;


	private Integer id;
	private String externalIdentifier;
	private BigDecimal price;
	private Integer quantity;
	private Integer partNum;
	private OrderResponseDTO order;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getExternalIdentifier() {
		return externalIdentifier;
	}

	public void setExternalIdentifier(String externalIdentifier) {
		this.externalIdentifier = externalIdentifier;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getPartNum() {
		return partNum;
	}

	public void setPartNum(Integer partNum) {
		this.partNum = partNum;
	}

	public OrderResponseDTO getOrder() {
		return order;
	}

	public void setOrder(OrderResponseDTO order) {
		this.order = order;
	}

}
