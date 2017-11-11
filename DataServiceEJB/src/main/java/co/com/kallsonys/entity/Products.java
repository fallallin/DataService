package co.com.kallsonys.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "products")
public class Products implements Entidad {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "price")
	private BigDecimal price;

	@Column(name = "externalidentifier")
	private Integer externalidentifier;

	@JoinColumn(name = "idproducer", referencedColumnName = "id")
	@ManyToOne(fetch = FetchType.LAZY)
	private Producers idproducer;
	
	@JoinColumn(name = "idstatus", referencedColumnName = "id")
	@ManyToOne(fetch = FetchType.LAZY)
	private Status status;

	@OneToMany(mappedBy = "products")
	private List<Images> listImages;

	public Products() {

	}

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

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getExternalidentifier() {
		return externalidentifier;
	}

	public void setExternalidentifier(Integer externalidentifier) {
		this.externalidentifier = externalidentifier;
	}

	public Producers getIdproducer() {
		return idproducer;
	}

	public void setIdproducer(Producers idproducer) {
		this.idproducer = idproducer;
	}

	public List<Images> getListImages() {
		return listImages;
	}

	public void setListImages(List<Images> listImages) {
		this.listImages = listImages;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	

}
