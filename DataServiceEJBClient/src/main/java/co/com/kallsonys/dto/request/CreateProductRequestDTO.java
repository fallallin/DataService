package co.com.kallsonys.dto.request;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class CreateProductRequestDTO implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private BigDecimal price;
	private String name;
	private String description;
	private Integer externalIdentifier;
	private String status;
	private Integer idStatus;
	private String producer;
	private Integer idProducer;
	private List<String> images;
	private List<Integer> idImages;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
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

	public Integer getExternalIdentifier() {
		return externalIdentifier;
	}

	public void setExternalIdentifier(Integer externalIdentifier) {
		this.externalIdentifier = externalIdentifier;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getIdStatus() {
		return idStatus;
	}

	public void setIdStatus(Integer idStatus) {
		this.idStatus = idStatus;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public Integer getIdProducer() {
		return idProducer;
	}

	public void setIdProducer(Integer idProducer) {
		this.idProducer = idProducer;
	}

	public List<String> getImages() {
		return images;
	}

	public void setImages(List<String> images) {
		this.images = images;
	}

	public List<Integer> getIdImages() {
		return idImages;
	}

	public void setIdImages(List<Integer> idImages) {
		this.idImages = idImages;
	}

}
