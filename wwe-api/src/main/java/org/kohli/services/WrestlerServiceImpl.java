package org.kohli.services;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.inject.Inject;

public class WrestlerServiceImpl implements WrestlerService {

    private ObjectMapper objectMapper;

    @Inject
    public WrestlerServiceImpl(ObjectMapper objectMapper){
        this.objectMapper=objectMapper;
        loadWrestlerData();
    }

    @Override
    public void getWrestlerByID(String id) {

    }

    @Override
    public void getAll() {

    }

    private void loadWrestlerData(){

    }
}
