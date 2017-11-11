package co.com.kallsonys.helpers;

import java.util.ArrayList;
import java.util.List;

import co.com.kallsonys.dto.UsersDTO;
import co.com.kallsonys.entity.Roles;
import co.com.kallsonys.entity.Status;
import co.com.kallsonys.entity.Users;

public class UsersHelper {

	// --- to DTO
	public static UsersDTO toLevel0DTO(Users entidad) {
		UsersDTO dto = new UsersDTO();
		dto.setId(entidad.getId());
		dto.setName(entidad.getName());
		dto.setLastname(entidad.getLastname());
		dto.setEmail(entidad.getEmail());
		dto.setLogin(entidad.getPassword());
		dto.setLogin(entidad.getLogin());

		return dto;
	}

	public static UsersDTO toLevel1DTO(Users entidad) {
		UsersDTO dto = toLevel0DTO(entidad);
		if (entidad.getRol() != null)
			dto.setRol(RolesHelper.toLevel0DTO(entidad.getRol()));
		if (entidad.getStatus() != null)
			dto.setStatus(StatusHelper.toLevel0DTO(entidad.getStatus()));
		return dto;
	}

	public static List<UsersDTO> toListLevel0DTO(List<Users> listEntidad) {
		List<UsersDTO> listDto = new ArrayList<UsersDTO>();
		for (Users entidad : listEntidad) {
			listDto.add(toLevel0DTO(entidad));
		}
		return listDto;
	}

	public static List<UsersDTO> toListLevel1DTO(List<Users> listEntidad) {
		List<UsersDTO> listDto = new ArrayList<UsersDTO>();
		for (Users entidad : listEntidad) {
			listDto.add(toLevel1DTO(entidad));
		}
		return listDto;
	}

	// --- fin to DTO
	// --- to Entidad
	public static Users toLevel0Entity(UsersDTO dto, Users entidad) {
		if (null == entidad) {
			entidad = new Users();
		}
		entidad.setId(dto.getId());
		entidad.setName(dto.getName());
		entidad.setLastname(dto.getLastname());
		entidad.setEmail(dto.getEmail());
		entidad.setLogin(dto.getPassword());
		entidad.setLogin(dto.getLogin());

		return entidad;
	}

	public static Users toLevel1Entity(UsersDTO dto, Users entidad) {
		entidad = toLevel0Entity(dto, entidad);
		if (dto.getRol() != null && dto.getRol().getId() != null) {
			entidad.setRol(new Roles());
			entidad.getRol().setId(dto.getRol().getId());
		}
		if (dto.getStatus() != null && dto.getStatus().getId() != null) {
			entidad.setStatus(new Status());
			entidad.getStatus().setId(dto.getStatus().getId());
		}
		return entidad;
	}

	public static List<Users> toListLevel0Entity(List<UsersDTO> listDto) {
		List<Users> listEntidad = new ArrayList<Users>();
		for (UsersDTO dto : listDto) {
			listEntidad.add(toLevel0Entity(dto, null));
		}
		return listEntidad;
	}

	public static List<Users> toListLevel1Entity(List<UsersDTO> listDto) {
		List<Users> listEntidad = new ArrayList<Users>();
		for (UsersDTO dto : listDto) {
			listEntidad.add(toLevel1Entity(dto, null));
		}
		return listEntidad;
	}
	// --- fin to Entidad
}
