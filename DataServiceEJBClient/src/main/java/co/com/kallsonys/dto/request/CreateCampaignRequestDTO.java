package co.com.kallsonys.dto.request;

import java.io.Serializable;
import java.util.Date;

public class CreateCampaignRequestDTO implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;

	private String initialvalitydate;
	private String finalvalitydate;

	public String getInitialvalitydate() {
		return initialvalitydate;
	}

	public void setInitialvalitydate(String initialvalitydate) {
		this.initialvalitydate = initialvalitydate;
	}

	public String getFinalvalitydate() {
		return finalvalitydate;
	}

	public void setFinalvalitydate(String finalvalitydate) {
		this.finalvalitydate = finalvalitydate;
	}

}
