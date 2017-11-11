package co.com.kallsonys.helpers;

import co.com.kallsonys.dto.request.OrderRequestDTO;
import co.com.kallsonys.dto.response.AddressesResponseDTO;
import co.com.kallsonys.dto.response.OrderResponseDTO;
import co.com.kallsonys.dto.response.StatusResponseDTO;
import co.com.kallsonys.entity.Addresses;
import co.com.kallsonys.entity.Orders;
import co.com.kallsonys.entity.Status;

public class OrderHelper {

	public static OrderResponseDTO buildOrderResponseDTO(Orders order) {

		OrderResponseDTO orderResponse = new OrderResponseDTO();

		orderResponse.setId(order.getId());
		orderResponse.setOrderDate(order.getOrderDate());
		orderResponse.setPrice(order.getPrice());
		orderResponse.setComments(order.getComments());

		orderResponse.setStatus(new StatusResponseDTO());
		if (order.getStatus() != null) {
			orderResponse.getStatus().setIdStatus(order.getStatus().getId());
			orderResponse.getStatus().setStatus(order.getStatus().getStatus());
		}

		orderResponse.setAddress(new AddressesResponseDTO());
		if (order.getAddress() != null) {
			orderResponse.setAddress(AddressesHelper.buildAddressesResponseDTO(order.getAddress()));
		}
		return orderResponse;

	}

	public static Orders buildOrderEntity(OrderRequestDTO orderRequest) {

		Orders order = new Orders();

		order.setId(orderRequest.getId());
		order.setOrderDate(orderRequest.getOrderDate());
		order.setPrice(orderRequest.getPrice());
		order.setComments(orderRequest.getComments());

		order.setStatus(new Status());
		if (orderRequest.getStatus() != null) {
			order.getStatus().setId(orderRequest.getStatus().getIdStatus());
			order.getStatus().setStatus(orderRequest.getStatus().getStatus());
		}

		order.setAddress(new Addresses());
		if (order.getAddress() != null) {
			order.setAddress(AddressesHelper.buildAddressesEntity(orderRequest.getAddress()));
		}
		return order;

	}

	public static OrderResponseDTO ResquestToResponse(OrderRequestDTO orderRequestDTO) {

		OrderResponseDTO orderResponseDTO = new OrderResponseDTO();

		orderResponseDTO.setId(orderRequestDTO.getId());
		orderResponseDTO.setOrderDate(orderRequestDTO.getOrderDate());
		orderResponseDTO.setPrice(orderRequestDTO.getPrice());
		orderResponseDTO.setComments(orderRequestDTO.getComments());

		orderResponseDTO.setStatus(new StatusResponseDTO());
		if (orderRequestDTO.getStatus() != null) {
			orderResponseDTO.getStatus().setIdStatus(orderRequestDTO.getStatus().getIdStatus());
			orderResponseDTO.getStatus().setStatus(orderRequestDTO.getStatus().getStatus());
		}

		orderResponseDTO.setAddress(new AddressesResponseDTO());
		if (orderRequestDTO.getAddress() != null) {
			orderResponseDTO.setAddress(AddressesHelper.ResquestToResponse(orderRequestDTO.getAddress()));
		}

		return orderResponseDTO;

	}
}
