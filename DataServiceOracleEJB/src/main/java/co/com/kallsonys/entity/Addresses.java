package co.com.kallsonys.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Entity implementation class for Entity: Addresses
 *
 */
@XmlRootElement
@Entity
@Table(name = "addresses")
public class Addresses implements Entidad {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "address")
	private String address;

	@JoinColumn(name = "idcity", referencedColumnName = "id")
	@ManyToOne(fetch = FetchType.LAZY)
	private Cities city;

	@JoinColumn(name = "idstate", referencedColumnName = "id")
	@ManyToOne(fetch = FetchType.LAZY)
	private States state;

	@JoinColumn(name = "idcountry", referencedColumnName = "id")
	@ManyToOne(fetch = FetchType.LAZY)
	private Country country;

	public Addresses() {
		super();
	}

	public Addresses(Integer id, String address, Cities city, States state, Country country) {
		super();
		this.id = id;
		this.address = address;
		this.city = city;
		this.state = state;
		this.country = country;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Cities getCity() {
		return city;
	}

	public void setCity(Cities city) {
		this.city = city;
	}

	public States getState() {
		return state;
	}

	public void setState(States state) {
		this.state = state;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

}
