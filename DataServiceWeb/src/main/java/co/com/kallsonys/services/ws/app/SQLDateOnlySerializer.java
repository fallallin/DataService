package co.com.kallsonys.services.ws.app;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.BeanProperty;
import org.codehaus.jackson.map.ContextualSerializer;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.SerializerProvider;

public class SQLDateOnlySerializer extends JsonSerializer<Date> implements ContextualSerializer {
	private final String format;

	SQLDateOnlySerializer( String format) {
		this.format = format;
	}

	public SQLDateOnlySerializer() {
		this.format = null;
	}

	@Override
	public void serialize(java.sql.Date value,  JsonGenerator jgen, SerializerProvider provider)
			throws IOException {
		jgen.writeString(new SimpleDateFormat(format).format(value));
	}

	@Override
	public JsonSerializer createContextual(SerializationConfig arg0, BeanProperty arg1) throws JsonMappingException {
		return new SQLDateOnlySerializer("dd/MM/yyyy HH:mm:ss.SSS");
	}
}
