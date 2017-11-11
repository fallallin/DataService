package co.com.kallsonys.dto.response;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class ProductResponseDTO implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	private String description;
	private BigDecimal price;
	private Integer externalIdentifier;
	private ProducerResponseDTO producer;
	private List<String> images;

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

	public Integer getExternalIdentifier() {
		return externalIdentifier;
	}

	public void setExternalIdentifier(Integer externalIdentifier) {
		this.externalIdentifier = externalIdentifier;
	}

	public List<String> getImages() {
		return images;
	}

	public void setImages(List<String> images) {
		this.images = images;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public ProducerResponseDTO getProducer() {
		return producer;
	}

	public void setProducer(ProducerResponseDTO producer) {
		this.producer = producer;
	}

}
