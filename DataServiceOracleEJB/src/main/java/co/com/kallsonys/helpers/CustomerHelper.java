package co.com.kallsonys.helpers;

import co.com.kallsonys.dto.request.CustomerRequestDTO;
import co.com.kallsonys.dto.response.CustomerResponseDTO;
import co.com.kallsonys.dto.response.CustomerTypeResponseDTO;
import co.com.kallsonys.dto.response.RolResponseDTO;
import co.com.kallsonys.dto.response.StatusResponseDTO;
import co.com.kallsonys.entity.CustomerTypes;
import co.com.kallsonys.entity.Roles;
import co.com.kallsonys.entity.Status;
import co.com.kallsonys.entity.Users;

public class CustomerHelper {

	
	
	public static CustomerResponseDTO buildCustomerResponseDTO(Users user) {

		CustomerResponseDTO customerResponseDTO = new CustomerResponseDTO();

		customerResponseDTO.setId(user.getId());
		customerResponseDTO.setName(user.getName());
		customerResponseDTO.setLastName(user.getLastname());
		customerResponseDTO.setEmail(user.getEmail());
		customerResponseDTO.setPhoneNumber(user.getPhonenumber());
		customerResponseDTO.setLogin(user.getLogin());
		customerResponseDTO.setPassword(user.getPassword());

		customerResponseDTO.setStatus(new StatusResponseDTO());
		if (user.getStatus() != null) {
			customerResponseDTO.getStatus().setIdStatus(user.getStatus().getId());
			customerResponseDTO.getStatus().setStatus(user.getStatus().getStatus());
		}

		customerResponseDTO.setRol(new RolResponseDTO());
		if (user.getRol() != null) {
			customerResponseDTO.getRol().setIdRol(user.getRol().getId());
			customerResponseDTO.getRol().setRol(user.getRol().getRol());
		}

		customerResponseDTO.setCustomerType(new CustomerTypeResponseDTO());
		if (user.getCustomerType() != null) {
			customerResponseDTO.getCustomerType().setIdCustomerType(user.getCustomerType().getId());
			customerResponseDTO.getCustomerType().setCustomerType(user.getCustomerType().getUsertype());
		}

		return customerResponseDTO;
	}
	
	
	
	public static Users buildCustomerEntity(CustomerRequestDTO customerRequestDTO) {

		Users user = new Users();

		user.setId(customerRequestDTO.getId());
		user.setName(customerRequestDTO.getName());
		user.setLastname(customerRequestDTO.getLastName());
		user.setEmail(customerRequestDTO.getEmail());
		user.setPhonenumber(customerRequestDTO.getPhoneNumber());
		user.setLogin(customerRequestDTO.getLogin());
		user.setPassword(user.getPassword());

		user.setStatus(new Status());
		if (customerRequestDTO.getStatus() != null) {
			user.getStatus().setId(customerRequestDTO.getStatus().getIdStatus());
			user.getStatus().setStatus(customerRequestDTO.getStatus().getStatus());
		}

		user.setRol(new Roles());
		if (customerRequestDTO.getRol() != null) {
			user.getRol().setId(customerRequestDTO.getRol().getIdRol());
			user.getRol().setRol(customerRequestDTO.getRol().getRol());
		}

		user.setCustomerType(new CustomerTypes());
		if (customerRequestDTO.getCustomerType() != null) {
			user.getCustomerType().setId(customerRequestDTO.getCustomerType().getIdCustomerType());
			user.getCustomerType().setUsertype(customerRequestDTO.getCustomerType().getCustomerType());
		}

		return user;
	}
	
}
