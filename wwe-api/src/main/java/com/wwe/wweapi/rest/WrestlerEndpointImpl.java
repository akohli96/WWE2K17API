package com.wwe.wweapi.rest;

import java.util.List;

import com.wwe.wweapi.object.Wrestler;
import com.wwe.wweapi.services.WrestlerService;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Component
public class WrestlerEndpointImpl implements WrestlerEndpoint{

    private WrestlerService wrestlerService;

    @Inject
    public WrestlerEndpointImpl(WrestlerService wrestlerService){
        this.wrestlerService=wrestlerService;
    }
    public List<Wrestler> getAll(){
        return wrestlerService.getAll();
    }

    public Wrestler getByID(String id){
        return wrestlerService.getByID(id);
    }

}