package co.com.kallsonys.dto;

import java.io.Serializable;

public class CampaignsProductsDTO implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private CampaignsDTO campaigns;
	private ProductsDTO products;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public CampaignsDTO getCampaigns() {
		return campaigns;
	}

	public void setCampaigns(CampaignsDTO campaigns) {
		this.campaigns = campaigns;
	}

	public ProductsDTO getProducts() {
		return products;
	}

	public void setProducts(ProductsDTO products) {
		this.products = products;
	}

}
