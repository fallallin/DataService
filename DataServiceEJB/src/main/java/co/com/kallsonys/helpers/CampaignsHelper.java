package co.com.kallsonys.helpers;

import java.util.ArrayList;
import java.util.List;

import co.com.kallsonys.dto.CampaignsDTO;
import co.com.kallsonys.entity.Campaigns;
import co.com.kallsonys.entity.Status;

public class CampaignsHelper {

    // --- to DTO
    public static CampaignsDTO toLevel0DTO(Campaigns entidad) {
        CampaignsDTO dto = new CampaignsDTO();
        dto.setId(entidad.getId());
        dto.setInitialvalitydate(entidad.getInitialvalitydate());
        dto.setFinalvalitydate(entidad.getFinalvalitydate());

        return dto;
    }

    public static CampaignsDTO toLevel1DTO(Campaigns entidad) {
        CampaignsDTO dto = toLevel0DTO(entidad);
        if (entidad.getStatus() != null)
            dto.setStatus(StatusHelper.toLevel0DTO(entidad.getStatus()));
        return dto;
    }

    public static List<CampaignsDTO> toListLevel0DTO(List<Campaigns> listEntidad) {
        List<CampaignsDTO> listDto = new ArrayList<CampaignsDTO>();
        for (Campaigns entidad : listEntidad) {
            listDto.add(toLevel0DTO(entidad));
        }
        return listDto;
    }

    public static List<CampaignsDTO> toListLevel1DTO(List<Campaigns> listEntidad) {
        List<CampaignsDTO> listDto = new ArrayList<CampaignsDTO>();
        for (Campaigns entidad : listEntidad) {
            listDto.add(toLevel1DTO(entidad));
        }
        return listDto;
    }

    // --- fin to DTO
    // --- to Entidad
    public static Campaigns toLevel0Entity(CampaignsDTO dto, Campaigns entidad) {
        if (null == entidad) {
            entidad = new Campaigns();
        }
        entidad.setId(dto.getId());
        entidad.setInitialvalitydate(dto.getInitialvalitydate());
        entidad.setFinalvalitydate(dto.getFinalvalitydate());

        return entidad;
    }

    public static Campaigns toLevel1Entity(CampaignsDTO dto, Campaigns entidad) {
        entidad = toLevel0Entity(dto, entidad);
        if (dto.getStatus() != null && dto.getStatus().getId() != null) {
            entidad.setStatus(new Status());
            entidad.getStatus().setId(dto.getStatus().getId());
        }

        return entidad;
    }

    public static List<Campaigns> toListLevel0Entity(List<CampaignsDTO> listDto) {
        List<Campaigns> listEntidad = new ArrayList<Campaigns>();
        for (CampaignsDTO dto : listDto) {
            listEntidad.add(toLevel0Entity(dto, null));
        }
        return listEntidad;
    }

    public static List<Campaigns> toListLevel1Entity(List<CampaignsDTO> listDto) {
        List<Campaigns> listEntidad = new ArrayList<Campaigns>();
        for (CampaignsDTO dto : listDto) {
            listEntidad.add(toLevel1Entity(dto, null));
        }
        return listEntidad;
    }
    // --- fin to Entidad

}
