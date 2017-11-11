package co.com.kallsonys.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "items")
public class Items implements Entidad {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "items_seq")
	@SequenceGenerator(name = "items_seq", sequenceName = "items_seq", allocationSize = 1)
	@Column(name = "id")
	private Integer id;

	@Column(name = "externalidentifier")
	private String externalIdentifier;

	@Column(name = "price")
	private BigDecimal price;

	@Column(name = "quantity")
	private Integer quantity;

	@Column(name = "partnum")
	private Integer partNum;

	@JoinColumn(name = "idorder", referencedColumnName = "id")
	@ManyToOne(fetch = FetchType.LAZY)
	private Orders order;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getExternalIdentifier() {
		return externalIdentifier;
	}

	public void setExternalIdentifier(String externalIdentifier) {
		this.externalIdentifier = externalIdentifier;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getPartNum() {
		return partNum;
	}

	public void setPartNum(Integer partNum) {
		this.partNum = partNum;
	}

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

}
