package co.com.kallsonys.dto.response;

import java.io.Serializable;

public class CustomerTypeResponseDTO implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;

	private Integer idCustomerType;
	private String customerType;

	public Integer getIdCustomerType() {
		return idCustomerType;
	}

	public void setIdCustomerType(Integer idCustomerType) {
		this.idCustomerType = idCustomerType;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

}
