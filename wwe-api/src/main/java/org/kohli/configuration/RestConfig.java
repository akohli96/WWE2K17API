package  org.kohli.configuration;

import org.glassfish.jersey.server.ResourceConfig;
import javax.ws.rs.ApplicationPath;
import org.springframework.context.annotation.Configuration;

@Configuration
@ApplicationPath("/")
public class RestConfig extends ResourceConfig{
    public RestConfig(){
     //register classes
    }
}