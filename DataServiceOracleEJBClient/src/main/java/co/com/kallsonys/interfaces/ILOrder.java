package co.com.kallsonys.interfaces;

import javax.ejb.Local;

import co.com.kallsonys.dto.request.CreateOrderRequestDTO;
import co.com.kallsonys.dto.request.CustomerRequestDTO;
import co.com.kallsonys.dto.request.OrderRequestDTO;
import co.com.kallsonys.dto.response.GetOrderByIdResponseDTO;
import co.com.kallsonys.dto.response.OrderDetailResponseDTO;
import co.com.kallsonys.dto.response.OrderResponseDTO;

@Local
public interface ILOrder {

	public OrderDetailResponseDTO getOrderByNumber(Integer idOrder);
	
	public GetOrderByIdResponseDTO getOrderById(Integer idOrder);
	
	public OrderResponseDTO createOrder(CreateOrderRequestDTO createOrderRequestDTO);
	
	public void createCustomersOrders(OrderRequestDTO orderRequestDTO, CustomerRequestDTO customerRequestDTO);
	
	public CreateOrderRequestDTO upadateOrder(CreateOrderRequestDTO createOrderRequestDTO);
}
