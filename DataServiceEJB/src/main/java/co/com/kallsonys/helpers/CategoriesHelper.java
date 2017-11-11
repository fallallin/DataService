package co.com.kallsonys.helpers;

import java.util.ArrayList;
import java.util.List;

import co.com.kallsonys.dto.CategoriesDTO;
import co.com.kallsonys.entity.Categories;

public class CategoriesHelper {

    // --- to DTO
    public static CategoriesDTO toLevel0DTO(Categories entidad) {
        CategoriesDTO dto = new CategoriesDTO();
        dto.setId(entidad.getId());
        dto.setCategory(entidad.getCategory());

        return dto;
    }

    public static CategoriesDTO toLevel1DTO(Categories entidad) {
        CategoriesDTO dto = toLevel0DTO(entidad);
        return dto;
    }

    public static List<CategoriesDTO> toListLevel0DTO(List<Categories> listEntidad) {
        List<CategoriesDTO> listDto = new ArrayList<CategoriesDTO>();
        for (Categories entidad : listEntidad) {
            listDto.add(toLevel0DTO(entidad));
        }
        return listDto;
    }

    public static List<CategoriesDTO> toListLevel1DTO(List<Categories> listEntidad) {
        List<CategoriesDTO> listDto = new ArrayList<CategoriesDTO>();
        for (Categories entidad : listEntidad) {
            listDto.add(toLevel1DTO(entidad));
        }
        return listDto;
    }

    // --- fin to DTO
    // --- to Entidad
    public static Categories toLevel0Entity(CategoriesDTO dto, Categories entidad) {
        if (null == entidad) {
            entidad = new Categories();
        }
        entidad.setId(dto.getId());
        entidad.setCategory(dto.getCategory());

        return entidad;
    }

    public static Categories toLevel1Entity(CategoriesDTO dto, Categories entidad) {
        entidad = toLevel0Entity(dto, entidad);
        return entidad;
    }

    public static List<Categories> toListLevel0Entity(List<CategoriesDTO> listDto) {
        List<Categories> listEntidad = new ArrayList<Categories>();
        for (CategoriesDTO dto : listDto) {
            listEntidad.add(toLevel0Entity(dto, null));
        }
        return listEntidad;
    }

    public static List<Categories> toListLevel1Entity(List<CategoriesDTO> listDto) {
        List<Categories> listEntidad = new ArrayList<Categories>();
        for (CategoriesDTO dto : listDto) {
            listEntidad.add(toLevel1Entity(dto, null));
        }
        return listEntidad;
    }
    // --- fin to Entidad
}
