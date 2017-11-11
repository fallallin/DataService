package co.com.kallsonys.dto;

import java.io.Serializable;

public class ProductsDTO implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private String description;
	private String price;
	private Integer externalidentifier;
	private ProducersDTO idproducer;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public Integer getExternalidentifier() {
		return externalidentifier;
	}
	public void setExternalidentifier(Integer externalidentifier) {
		this.externalidentifier = externalidentifier;
	}
	public ProducersDTO getIdproducer() {
		return idproducer;
	}
	public void setIdproducer(ProducersDTO idproducer) {
		this.idproducer = idproducer;
	}
	
	
	
	
}
