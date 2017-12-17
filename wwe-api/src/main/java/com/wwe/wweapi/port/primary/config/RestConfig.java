package com.wwe.wweapi.port.primary.config;

import com.wwe.wweapi.port.primary.rest.adapter.WrestlerEndpointImpl;
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