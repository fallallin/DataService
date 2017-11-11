package co.com.kallsonys.interfaces;

import java.util.List;
import javax.ejb.Remote;

import co.com.kallsonys.dto.CountryDTO;
import co.com.kallsonys.dto.response.AllCountriesResponseDTO;

@Remote
public interface IRLocation {

	/**
	 * 
	 * @return
	 */
	public AllCountriesResponseDTO getAllCountries();

}
