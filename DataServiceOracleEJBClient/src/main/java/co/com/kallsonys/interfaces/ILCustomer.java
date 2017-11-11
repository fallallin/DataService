package co.com.kallsonys.interfaces;

import javax.ejb.Local;

import co.com.kallsonys.dto.request.CustomerRequestDTO;
import co.com.kallsonys.dto.response.GetCustomerByIdResponseDTO;
import co.com.kallsonys.dto.response.SetCustomerResponseDTO;

@Local
public interface ILCustomer {
	
	public GetCustomerByIdResponseDTO getCustomer(CustomerRequestDTO customerDTO);
	
	public SetCustomerResponseDTO setCustomer(CustomerRequestDTO customerRequest);

}
