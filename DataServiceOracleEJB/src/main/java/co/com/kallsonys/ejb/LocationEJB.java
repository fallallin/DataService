package co.com.kallsonys.ejb;

import java.lang.Thread.State;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.logging.Logger;

import co.com.kallsonys.dto.CitiesDTO;
import co.com.kallsonys.dto.CountryDTO;
import co.com.kallsonys.dto.StatesDTO;
import co.com.kallsonys.dto.response.AllCountriesResponseDTO;
import co.com.kallsonys.dto.response.CitiesResponseDTO;
import co.com.kallsonys.dto.response.CountriesResponseDTO;
import co.com.kallsonys.dto.response.StatesResponseDTO;
import co.com.kallsonys.entity.Cities;
import co.com.kallsonys.entity.Country;
import co.com.kallsonys.entity.States;
import co.com.kallsonys.helpers.CitiesHelper;
import co.com.kallsonys.helpers.CountryHelper;
import co.com.kallsonys.helpers.StatesHelper;
import co.com.kallsonys.interfaces.ILLocation;
import co.com.kallsonys.interfaces.IRLocation;
import co.com.kallsonys.util.GenericDao;

/**
 * Session Bean implementation class ImposicionISEJB
 */
@Stateless(name = "LocationEJB")
@LocalBean
public class LocationEJB implements ILLocation, IRLocation {

	private final static Logger logger = Logger.getLogger(LocationEJB.class.getName());

	@PersistenceContext(unitName = "persistenceUnitOracle")
	private EntityManager em;

	@Override
	public AllCountriesResponseDTO getAllCountries() {
		logger.debug(LocationEJB.class.getName().concat("::getAllCountries()"));

		AllCountriesResponseDTO allCountriesResponseDTO = new AllCountriesResponseDTO();

		StringBuilder jpql = new StringBuilder();
		Map<String, Object> filtros = new HashMap<>();
		jpql.append("SELECT c FROM Country c");
		jpql.append(" LEFT JOIN FETCH c.stateList sl");
		// jpql.append(" LEFT JOIN FETCH sl.cityList cl");
		jpql.append(" WHERE 1 = 1");

		GenericDao<Country> dao = new GenericDao<Country>(Country.class, em);
		List<Country> resultadoConsulta = dao.buildAndExecuteQuery(jpql, filtros);

		List<CountriesResponseDTO> lstCountriesResponseDTO = new ArrayList<CountriesResponseDTO>();
		CountriesResponseDTO countriesResponseDTO = new CountriesResponseDTO();

		if (resultadoConsulta.isEmpty()) {

			allCountriesResponseDTO.setResponse(false);
			allCountriesResponseDTO.setResponseDescription("failed");
			allCountriesResponseDTO.setListCountries(lstCountriesResponseDTO);
			return allCountriesResponseDTO;
		}

		List<StatesResponseDTO> lstStatesResponseDTO = new ArrayList<StatesResponseDTO>();
		StatesResponseDTO statesResponseDTO = new StatesResponseDTO();

		for (Country country : resultadoConsulta) {
			countriesResponseDTO = new CountriesResponseDTO();

			countriesResponseDTO.setId(country.getId());
			countriesResponseDTO.setCountry(country.getCountry());

			lstStatesResponseDTO = new ArrayList<StatesResponseDTO>();

			for (States state : country.getStateList()) {

				statesResponseDTO = new StatesResponseDTO();
				statesResponseDTO.setId(state.getId());
				statesResponseDTO.setState(state.getState());
				statesResponseDTO.setListCities(this.getCityByIdState(state.getId()));
				lstStatesResponseDTO.add(statesResponseDTO);
			}

			countriesResponseDTO.setListStates(lstStatesResponseDTO);

			lstCountriesResponseDTO.add(countriesResponseDTO);
		}

		allCountriesResponseDTO.setResponse(true);
		allCountriesResponseDTO.setResponseDescription("success");
		allCountriesResponseDTO.setListCountries(lstCountriesResponseDTO);

		return allCountriesResponseDTO;
	}

	private List<CitiesResponseDTO> getCityByIdState(Integer idState) {

		logger.debug(LocationEJB.class.getName().concat("::getCityByIdState(Integer)"));
		StringBuilder jpql = new StringBuilder();
		Map<String, Object> filtros = new HashMap<>();
		jpql.append("SELECT c FROM Cities c");
		jpql.append(" LEFT JOIN c.state s");
		jpql.append(" WHERE s.id = :idState");
		filtros.put("idState", idState);

		GenericDao<Cities> dao = new GenericDao<Cities>(Cities.class, em);
		List<Cities> resultadoConsulta = dao.buildAndExecuteQuery(jpql, filtros);
		if (resultadoConsulta.isEmpty()) {
			return new ArrayList<CitiesResponseDTO>();
		}

		CitiesResponseDTO citiesResponseDTO = new CitiesResponseDTO();
		List<CitiesResponseDTO> lstCitiesResponseDTO = new ArrayList<CitiesResponseDTO>();

		for (Cities city : resultadoConsulta) {

			citiesResponseDTO = new CitiesResponseDTO();

			citiesResponseDTO.setId(city.getId());
			citiesResponseDTO.setCity(city.getCity());

			lstCitiesResponseDTO.add(citiesResponseDTO);
		}

		return lstCitiesResponseDTO;

	}

}
