package co.com.kallsonys.ejb;

import java.util.Date;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.logging.Logger;

import co.com.kallsonys.dto.CampaignsDTO;
import co.com.kallsonys.dto.StatusDTO;
import co.com.kallsonys.dto.request.CreateCampaignRequestDTO;
import co.com.kallsonys.dto.response.CreateCampaignResponseDTO;
import co.com.kallsonys.entity.Campaigns;
import co.com.kallsonys.helpers.CampaignsHelper;
import co.com.kallsonys.interfaces.ILCampaign;
import co.com.kallsonys.interfaces.IRCampaign;
import co.com.kallsonys.util.DateUtil;

/**
 * Session Bean implementation class ImposicionISEJB
 */
@Stateless(name = "CampaignEJB")
@LocalBean
public class CampaignEJB implements ILCampaign, IRCampaign {
	
	private final static Logger logger = Logger.getLogger(ProductEJB.class.getName());

    @PersistenceContext(unitName = "persistenceUnit")
    private EntityManager em;
    
    @Override
    public CreateCampaignResponseDTO createCampaign(CreateCampaignRequestDTO campaignRequest){
		logger.debug("CampaignEJB::createCampaign(CreateCampaignRequestDTO)");
		
    	CreateCampaignResponseDTO campaignResponse = null ;
    	
    	Date initialvalitydate = DateUtil.converStringToDate(campaignRequest.getInitialvalitydate());
    	Date finalvalitydate = DateUtil.converStringToDate(campaignRequest.getFinalvalitydate());
    	
    	if(initialvalitydate != null && finalvalitydate != null ){
    		CampaignsDTO campaignDTO = new CampaignsDTO(null,initialvalitydate,finalvalitydate, new StatusDTO(1,null));
    		Campaigns campaign = new Campaigns();
    		campaign = CampaignsHelper.toLevel1Entity(campaignDTO, campaign);
    		em.persist(campaign);
    		campaignResponse = new CreateCampaignResponseDTO("La campaña se creó exitosamente",campaign.getId(),true);
    		
    	} else {
    		campaignResponse = new CreateCampaignResponseDTO("No se pueder crear la campaña",null,false);
    	}
		return campaignResponse;
    }
    
//    public CreateCampaignResponseDTO createCampaign(CreateCampaignRequestDTO campaignRequest){
//		logger.debug("CampaignEJB::createCampaign(CreateCampaignRequestDTO)");
//		
//    }

}
