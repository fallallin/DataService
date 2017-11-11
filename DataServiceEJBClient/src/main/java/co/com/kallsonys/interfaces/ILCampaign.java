package co.com.kallsonys.interfaces;

import javax.ejb.Local;

import co.com.kallsonys.dto.request.CreateCampaignRequestDTO;
import co.com.kallsonys.dto.response.CreateCampaignResponseDTO;

@Local
public interface ILCampaign {

	public CreateCampaignResponseDTO createCampaign(CreateCampaignRequestDTO campaignRequest);
}
