package co.com.kallsonys.dto.request;

import java.io.Serializable;

public class RolRequestDTO implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;

	private Integer idRol;
	private String rol;

	public Integer getIdRol() {
		return idRol;
	}

	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

}
