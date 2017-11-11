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
@Table(name = "customersorders")
public class CustomersOrders implements Entidad {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator="customersorders_seq")
	@SequenceGenerator(name="customersorders_seq", sequenceName="customersorders_seq", allocationSize=1)
	@Column(name = "id")
	private Integer id;

	@JoinColumn(name = "idorder", referencedColumnName = "id")
	@ManyToOne(fetch = FetchType.LAZY)
	private Orders order;

	@JoinColumn(name = "idcustomer", referencedColumnName = "id")
	@ManyToOne(fetch = FetchType.LAZY)
	private Users customer;
	
	

	public CustomersOrders() {
		super();
	}
	
	

	public CustomersOrders(Integer id, Orders order, Users customer) {
		super();
		this.id = id;
		this.order = order;
		this.customer = customer;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

	public Users getCustomer() {
		return customer;
	}

	public void setCustomer(Users customer) {
		this.customer = customer;
	}

}
