package co.com.kallsonys.dto;

import java.io.Serializable;

public class CategoriesDTO implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;


	private Integer id;
	private String category;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
