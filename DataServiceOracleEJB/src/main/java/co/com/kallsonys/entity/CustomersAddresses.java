package co.com.kallsonys.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author FALLALLIN
 *
 */
@XmlRootElement
@Entity
@Table(name = "customersaddresses")
public class CustomersAddresses implements Entidad {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@JoinColumn(name = "idaddress", referencedColumnName = "id")
	@ManyToOne(fetch = FetchType.LAZY)
	private Addresses address;

	@JoinColumn(name = "idcustomer", referencedColumnName = "id")
	@ManyToOne(fetch = FetchType.LAZY)
	private Users customer;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Addresses getAddress() {
		return address;
	}

	public void setAddress(Addresses address) {
		this.address = address;
	}

	public Users getCustomer() {
		return customer;
	}

	public void setCustomer(Users customer) {
		this.customer = customer;
	}

}
