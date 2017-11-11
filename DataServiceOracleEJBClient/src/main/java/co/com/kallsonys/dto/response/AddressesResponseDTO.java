package co.com.kallsonys.dto.response;

import java.io.Serializable;

public class AddressesResponseDTO implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String address;
	private CitiesResponseDTO city;
	private StatesResponseDTO state;
	private CountriesResponseDTO country;

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

	public CitiesResponseDTO getCity() {
		return city;
	}

	public void setCity(CitiesResponseDTO city) {
		this.city = city;
	}

	public StatesResponseDTO getState() {
		return state;
	}

	public void setState(StatesResponseDTO state) {
		this.state = state;
	}

	public CountriesResponseDTO getCountry() {
		return country;
	}

	public void setCountry(CountriesResponseDTO country) {
		this.country = country;
	}

}
