package co.com.kallsonys.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "orders")
public class Orders implements Entidad {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "orders_seq")
	@SequenceGenerator(name = "orders_seq", sequenceName = "orders_seq", allocationSize = 1)
	@Column(name = "id")
	private Integer id;

	@Column(name = "orderdate")
	private Date orderDate;

	@Column(name = "price")
	private BigDecimal price;

	@Column(name = "comments")
	private String comments;

	@JoinColumn(name = "idstatus", referencedColumnName = "id")
	@ManyToOne(fetch = FetchType.LAZY)
	private Status status;

	@JoinColumn(name = "idaddress", referencedColumnName = "id")
	@ManyToOne(fetch = FetchType.LAZY)
	private Addresses address;

	@OneToMany(mappedBy = "order", cascade = { CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE })
	private List<Items> itemList;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Addresses getAddress() {
		return address;
	}

	public void setAddress(Addresses address) {
		this.address = address;
	}

	public List<Items> getItemList() {
		return itemList;
	}

	public void setItemList(List<Items> itemList) {
		this.itemList = itemList;
	}

}
