package co.com.kallsonys.helpers;

import java.util.ArrayList;
import java.util.List;

import co.com.kallsonys.dto.RolesDTO;
import co.com.kallsonys.entity.Roles;

public class RolesHelper {
	   // --- to DTO
    public static RolesDTO toLevel0DTO(Roles entidad) {
        RolesDTO dto = new RolesDTO();
        dto.setId(entidad.getId());
        dto.setRol(entidad.getRol());

        return dto;
    }

    public static RolesDTO toLevel1DTO(Roles entidad) {
        RolesDTO dto = toLevel0DTO(entidad);
        return dto;
    }

    public static List<RolesDTO> toListLevel0DTO(List<Roles> listEntidad) {
        List<RolesDTO> listDto = new ArrayList<RolesDTO>();
        for (Roles entidad : listEntidad) {
            listDto.add(toLevel0DTO(entidad));
        }
        return listDto;
    }

    public static List<RolesDTO> toListLevel1DTO(List<Roles> listEntidad) {
        List<RolesDTO> listDto = new ArrayList<RolesDTO>();
        for (Roles entidad : listEntidad) {
            listDto.add(toLevel1DTO(entidad));
        }
        return listDto;
    }

    // --- fin to DTO
    // --- to Entidad
    public static Roles toLevel0Entity(RolesDTO dto, Roles entidad) {
        if (null == entidad) {
            entidad = new Roles();
        }
        entidad.setId(dto.getId());
        entidad.setRol(dto.getRol());

        return entidad;
    }

    public static Roles toLevel1Entity(RolesDTO dto, Roles entidad) {
        entidad = toLevel0Entity(dto, entidad);
        return entidad;
    }

    public static List<Roles> toListLevel0Entity(List<RolesDTO> listDto) {
        List<Roles> listEntidad = new ArrayList<Roles>();
        for (RolesDTO dto : listDto) {
            listEntidad.add(toLevel0Entity(dto, null));
        }
        return listEntidad;
    }

    public static List<Roles> toListLevel1Entity(List<RolesDTO> listDto) {
        List<Roles> listEntidad = new ArrayList<Roles>();
        for (RolesDTO dto : listDto) {
            listEntidad.add(toLevel1Entity(dto, null));
        }
        return listEntidad;
    }
    // --- fin to Entidad

}
