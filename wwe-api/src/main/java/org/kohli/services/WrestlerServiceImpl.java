package org.kohli.services;

import java.util.Map;
import java.util.HashMap;
import org.kohli.object.Wrestler;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.inject.Inject;

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
    public void getByID(String id) {
    }

    @Override
    public void getAll() {
    }

    private void loadWrestlerData(){
    }
}
