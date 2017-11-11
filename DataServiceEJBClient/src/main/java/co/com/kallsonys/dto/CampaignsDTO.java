package co.com.kallsonys.dto;

import java.io.Serializable;
import java.util.Date;

public class CampaignsDTO implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Date initialvalitydate;
	private Date finalvalitydate;
	private StatusDTO status;

	public CampaignsDTO() {
		super();
	}

	public CampaignsDTO(Integer id, Date initialvalitydate, Date finalvalitydate, StatusDTO status) {
		super();
		this.id = id;
		this.initialvalitydate = initialvalitydate;
		this.finalvalitydate = finalvalitydate;
		this.status = status;
	}

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

	public StatusDTO getStatus() {
		return status;
	}

	public void setStatus(StatusDTO status) {
		this.status = status;
	}

}
