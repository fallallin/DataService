package co.com.kallsonys.helpers;

import java.util.ArrayList;
import java.util.List;

import co.com.kallsonys.dto.CitiesDTO;
import co.com.kallsonys.entity.Cities;
import co.com.kallsonys.entity.States;

public class CitiesHelper {

	
    // --- to DTO
    public static CitiesDTO toLevel0DTO(Cities entidad) {
        CitiesDTO dto = new CitiesDTO();
        dto.setId(entidad.getId());
        dto.setCity(entidad.getCity());
        return dto;
    }

    public static CitiesDTO toLevel1DTO(Cities entidad) {
        CitiesDTO dto = toLevel0DTO(entidad);
        if (entidad.getState() != null)
            dto.setState(StatesHelper.toLevel0DTO(entidad.getState()));
        return dto;
    }

    public static List<CitiesDTO> toListLevel0DTO(List<Cities> listEntidad) {
        List<CitiesDTO> listDto = new ArrayList<CitiesDTO>();
        for (Cities entidad : listEntidad) {
            listDto.add(toLevel0DTO(entidad));
        }
        return listDto;
    }

    public static List<CitiesDTO> toListLevel1DTO(List<Cities> listEntidad) {
        List<CitiesDTO> listDto = new ArrayList<CitiesDTO>();
        for (Cities entidad : listEntidad) {
            listDto.add(toLevel1DTO(entidad));
        }
        return listDto;
    }

    // --- fin to DTO
    // --- to Entidad
    public static Cities toLevel0Entity(CitiesDTO dto, Cities entidad) {
        if (null == entidad) {
            entidad = new Cities();
        }
        entidad.setId(dto.getId());
        entidad.setCity(dto.getCity());
        return entidad;
    }

    public static Cities toLevel1Entity(CitiesDTO dto, Cities entidad) {
        entidad = toLevel0Entity(dto, entidad);
        if (dto.getState() != null && dto.getState().getId() != null) {
            entidad.setState(new States());
            entidad.getState().setId(dto.getState().getId());
        }

        return entidad;
    }

    public static List<Cities> toListLevel0Entity(List<CitiesDTO> listDto) {
        List<Cities> listEntidad = new ArrayList<Cities>();
        for (CitiesDTO dto : listDto) {
            listEntidad.add(toLevel0Entity(dto, null));
        }
        return listEntidad;
    }

    public static List<Cities> toListLevel1Entity(List<CitiesDTO> listDto) {
        List<Cities> listEntidad = new ArrayList<Cities>();
        for (CitiesDTO dto : listDto) {
            listEntidad.add(toLevel1Entity(dto, null));
        }
        return listEntidad;
    }
    // --- fin to Entidad
}
