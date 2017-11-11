package co.com.kallsonys.helpers;

import java.util.ArrayList;
import java.util.List;

import co.com.kallsonys.dto.request.ItemRequestDTO;
import co.com.kallsonys.dto.response.ItemResponseDTO;
import co.com.kallsonys.dto.response.OrderResponseDTO;
import co.com.kallsonys.entity.Items;
import co.com.kallsonys.entity.Orders;

public class ItemsHelper {

	public static Items buildItemsEntity(ItemRequestDTO itemRequestDTO) {
		Items item = new Items();

		item.setId(itemRequestDTO.getId());
		item.setExternalIdentifier(itemRequestDTO.getExternalIdentifier());
		item.setPrice(itemRequestDTO.getPrice());
		item.setQuantity(itemRequestDTO.getQuantity());
		item.setPartNum(itemRequestDTO.getPartNum());

		if (itemRequestDTO.getOrder() != null && itemRequestDTO.getOrder().getId() != null) {
			item.setOrder(new Orders());
			item.getOrder().setId(itemRequestDTO.getOrder().getId());
		}

		return item;
	}

	public static ItemResponseDTO buildItemResponseDTO(Items item) {
		ItemResponseDTO itemResponseDTO = new ItemResponseDTO();

		itemResponseDTO.setId(item.getId());
		itemResponseDTO.setExternalIdentifier(item.getExternalIdentifier());
		itemResponseDTO.setPrice(item.getPrice());
		itemResponseDTO.setQuantity(item.getQuantity());
		itemResponseDTO.setPartNum(item.getPartNum());

		if (item.getOrder() != null && item.getOrder().getId() != null) {
			itemResponseDTO.setOrder(new OrderResponseDTO());
			item.getOrder().setId(item.getOrder().getId());
		}

		return itemResponseDTO;

	}
	
	
	public static List<Items> buildListItemsEntity(List<ItemRequestDTO> listItemRequestDTO){
		List<Items> listItems = new ArrayList<Items>();
		if(! listItemRequestDTO.isEmpty()){
			for(ItemRequestDTO itemRequestDTO: listItemRequestDTO){
				listItems.add(ItemsHelper.buildItemsEntity(itemRequestDTO));
			}
		}
		return listItems;
		
	}

}
