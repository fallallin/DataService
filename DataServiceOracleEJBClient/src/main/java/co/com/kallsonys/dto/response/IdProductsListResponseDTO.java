package co.com.kallsonys.dto.response;

import java.util.List;

import co.com.kallsonys.dto.DetailResponseWSDTO;

public class IdProductsListResponseDTO extends DetailResponseWSDTO {

	private static final long serialVersionUID = 1L;

	private List<Integer> listIdProduct;

	public List<Integer> getListIdProduct() {
		return listIdProduct;
	}

	public void setListIdProduct(List<Integer> listIdProduct) {
		this.listIdProduct = listIdProduct;
	}

}
