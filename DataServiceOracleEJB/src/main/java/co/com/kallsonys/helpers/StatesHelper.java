package co.com.kallsonys.helpers;

import java.util.ArrayList;
import java.util.List;

import co.com.kallsonys.dto.StatesDTO;
import co.com.kallsonys.entity.Country;
import co.com.kallsonys.entity.States;

public class StatesHelper {

	
	 // --- to DTO
    public static StatesDTO toLevel0DTO(States entidad) {
        StatesDTO dto = new StatesDTO();
        dto.setId(entidad.getId());
        dto.setState(entidad.getState());

        return dto;
    }

    public static StatesDTO toLevel1DTO(States entidad) {
        StatesDTO dto = toLevel0DTO(entidad);
        if (entidad.getCountry() != null)
            dto.setCountry(CountryHelper.toLevel0DTO(entidad.getCountry()));
        return dto;
    }

    public static List<StatesDTO> toListLevel0DTO(List<States> listEntidad) {
        List<StatesDTO> listDto = new ArrayList<StatesDTO>();
        for (States entidad : listEntidad) {
            listDto.add(toLevel0DTO(entidad));
        }
        return listDto;
    }

    public static List<StatesDTO> toListLevel1DTO(List<States> listEntidad) {
        List<StatesDTO> listDto = new ArrayList<StatesDTO>();
        for (States entidad : listEntidad) {
            listDto.add(toLevel1DTO(entidad));
        }
        return listDto;
    }

    // --- fin to DTO
    // --- to Entidad
    public static States toLevel0Entity(StatesDTO dto, States entidad) {
        if (null == entidad) {
            entidad = new States();
        }
        entidad.setId(dto.getId());
        entidad.setState(dto.getState());
        return entidad;
    }

    public static States toLevel1Entity(StatesDTO dto, States entidad) {
        entidad = toLevel0Entity(dto, entidad);
        if (dto.getCountry() != null && dto.getCountry().getId() != null) {
            entidad.setCountry(new Country());
            entidad.getCountry().setId(dto.getCountry().getId());
        }

        return entidad;
    }

    public static List<States> toListLevel0Entity(List<StatesDTO> listDto) {
        List<States> listEntidad = new ArrayList<States>();
        for (StatesDTO dto : listDto) {
            listEntidad.add(toLevel0Entity(dto, null));
        }
        return listEntidad;
    }

    public static List<States> toListLevel1Entity(List<StatesDTO> listDto) {
        List<States> listEntidad = new ArrayList<States>();
        for (StatesDTO dto : listDto) {
            listEntidad.add(toLevel1Entity(dto, null));
        }
        return listEntidad;
    }
    // --- fin to Entidad
	
}
