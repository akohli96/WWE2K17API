package org.kohli.services;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.Collection;
import org.kohli.object.Wrestler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import javax.inject.Inject;
import java.io.File;


@Component
public class WrestlerServiceImpl implements WrestlerService {

    private ObjectMapper objectMapper;
    private Map<String,Wrestler> wrestlerMap;

    @Inject
    public WrestlerServiceImpl(ObjectMapper objectMapper){
        this.objectMapper=objectMapper;
        wrestlerMap = new HashMap<>();
        loadWrestlerData();
    }

    @Override
    public Wrestler getByID(String id) {
        return wrestlerMap.get(id);
    }

    @Override
    public Collection<Wrestler>  getAll() {
        return wrestlerMap.values();
    }

    private void loadWrestlerData(){

        File file = new File("resources/superstar.json");
        try {
           List<Wrestler> wrestlerList = objectMapper.readValue(file,  new TypeReference<List<Wrestler>>(){}); 
           wrestlerList.forEach(wrestler -> wrestlerMap.put(UUID.randomUUID().toString(), wrestler));
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
}
