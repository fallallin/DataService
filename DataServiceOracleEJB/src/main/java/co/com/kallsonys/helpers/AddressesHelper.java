package co.com.kallsonys.helpers;

import java.util.ArrayList;
import java.util.List;

import co.com.kallsonys.dto.AddressesDTO;
import co.com.kallsonys.dto.request.AddressesRequestDTO;
import co.com.kallsonys.dto.response.AddressesResponseDTO;
import co.com.kallsonys.dto.response.CitiesResponseDTO;
import co.com.kallsonys.dto.response.CountriesResponseDTO;
import co.com.kallsonys.dto.response.StatesResponseDTO;
import co.com.kallsonys.entity.Addresses;
import co.com.kallsonys.entity.Cities;
import co.com.kallsonys.entity.Country;
import co.com.kallsonys.entity.States;

public class AddressesHelper {

	// --- to DTO
	public static AddressesDTO toLevel0DTO(Addresses entidad) {
		AddressesDTO dto = new AddressesDTO();
		dto.setId(entidad.getId());
		dto.setAddress(entidad.getAddress());
		return dto;
	}

	public static AddressesDTO toLevel1DTO(Addresses entidad) {
		AddressesDTO dto = toLevel0DTO(entidad);
		if (entidad.getState() != null)
			dto.setState(StatesHelper.toLevel0DTO(entidad.getState()));
		if (entidad.getCity() != null)
			dto.setCity(CitiesHelper.toLevel0DTO(entidad.getCity()));
		if (entidad.getState() != null)
			dto.setCountry(CountryHelper.toLevel0DTO(entidad.getCountry()));
		return dto;
	}

	public static List<AddressesDTO> toListLevel0DTO(List<Addresses> listEntidad) {
		List<AddressesDTO> listDto = new ArrayList<AddressesDTO>();
		for (Addresses entidad : listEntidad) {
			listDto.add(toLevel0DTO(entidad));
		}
		return listDto;
	}

	public static List<AddressesDTO> toListLevel1DTO(List<Addresses> listEntidad) {
		List<AddressesDTO> listDto = new ArrayList<AddressesDTO>();
		for (Addresses entidad : listEntidad) {
			listDto.add(toLevel1DTO(entidad));
		}
		return listDto;
	}

	// --- fin to DTO
	// --- to Entidad
	public static Addresses toLevel0Entity(AddressesDTO dto, Addresses entidad) {
		if (null == entidad) {
			entidad = new Addresses();
		}
		entidad.setId(dto.getId());
		entidad.setAddress(dto.getAddress());
		return entidad;
	}

	public static Addresses toLevel1Entity(AddressesDTO dto, Addresses entidad) {
		entidad = toLevel0Entity(dto, entidad);
		if (dto.getState() != null && dto.getState().getId() != null) {
			entidad.setState(new States());
			entidad.getState().setId(dto.getState().getId());
		}
		if (dto.getCountry() != null && dto.getCountry().getId() != null) {
			entidad.setCountry(new Country());
			entidad.getCountry().setId(dto.getCountry().getId());
		}
		if (dto.getCity() != null && dto.getCity().getId() != null) {
			entidad.setCity(new Cities());
			entidad.getCity().setId(dto.getCity().getId());
		}

		return entidad;
	}

	public static List<Addresses> toListLevel0Entity(List<AddressesDTO> listDto) {
		List<Addresses> listEntidad = new ArrayList<Addresses>();
		for (AddressesDTO dto : listDto) {
			listEntidad.add(toLevel0Entity(dto, null));
		}
		return listEntidad;
	}

	public static List<Addresses> toListLevel1Entity(List<AddressesDTO> listDto) {
		List<Addresses> listEntidad = new ArrayList<Addresses>();
		for (AddressesDTO dto : listDto) {
			listEntidad.add(toLevel1Entity(dto, null));
		}
		return listEntidad;
	}
	// --- fin to Entidad

	public static AddressesResponseDTO buildAddressesResponseDTO(Addresses address) {
		AddressesResponseDTO addressesResponseDTO = new AddressesResponseDTO();

		addressesResponseDTO.setId((address.getId()));
		addressesResponseDTO.setAddress(address.getAddress());

		addressesResponseDTO.setCountry(new CountriesResponseDTO());
		if (address.getCountry() != null) {
			addressesResponseDTO.getCountry().setId(address.getCountry().getId());
			addressesResponseDTO.getCountry().setCountry(address.getCountry().getCountry());
		}

		addressesResponseDTO.setState(new StatesResponseDTO());
		if (address.getState() != null) {
			addressesResponseDTO.getState().setId(address.getState().getId());
			addressesResponseDTO.getState().setState(address.getState().getState());
		}

		addressesResponseDTO.setCity(new CitiesResponseDTO());
		if (address.getCity() != null) {
			addressesResponseDTO.getCity().setId(address.getCity().getId());
			addressesResponseDTO.getCity().setCity(address.getCity().getCity());
		}

		return addressesResponseDTO;

	}
	
	
	
	
	public static Addresses buildAddressesEntity(AddressesRequestDTO addressesRequestDTO) {
		Addresses addresses = new Addresses();

		addresses.setId((addressesRequestDTO.getId()));
		addresses.setAddress(addressesRequestDTO.getAddress());

		addresses.setCountry(new Country());
		if (addressesRequestDTO.getCountry() != null) {
			addresses.getCountry().setId(addressesRequestDTO.getCountry().getId());
			addresses.getCountry().setCountry(addressesRequestDTO.getCountry().getCountry());
		}

		addresses.setState(new States());
		if (addressesRequestDTO.getState() != null) {
			addresses.getState().setId(addressesRequestDTO.getState().getId());
			addresses.getState().setState(addressesRequestDTO.getState().getState());
		}

		addresses.setCity(new Cities());
		if (addressesRequestDTO.getCity() != null) {
			addresses.getCity().setId(addressesRequestDTO.getCity().getId());
			addresses.getCity().setCity(addressesRequestDTO.getCity().getCity());
		}

		return addresses;

	}
	
	
	public static AddressesResponseDTO ResquestToResponse(AddressesRequestDTO addressesRequestDTO) {
		AddressesResponseDTO addressesResponseDTO = new AddressesResponseDTO();

		addressesResponseDTO.setId((addressesRequestDTO.getId()));
		addressesResponseDTO.setAddress(addressesRequestDTO.getAddress());

		addressesResponseDTO.setCountry(new CountriesResponseDTO());
		if (addressesRequestDTO.getCountry() != null) {
			addressesResponseDTO.getCountry().setId(addressesRequestDTO.getCountry().getId());
			addressesResponseDTO.getCountry().setCountry(addressesRequestDTO.getCountry().getCountry());
		}

		addressesResponseDTO.setState(new StatesResponseDTO());
		if (addressesRequestDTO.getState() != null) {
			addressesResponseDTO.getState().setId(addressesRequestDTO.getState().getId());
			addressesResponseDTO.getState().setState(addressesRequestDTO.getState().getState());
		}

		addressesResponseDTO.setCity(new CitiesResponseDTO());
		if (addressesRequestDTO.getCity() != null) {
			addressesResponseDTO.getCity().setId(addressesRequestDTO.getCity().getId());
			addressesResponseDTO.getCity().setCity(addressesRequestDTO.getCity().getCity());
		}

		return addressesResponseDTO;
		
	}
	

}
