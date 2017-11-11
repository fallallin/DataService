package co.com.kallsonys.entity;

import java.util.Date;

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
@Table(name = "campaigns")
public class Campaigns {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "initialvalitydate")
	private Date initialvalitydate;

	@Column(name = "finalvalitydate")
	private Date finalvalitydate;

	@JoinColumn(name = "idstatus", referencedColumnName = "id")
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Status status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getInitialvalitydate() {
		return initialvalitydate;
	}

	public void setInitialvalitydate(Date initialvalitydate) {
		this.initialvalitydate = initialvalitydate;
	}

	public Date getFinalvalitydate() {
		return finalvalitydate;
	}

	public void setFinalvalitydate(Date finalvalitydate) {
		this.finalvalitydate = finalvalitydate;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
