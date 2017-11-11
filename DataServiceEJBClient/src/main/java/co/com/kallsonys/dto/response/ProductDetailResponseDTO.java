package co.com.kallsonys.dto.response;

import java.io.Serializable;

/**
 * DTO para servicio de imposicion de consultar detalleproducto
 * 
 */
public class ProductDetailResponseDTO implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;

	private String name;
	private String description;
	private String price;
	private String externalidentifier;
	private String producer;
	private String category;
	private String urlImage;
	private String imageBase64;

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

	public String getExternalidentifier() {
		return externalidentifier;
	}

	public void setExternalidentifier(String externalidentifier) {
		this.externalidentifier = externalidentifier;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getUrlImage() {
		return urlImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}

	public String getImageBase64() {
		return imageBase64;
	}

	public void setImageBase64(String imageBase64) {
		this.imageBase64 = imageBase64;
	}

}
