package co.com.kallsonys.interfaces;

import javax.ejb.Remote;

import co.com.kallsonys.dto.request.CustomerRequestDTO;
import co.com.kallsonys.dto.response.GetCustomerByIdResponseDTO;
import co.com.kallsonys.dto.response.SetCustomerResponseDTO;

@Remote
public interface IRCustomer {

	public GetCustomerByIdResponseDTO getCustomer(CustomerRequestDTO customerDTO);

	public SetCustomerResponseDTO setCustomer(CustomerRequestDTO customerRequest);

}
