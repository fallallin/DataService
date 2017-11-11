package co.com.kallsonys.dto;

import java.io.Serializable;
import java.util.List;

public class CountryDTO implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String country;
	
    private List<StatesDTO> stateList;

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

	public List<StatesDTO> getStateList() {
		return stateList;
	}

	public void setStateList(List<StatesDTO> stateList) {
		this.stateList = stateList;
	}

	
	
}
