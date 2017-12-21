package com.wwe.api.wweapi.port.primary.rest;

import com.wwe.api.wweapi.domain.WrestlerService;
import com.wwe.api.wweapi.port.primary.WrestlerEndpoint;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

@Component
public class WrestlerEndpointImpl implements WrestlerEndpoint {

    private WrestlerService wrestlerService;

    @Inject
    public WrestlerEndpointImpl(WrestlerService wrestlerService){
        this.wrestlerService=wrestlerService;
    }

    public Response getAll(){
        return Response
                .accepted(wrestlerService.getAll())
                .build();
    }

    public Response getByID(String id){
        return Response
                .accepted(wrestlerService.getByID(id))
                .build();
    }

}
