package co.com.kallsonys.interfaces;

import java.util.List;

import javax.ejb.Local;

import co.com.kallsonys.dto.CountryDTO;
import co.com.kallsonys.dto.response.AllCountriesResponseDTO;



@Local
public interface ILLocation {
	
	/**
	 * 
	 * @return
	 */
	public AllCountriesResponseDTO getAllCountries();
	

}
