package com.wwe.api.wweapi.port.primary.rest;

import com.wwe.api.wweapi.domain.WrestlerService;
import com.wwe.api.wweapi.domain.model.Wrestler;
import com.wwe.api.wweapi.port.primary.WrestlerEndpoint;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.List;

@Component
public class WrestlerEndpointImpl implements WrestlerEndpoint {

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
