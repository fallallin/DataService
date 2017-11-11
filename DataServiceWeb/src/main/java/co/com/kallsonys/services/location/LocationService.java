package co.com.kallsonys.services.location;



import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import co.com.kallsonys.dto.response.AllCountriesResponseDTO;
import co.com.kallsonys.interfaces.IRLocation;

@Path("/locationService")
@Stateless
public class LocationService {
	
    @EJB(
            lookup = "java:global/DataServiceEAR/DataServiceOracleEJB/LocationEJB!co.com.kallsonys.interfaces.IRLocation")
    IRLocation locationEJB;
    
    
	
	@GET
	@Path("/getAllConutries")
	@Produces(MediaType.APPLICATION_JSON)
	public AllCountriesResponseDTO getProducts() {
		return this.locationEJB.getAllCountries();
	}

}
