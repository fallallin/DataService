package co.com.kallsonys.dto.request;

import java.io.Serializable;
import java.util.Date;


public class GetOrdersByDatesRequestDTO implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;

	private Date initialDate;
	private Date finalDate;
	
	public Date getInitialDate() {
		return initialDate;
	}
	public void setInitialDate(Date initialDate) {
		this.initialDate = initialDate;
	}
	public Date getFinalDate() {
		return finalDate;
	}
	public void setFinalDate(Date finalDate) {
		this.finalDate = finalDate;
	}
	
	

}
