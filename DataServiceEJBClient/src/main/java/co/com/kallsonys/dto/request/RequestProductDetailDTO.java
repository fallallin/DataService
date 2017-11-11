package co.com.kallsonys.dto.request;

import java.io.Serializable;

/**
 * DTO
 * @author FALLALLIN
 */
@SuppressWarnings("serial")
public class RequestProductDetailDTO implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;
	
	String idProduct;

	public String getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(String idProduct) {
		this.idProduct = idProduct;
	}
	
	
	

}
