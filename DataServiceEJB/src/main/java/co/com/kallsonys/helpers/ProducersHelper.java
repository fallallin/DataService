package co.com.kallsonys.helpers;

import java.util.ArrayList;
import java.util.List;

import co.com.kallsonys.dto.ProducersDTO;
import co.com.kallsonys.entity.Producers;

public class ProducersHelper {

	
	 // --- to DTO
    public static ProducersDTO toLevel0DTO(Producers entidad) {
        ProducersDTO dto = new ProducersDTO();
        dto.setId(entidad.getId());
        dto.setProducer(entidad.getProducer());

        return dto;
    }

    public static ProducersDTO toLevel1DTO(Producers entidad) {
        ProducersDTO dto = toLevel0DTO(entidad);
        return dto;
    }

    public static List<ProducersDTO> toListLevel0DTO(List<Producers> listEntidad) {
        List<ProducersDTO> listDto = new ArrayList<ProducersDTO>();
        for (Producers entidad : listEntidad) {
            listDto.add(toLevel0DTO(entidad));
        }
        return listDto;
    }

    public static List<ProducersDTO> toListLevel1DTO(List<Producers> listEntidad) {
        List<ProducersDTO> listDto = new ArrayList<ProducersDTO>();
        for (Producers entidad : listEntidad) {
            listDto.add(toLevel1DTO(entidad));
        }
        return listDto;
    }

    // --- fin to DTO
    // --- to Entidad
    public static Producers toLevel0Entity(ProducersDTO dto, Producers entidad) {
        if (null == entidad) {
            entidad = new Producers();
        }
        entidad.setId(dto.getId());
        entidad.setProducer(dto.getProducer());
        return entidad;
    }

    public static Producers toLevel1Entity(ProducersDTO dto, Producers entidad) {
        entidad = toLevel0Entity(dto, entidad);
        return entidad;
    }

    public static List<Producers> toListLevel0Entity(List<ProducersDTO> listDto) {
        List<Producers> listEntidad = new ArrayList<Producers>();
        for (ProducersDTO dto : listDto) {
            listEntidad.add(toLevel0Entity(dto, null));
        }
        return listEntidad;
    }

    public static List<Producers> toListLevel1Entity(List<ProducersDTO> listDto) {
        List<Producers> listEntidad = new ArrayList<Producers>();
        for (ProducersDTO dto : listDto) {
            listEntidad.add(toLevel1Entity(dto, null));
        }
        return listEntidad;
    }
	
	
}
