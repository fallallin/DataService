package co.com.kallsonys.dto;

import java.io.Serializable;

public class ProductsCategoriesDTO implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private ProductsDTO products;
	private CategoriesDTO category;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ProductsDTO getProducts() {
		return products;
	}

	public void setProducts(ProductsDTO products) {
		this.products = products;
	}

	public CategoriesDTO getCategory() {
		return category;
	}

	public void setCategory(CategoriesDTO category) {
		this.category = category;
	}

}
