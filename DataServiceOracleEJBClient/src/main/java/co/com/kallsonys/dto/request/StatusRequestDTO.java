package co.com.kallsonys.dto.request;

import java.io.Serializable;

public class StatusRequestDTO implements Serializable,Cloneable
{
	private static final long serialVersionUID = 1L;

	private Integer idStatus;
	private String status;

	public Integer getIdStatus() {
		return idStatus;
	}

	public void setIdStatus(Integer idStatus) {
		this.idStatus = idStatus;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
