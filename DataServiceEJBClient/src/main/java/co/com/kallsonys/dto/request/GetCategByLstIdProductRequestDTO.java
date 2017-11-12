package co.com.kallsonys.dto.request;

import java.io.Serializable;
import java.util.List;

public class GetCategByLstIdProductRequestDTO implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;

	private Integer initialPage;
	private Integer finalPage;
	private String strIdsProducts;

	public Integer getInitialPage() {
		return initialPage;
	}

	public void setInitialPage(Integer initialPage) {
		this.initialPage = initialPage;
	}

	public Integer getFinalPage() {
		return finalPage;
	}

	public void setFinalPage(Integer finalPage) {
		this.finalPage = finalPage;
	}

	public String getStrIdsProducts() {
		return strIdsProducts;
	}

	public void setStrIdsProducts(String strIdsProducts) {
		this.strIdsProducts = strIdsProducts;
	}

}
