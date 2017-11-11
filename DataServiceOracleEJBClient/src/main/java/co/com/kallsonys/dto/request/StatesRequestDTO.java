package co.com.kallsonys.dto.request;

import java.io.Serializable;
import java.util.List;

import co.com.kallsonys.dto.response.CitiesResponseDTO;

public class StatesRequestDTO implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String state;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
