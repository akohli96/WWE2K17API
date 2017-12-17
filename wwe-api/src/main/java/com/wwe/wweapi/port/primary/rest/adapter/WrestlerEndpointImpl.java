package com.wwe.wweapi.port.primary.rest.adapter;

import com.wwe.wweapi.port.primary.rest.WrestlerEndpoint;
import com.wwe.wweapi.domain.WrestlerService;
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