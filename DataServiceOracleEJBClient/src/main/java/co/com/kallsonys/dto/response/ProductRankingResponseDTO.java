package co.com.kallsonys.dto.response;

import java.io.Serializable;

public class ProductRankingResponseDTO implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;

	private Integer idProduct;
	private Integer quantity;

	public Integer getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(Integer idProduct) {
		this.idProduct = idProduct;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}
