package co.com.kallsonys.dto;

import java.io.Serializable;
import java.util.List;

public class StatesDTO implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String state;
	private CountryDTO country;

	private List<CitiesDTO> cityList;

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

	public CountryDTO getCountry() {
		return country;
	}

	public void setCountry(CountryDTO country) {
		this.country = country;
	}

	public List<CitiesDTO> getCityList() {
		return cityList;
	}

	public void setCityList(List<CitiesDTO> cityList) {
		this.cityList = cityList;
	}

}
