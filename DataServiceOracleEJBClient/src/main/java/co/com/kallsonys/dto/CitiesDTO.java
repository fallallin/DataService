package co.com.kallsonys.dto;

import java.io.Serializable;

public class CitiesDTO implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String city;
	private StatesDTO state;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public StatesDTO getState() {
		return state;
	}

	public void setState(StatesDTO state) {
		this.state = state;
	}

}
