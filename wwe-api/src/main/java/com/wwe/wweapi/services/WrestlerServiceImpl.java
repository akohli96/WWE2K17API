package com.wwe.wweapi.services;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.io.IOException;
import java.util.stream.Collectors;

//import org.kohli.exception.WWEException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.wwe.wweapi.exception.WWEException;
import com.wwe.wweapi.object.Wrestler;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonParseException;

import javax.inject.Inject;

@Component
public class WrestlerServiceImpl implements WrestlerService {

    private ObjectMapper objectMapper;
    private Map<String,Wrestler> wrestlerMap;

    @Inject
    public WrestlerServiceImpl(ObjectMapper objectMapper) throws WWEException {
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
        return new ArrayList <>(wrestlerMap.values());
    }

    private void loadWrestlerData() throws WWEException {
        try {
            List<Wrestler> wrestlerList = objectMapper.readValue(new ClassPathResource("superstar.json").getFile(),new TypeReference<List<Wrestler>>(){});
            wrestlerList.forEach(wrestler -> wrestlerMap.put(wrestler.getID(), wrestler)); 
        } catch (IOException e) {
            throw new WWEException(e);
        }
    }
}
