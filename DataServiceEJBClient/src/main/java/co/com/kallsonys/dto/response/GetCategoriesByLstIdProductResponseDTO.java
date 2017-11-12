package co.com.kallsonys.dto.response;



import java.util.List;

import co.com.kallsonys.dto.DetailResponseWSDTO;

public class GetCategoriesByLstIdProductResponseDTO extends DetailResponseWSDTO {
	private static final long serialVersionUID = 1L;

	private List<GetCategByLstIdProductResponseDTO> categories;

	public List<GetCategByLstIdProductResponseDTO> getCategories() {
		return categories;
	}

	public void setCategories(List<GetCategByLstIdProductResponseDTO> categories) {
		this.categories = categories;
	}


}
