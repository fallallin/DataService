package co.com.kallsonys.dto.response;

import java.io.Serializable;
import java.util.List;

public class CountriesResponseDTO implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String country;
	private List<StatesResponseDTO> listStates;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public List<StatesResponseDTO> getListStates() {
		return listStates;
	}

	public void setListStates(List<StatesResponseDTO> listStates) {
		this.listStates = listStates;
	}

}
