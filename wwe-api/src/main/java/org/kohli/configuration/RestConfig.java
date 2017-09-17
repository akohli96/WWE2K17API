package  org.kohli.configuration;

import org.glassfish.jersey.server.ResourceConfig;
import org.kohli.rest.WrestlerEndpointImpl;

import javax.ws.rs.ApplicationPath;
import org.springframework.context.annotation.Configuration;

@Configuration
@ApplicationPath("/api/v1")
public class RestConfig extends ResourceConfig{
    public RestConfig(){
     register(WrestlerEndpointImpl.class);
    }
}