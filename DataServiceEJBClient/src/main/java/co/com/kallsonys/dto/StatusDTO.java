package co.com.kallsonys.dto;

import java.io.Serializable;

public class StatusDTO implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String status;

	public StatusDTO(Integer id, String status) {
		super();
		this.id = id;
		this.status = status;
	}

	public StatusDTO() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
