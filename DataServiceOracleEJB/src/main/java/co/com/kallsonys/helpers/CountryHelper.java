package co.com.kallsonys.helpers;

import java.util.ArrayList;
import java.util.List;

import co.com.kallsonys.dto.CountryDTO;
import co.com.kallsonys.entity.Country;

public class CountryHelper {
	   // --- to DTO
    public static CountryDTO toLevel0DTO(Country entidad) {
        CountryDTO dto = new CountryDTO();
        dto.setId(entidad.getId());
        dto.setCountry(entidad.getCountry());

        return dto;
    }

    public static CountryDTO toLevel1DTO(Country entidad) {
        CountryDTO dto = toLevel0DTO(entidad);
        return dto;
    }

    public static List<CountryDTO> toListLevel0DTO(List<Country> listEntidad) {
        List<CountryDTO> listDto = new ArrayList<CountryDTO>();
        for (Country entidad : listEntidad) {
            listDto.add(toLevel0DTO(entidad));
        }
        return listDto;
    }

    public static List<CountryDTO> toListLevel1DTO(List<Country> listEntidad) {
        List<CountryDTO> listDto = new ArrayList<CountryDTO>();
        for (Country entidad : listEntidad) {
            listDto.add(toLevel1DTO(entidad));
        }
        return listDto;
    }

    // --- fin to DTO
    // --- to Entidad
    public static Country toLevel0Entity(CountryDTO dto, Country entidad) {
        if (null == entidad) {
            entidad = new Country();
        }
        entidad.setId(dto.getId());
        entidad.setCountry(dto.getCountry());

        return entidad;
    }

    public static Country toLevel1Entity(CountryDTO dto, Country entidad) {
        entidad = toLevel0Entity(dto, entidad);
        return entidad;
    }

    public static List<Country> toListLevel0Entity(List<CountryDTO> listDto) {
        List<Country> listEntidad = new ArrayList<Country>();
        for (CountryDTO dto : listDto) {
            listEntidad.add(toLevel0Entity(dto, null));
        }
        return listEntidad;
    }

    public static List<Country> toListLevel1Entity(List<CountryDTO> listDto) {
        List<Country> listEntidad = new ArrayList<Country>();
        for (CountryDTO dto : listDto) {
            listEntidad.add(toLevel1Entity(dto, null));
        }
        return listEntidad;
    }
    // --- fin to Entidad

}
