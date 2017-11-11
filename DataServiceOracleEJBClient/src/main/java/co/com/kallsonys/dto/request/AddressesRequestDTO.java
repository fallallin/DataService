package co.com.kallsonys.dto.request;

import java.io.Serializable;

public class AddressesRequestDTO implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String address;
	private CitiesRequestDTO city;
	private StatesRequestDTO state;
	private CountriesRequestDTO country;

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

	public CitiesRequestDTO getCity() {
		return city;
	}

	public void setCity(CitiesRequestDTO city) {
		this.city = city;
	}

	public StatesRequestDTO getState() {
		return state;
	}

	public void setState(StatesRequestDTO state) {
		this.state = state;
	}

	public CountriesRequestDTO getCountry() {
		return country;
	}

	public void setCountry(CountriesRequestDTO country) {
		this.country = country;
	}

}
