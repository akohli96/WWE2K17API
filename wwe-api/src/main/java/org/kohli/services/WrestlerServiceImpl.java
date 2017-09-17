package org.kohli.services;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.io.IOException;

//import org.kohli.exception.WWEException;
import org.kohli.object.Wrestler;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;

import javax.inject.Inject;

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
        return new ArrayList<Wrestler>(wrestlerMap.values());
    }

    //@PostConstruct
    private void loadWrestlerData(){
        try {
            List<Wrestler> wrestlerList = objectMapper.readValue(new ClassPathResource("superstar.json").getFile(),new TypeReference<List<Wrestler>>(){}); 
            wrestlerList.forEach(wrestler -> wrestlerMap.put(wrestler.getID(), wrestler)); 
        }catch (JsonParseException e){
            //throw new WWEException(e);
        }catch (JsonMappingException e){
            //throw new WWEException(e);
        }catch (IOException e) {
            //throw new WWEException(e);
        }
    }
}
