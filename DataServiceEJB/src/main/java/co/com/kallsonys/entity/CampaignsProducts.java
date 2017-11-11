package co.com.kallsonys.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "campaignsproducts")
public class CampaignsProducts {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
    @JoinColumn(name = "idcampaign", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
	private Campaigns campaigns;
	
    @JoinColumn(name = "idproduct", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
	private Products products;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Campaigns getCampaigns() {
		return campaigns;
	}

	public void setCampaigns(Campaigns campaigns) {
		this.campaigns = campaigns;
	}

	public Products getProducts() {
		return products;
	}

	public void setProducts(Products products) {
		this.products = products;
	}
    
}
