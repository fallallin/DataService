package co.com.kallsonys.dto;

import java.io.Serializable;

public class ImagesDTO implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String finalpath;
	private String base64;
	private ProductsDTO products;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFinalpath() {
		return finalpath;
	}

	public String getBase64() {
		return base64;
	}

	public void setBase64(String base64) {
		this.base64 = base64;
	}

	public void setFinalpath(String finalpath) {
		this.finalpath = finalpath;
	}

	public ProductsDTO getProducts() {
		return products;
	}

	public void setProducts(ProductsDTO products) {
		this.products = products;
	}

}
