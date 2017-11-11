package co.com.kallsonys.helpers;

import java.util.ArrayList;
import java.util.List;

import co.com.kallsonys.dto.StatusDTO;
import co.com.kallsonys.entity.Status;

public class StatusHelper {

    // --- to DTO
    public static StatusDTO toLevel0DTO(Status entidad) {
        StatusDTO dto = new StatusDTO();
        dto.setId(entidad.getId());
        dto.setStatus(entidad.getStatus());

        return dto;
    }

    public static StatusDTO toLevel1DTO(Status entidad) {
        StatusDTO dto = toLevel0DTO(entidad);
        return dto;
    }

    public static List<StatusDTO> toListLevel0DTO(List<Status> listEntidad) {
        List<StatusDTO> listDto = new ArrayList<StatusDTO>();
        for (Status entidad : listEntidad) {
            listDto.add(toLevel0DTO(entidad));
        }
        return listDto;
    }

    public static List<StatusDTO> toListLevel1DTO(List<Status> listEntidad) {
        List<StatusDTO> listDto = new ArrayList<StatusDTO>();
        for (Status entidad : listEntidad) {
            listDto.add(toLevel1DTO(entidad));
        }
        return listDto;
    }

    // --- fin to DTO
    // --- to Entidad
    public static Status toLevel0Entity(StatusDTO dto, Status entidad) {
        if (null == entidad) {
            entidad = new Status();
        }
        entidad.setId(dto.getId());
        entidad.setStatus(dto.getStatus());

        return entidad;
    }

    public static Status toLevel1Entity(StatusDTO dto, Status entidad) {
        entidad = toLevel0Entity(dto, entidad);
        return entidad;
    }

    public static List<Status> toListLevel0Entity(List<StatusDTO> listDto) {
        List<Status> listEntidad = new ArrayList<Status>();
        for (StatusDTO dto : listDto) {
            listEntidad.add(toLevel0Entity(dto, null));
        }
        return listEntidad;
    }

    public static List<Status> toListLevel1Entity(List<StatusDTO> listDto) {
        List<Status> listEntidad = new ArrayList<Status>();
        for (StatusDTO dto : listDto) {
            listEntidad.add(toLevel1Entity(dto, null));
        }
        return listEntidad;
    }
    // --- fin to Entidad

}
