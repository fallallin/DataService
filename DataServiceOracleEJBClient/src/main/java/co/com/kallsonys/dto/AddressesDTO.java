package co.com.kallsonys.dto;

import java.io.Serializable;

public class AddressesDTO implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String address;
	private CitiesDTO city;
	private StatesDTO state;
	private CountryDTO country;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public CitiesDTO getCity() {
		return city;
	}

	public void setCity(CitiesDTO city) {
		this.city = city;
	}

	public StatesDTO getState() {
		return state;
	}

	public void setState(StatesDTO state) {
		this.state = state;
	}

	public CountryDTO getCountry() {
		return country;
	}

	public void setCountry(CountryDTO country) {
		this.country = country;
	}

}
