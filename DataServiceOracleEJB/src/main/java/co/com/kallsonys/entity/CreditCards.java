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


@XmlRootElement
@Entity
@Table(name = "creditcards")
public class CreditCards implements Entidad {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "cardnumber")
	private Integer cardNumber;

	@Column(name = "duedate")
	private String dueDate;

	@Column(name = "securitycode")
	private String securityCode;

	@JoinColumn(name = "idcustomertype", referencedColumnName = "id")
	@ManyToOne(fetch = FetchType.LAZY)
	private CustomerTypes customerType;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(Integer cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public String getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}

	public CustomerTypes getCustomerType() {
		return customerType;
	}

	public void setCustomerType(CustomerTypes customerType) {
		this.customerType = customerType;
	}

}
