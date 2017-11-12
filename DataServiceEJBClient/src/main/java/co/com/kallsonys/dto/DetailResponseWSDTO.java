package co.com.kallsonys.dto;

import java.io.Serializable;

/**
 * Contiene la respuesta detalla de la invocacion de un servicio para clientes
 * externos de la aplicacion.
 * 
 * @author luis.forero (2015-11-12)
 * 
 */
public class DetailResponseWSDTO implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;

	private Boolean response;
	private String responseDescription;

	public Boolean getResponse() {
		return response;
	}

	public void setResponse(Boolean response) {
		this.response = response;
	}

	public String getResponseDescription() {
		return responseDescription;
	}

	public void setResponseDescription(String responseDescription) {
		this.responseDescription = responseDescription;
	}

}
