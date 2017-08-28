package org.kohli.rest;

import java.util.List;
import org.kohli.rest.WrestlerEndpoint;
import org.kohli.services.WrestlerService;
import org.springframework.stereotype.Component;
import org.kohli.object.Wrestler;

@Component
public class WrestlerEndpointImpl implements WrestlerEndpoint{

    private WrestlerService wrestlerService;

    public WrestlerEndpointImpl(WrestlerService wrestlerService){
        this.wrestlerService=wrestlerService;
    }
    public List<Wrestler> getAll(){
        System.out.println("Getting all");
        return wrestlerService.getAll();
    }

    public Wrestler getByID(String id){
        System.out.println("Getting " + id);
        return wrestlerService.getByID(id);
    }

}