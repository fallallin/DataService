package co.com.kallsonys.dto.response;

import java.io.Serializable;

public class CustomerResponseDTO implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	private String lastName;
	private String identification;
	private String email;
	private String phoneNumber;
	private String login;
	private String password;
	private StatusResponseDTO status;
	private RolResponseDTO rol;
	private CustomerTypeResponseDTO customerType;

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

	public StatusResponseDTO getStatus() {
		return status;
	}

	public void setStatus(StatusResponseDTO status) {
		this.status = status;
	}

	public RolResponseDTO getRol() {
		return rol;
	}

	public void setRol(RolResponseDTO rol) {
		this.rol = rol;
	}

	public CustomerTypeResponseDTO getCustomerType() {
		return customerType;
	}

	public void setCustomerType(CustomerTypeResponseDTO customerType) {
		this.customerType = customerType;
	}

}
