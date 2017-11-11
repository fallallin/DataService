package co.com.kallsonys.services.ws.app;

import javax.ejb.Stateless;



import javax.ws.rs.Path;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;

@Path("/servicios")
@Stateless
public class ServiciosServicesLayer {
    
    @GET
    @Produces("application/json")
    @Path("/estadoCapaServicio")
    public String consultarVerificacionDatos() {
        return "OK";
    }
    
    @GET
    @Produces("application/json;charset=UTF-8")
    @Path("/estadoCapaServicioUTF")
    public DateExampleDTO ejemploOK() {    	
        return new DateExampleDTO();
    }    
    @GET
    @Produces("application/json")
    @Path("/ejemploDate")	
    public DateExampleDTO ejemploDate() {        
        return new DateExampleDTO();
    }    

}
