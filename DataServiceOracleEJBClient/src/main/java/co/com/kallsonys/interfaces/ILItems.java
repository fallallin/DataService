package co.com.kallsonys.interfaces;

import java.util.List;

import javax.ejb.Local;

import co.com.kallsonys.dto.request.ItemRequestDTO;
import co.com.kallsonys.dto.request.ProductRankingRequestDTO;
import co.com.kallsonys.dto.response.ItemResponseDTO;
import co.com.kallsonys.dto.response.ProductRankingResponseDTO;
import co.com.kallsonys.dto.response.RankingResponseDTO;

@Local
public interface ILItems {

	public ItemResponseDTO createItem(ItemRequestDTO item);

	public List<ItemResponseDTO> createItems(List<ItemRequestDTO> listItemRequestDTO, Integer idOrder);
	
	public RankingResponseDTO getProductRanking(ProductRankingRequestDTO productRankingRequestDTO);

}
