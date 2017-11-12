package co.com.kallsonys.dto.response;

import java.io.Serializable;

public class GetCategByLstIdProductResponseDTO implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;

	private String category;
	private Integer quantity;
	private Integer id;

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
