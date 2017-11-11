package co.com.kallsonys.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "users")
public class Users implements Entidad {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_seq")
	@SequenceGenerator(name = "users_seq", sequenceName = "users_seq", allocationSize = 1)
	@Column(name = "id")
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "lastname")
	private String lastname;

	@Column(name = "identification")
	private String identification;

	@Column(name = "email")
	private String email;

	@Column(name = "phonenumber")
	private String phonenumber;

	@Column(name = "login")
	private String login;

	@Column(name = "password")
	private String password;

	@JoinColumn(name = "idstatus", referencedColumnName = "id")
	@ManyToOne(fetch = FetchType.LAZY)
	private Status status;

	@JoinColumn(name = "idRol", referencedColumnName = "id")
	@ManyToOne(fetch = FetchType.LAZY)
	private Roles rol;

	@JoinColumn(name = "idcustomertype", referencedColumnName = "id")
	@ManyToOne(fetch = FetchType.LAZY)
	private CustomerTypes customerType;

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

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
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

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Roles getRol() {
		return rol;
	}

	public void setRol(Roles rol) {
		this.rol = rol;
	}

	public CustomerTypes getCustomerType() {
		return customerType;
	}

	public void setCustomerType(CustomerTypes customerType) {
		this.customerType = customerType;
	}

	public String getIdentification() {
		return identification;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}

}
