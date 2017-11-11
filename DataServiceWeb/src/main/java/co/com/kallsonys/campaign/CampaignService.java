package co.com.kallsonys.campaign;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import co.com.kallsonys.dto.request.CreateCampaignRequestDTO;
import co.com.kallsonys.dto.response.CreateCampaignResponseDTO;
import co.com.kallsonys.interfaces.IRCampaign;

@Path("/campaignService")
@Stateless
public class CampaignService {

    @EJB(
            lookup = "java:global/DataServiceEAR/DataServiceEJB/CampaignEJB!co.com.kallsonys.interfaces.IRCampaign")
    IRCampaign campaignEJB;
	
	
	@POST
	@Path("/createNewCampaign")
	@Consumes(MediaType.APPLICATION_JSON )
	@Produces(MediaType.APPLICATION_JSON )
	public CreateCampaignResponseDTO createNewCampaign(CreateCampaignRequestDTO campaign) {
		return this.campaignEJB.createCampaign(campaign);
	}
	
}
