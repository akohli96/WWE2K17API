package com.wwe.api.wweapi.port.primary.config;

import com.wwe.api.wweapi.port.primary.rest.WrestlerEndpointImpl;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import javax.ws.rs.ApplicationPath;

@Configuration
@ApplicationPath("/api/v1")
public class RestConfig extends ResourceConfig {
    public RestConfig(){
        register(WrestlerEndpointImpl.class);
    }
}