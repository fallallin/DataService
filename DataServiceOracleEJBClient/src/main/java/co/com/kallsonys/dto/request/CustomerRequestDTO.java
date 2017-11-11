package co.com.kallsonys.dto.request;

import java.io.Serializable;

import co.com.kallsonys.dto.response.CustomerTypeResponseDTO;
import co.com.kallsonys.dto.response.RolResponseDTO;
import co.com.kallsonys.dto.response.StatusResponseDTO;

public class CustomerRequestDTO implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	private String lastName;
	private String identification;
	private String email;
	private String phoneNumber;
	private String login;
	private String password;
	private StatusRequestDTO status;
	private RolRequestDTO rol;
	private CustomerTypeRequestDTO customerType;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getIdentification() {
		return identification;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public StatusRequestDTO getStatus() {
		return status;
	}

	public void setStatus(StatusRequestDTO status) {
		this.status = status;
	}

	public RolRequestDTO getRol() {
		return rol;
	}

	public void setRol(RolRequestDTO rol) {
		this.rol = rol;
	}

	public CustomerTypeRequestDTO getCustomerType() {
		return customerType;
	}

	public void setCustomerType(CustomerTypeRequestDTO customerType) {
		this.customerType = customerType;
	}

}
