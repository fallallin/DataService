package co.com.kallsonys.services.ws.app;

import java.text.SimpleDateFormat;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import org.codehaus.jackson.Version;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.module.SimpleModule;


@Provider
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ConfiguracionMapeoObjectToJSON implements ContextResolver<ObjectMapper> {

    private final ObjectMapper objectMapper;

    public ConfiguracionMapeoObjectToJSON() {
        objectMapper = new ObjectMapper();
        objectMapper.setDateFormat(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SSS"));
        objectMapper.configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS, false);
        //objectMapper.setDeserializationConfig(new DeserializationConfig(intr, annIntr, vc, subtypeResolver, propertyNamingStrategy, typeFactory, handlerInstantiator))
        
        SimpleModule module = new SimpleModule("", Version.unknownVersion());
        module.addSerializer(java.sql.Date.class, new SQLDateOnlySerializer(null));
        objectMapper.registerModule(module);
    }

    public ObjectMapper getContext(Class<?> type) {
        return objectMapper;
    }
}