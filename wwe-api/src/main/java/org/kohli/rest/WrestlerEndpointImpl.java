package org.kohli.rest;

import java.util.List;
import org.kohli.rest.WrestlerEndpoint;
import org.kohli.services.WrestlerService;
import org.springframework.stereotype.Component;
import org.kohli.object.Wrestler;

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