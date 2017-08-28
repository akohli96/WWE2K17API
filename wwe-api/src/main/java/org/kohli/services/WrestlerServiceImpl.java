package org.kohli.services;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.Collection;
import java.util.ArrayList;
import java.io.IOException;
import org.kohli.object.Wrestler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonParseException;
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
    public List<Wrestler>  getAll() {
        System.out.println("Getting all in service layer");
        wrestlerMap.values().forEach(wrestler -> System.out.println(wrestler.getID()));
        return new ArrayList<Wrestler>(wrestlerMap.values());
    }

    private void loadWrestlerData(){
        try {
            System.out.println("Loading all");
            List<Wrestler> wrestlerList = objectMapper.readValue(new File("resources/superstar.json"),  new TypeReference<List<Wrestler>>(){}); 
            wrestlerList.forEach(wrestler -> wrestlerMap.put(UUID.randomUUID().toString(), wrestler)); 
        }catch (JsonParseException e){
            System.out.println(e);
        }catch (JsonMappingException e){
            System.out.println(e);
        }catch (IOException e) {
            System.out.println(e);
        }
    }
}
