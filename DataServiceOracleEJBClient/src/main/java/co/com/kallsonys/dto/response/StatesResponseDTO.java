package co.com.kallsonys.dto.response;

import java.io.Serializable;
import java.util.List;

public class StatesResponseDTO implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String state;
	private List<CitiesResponseDTO> listCities;

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

	public List<CitiesResponseDTO> getListCities() {
		return listCities;
	}

	public void setListCities(List<CitiesResponseDTO> listCities) {
		this.listCities = listCities;
	}

}
