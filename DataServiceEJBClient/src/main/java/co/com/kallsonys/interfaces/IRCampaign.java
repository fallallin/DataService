package co.com.kallsonys.interfaces;

import javax.ejb.Remote;

import co.com.kallsonys.dto.request.CreateCampaignRequestDTO;
import co.com.kallsonys.dto.response.CreateCampaignResponseDTO;

@Remote
public interface IRCampaign {
	
	public CreateCampaignResponseDTO createCampaign(CreateCampaignRequestDTO campaignRequest);
}
