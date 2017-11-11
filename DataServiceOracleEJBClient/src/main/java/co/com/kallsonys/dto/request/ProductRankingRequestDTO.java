package co.com.kallsonys.dto.request;

import java.io.Serializable;
import java.util.Date;

public class ProductRankingRequestDTO implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;

	private Integer initalPage;
	private Integer finalPage;
	private Date initialDate;
	private Date finalDate;

	public ProductRankingRequestDTO() {
		super();
	}

	public ProductRankingRequestDTO(Integer initalPage, Integer finalPage, Date initialDate, Date finalDate) {
		super();
		this.initalPage = initalPage;
		this.finalPage = finalPage;
		this.initialDate = initialDate;
		this.finalDate = finalDate;
	}

	public Integer getInitalPage() {
		return initalPage;
	}

	public void setInitalPage(Integer initalPage) {
		this.initalPage = initalPage;
	}

	public Integer getFinalPage() {
		return finalPage;
	}

	public void setFinalPage(Integer finalPage) {
		this.finalPage = finalPage;
	}

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
