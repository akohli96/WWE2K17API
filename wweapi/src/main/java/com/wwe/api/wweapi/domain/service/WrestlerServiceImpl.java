package com.wwe.api.wweapi.domain.service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wwe.api.wweapi.domain.WrestlerService;
import com.wwe.api.wweapi.domain.exception.WWEException;
import com.wwe.api.wweapi.domain.model.Wrestler;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class WrestlerServiceImpl implements WrestlerService {

    private ObjectMapper objectMapper;
    private Map <String, Wrestler> wrestlerMap;

    @Inject
    public WrestlerServiceImpl(ObjectMapper objectMapper) throws WWEException {
        this.objectMapper = objectMapper;
        wrestlerMap = new HashMap <>();
        loadWrestlerData();
    }

    @Override
    public Wrestler getByID(String id) {
        return wrestlerMap.get(id);
    }

    @Override
    public List <Wrestler> getAll() {
        return new ArrayList <>(wrestlerMap.values());
    }

    private void loadWrestlerData() throws WWEException {
        try {
            List <Wrestler> wrestlerList = objectMapper.readValue(new ClassPathResource("superstar.json").getFile(), new TypeReference <List <Wrestler>>() {}); //TODO : Look for alternatives
            wrestlerList.forEach(wrestler -> wrestlerMap.put(wrestler.getID(), wrestler));

        } catch ( JsonParseException e ) {
            throw new WWEException(e);
        } catch ( JsonMappingException e ) {
            throw new WWEException(e);
        } catch ( IOException e ) {
            throw new WWEException(e);
        }
    }
}