package com.wwe.wweapi.rest;

import com.wwe.wweapi.services.WrestlerService;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

@Component
public class WrestlerEndpointImpl implements WrestlerEndpoint{

    private WrestlerService wrestlerService;

    @Inject
    public WrestlerEndpointImpl(WrestlerService wrestlerService){
        this.wrestlerService=wrestlerService;
    }

    @Override
    public Response getAll(){
        return Response
                .accepted(wrestlerService.getAll())
                .build();
    }

    @Override
    public Response getByID(String id){
        return Response
                .accepted(wrestlerService.getByID(id))
                .build();
    }

}