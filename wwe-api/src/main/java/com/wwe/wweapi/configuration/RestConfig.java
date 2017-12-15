package com.wwe.wweapi.configuration;

import com.wwe.wweapi.rest.WrestlerEndpointImpl;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;
import org.springframework.context.annotation.Configuration;

@Configuration
@ApplicationPath("/api/v1")
public class RestConfig extends ResourceConfig{
    public RestConfig(){
     register(WrestlerEndpointImpl.class);
    }
}