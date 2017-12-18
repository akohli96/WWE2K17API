package com.wwe.api.wweapi.domain.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wwe.api.wweapi.domain.WrestlerService;
import com.wwe.api.wweapi.domain.exception.WWEException;
import com.wwe.api.wweapi.domain.model.Wrestler;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;


import static org.junit.Assert.*;

public class WrestlerServiceImplTest {
    private WrestlerService wrestlerService;
    List<Wrestler> wrestlerList;

    private static final List<String> signatures = Arrays.asList((String) "Signature1,Signature2");
    private static final String name = "wrestlerName";
    private static final int weight = 100;
    private static final String from = "Location";
    private static final String debut = "Debut game";
    private static final float height = 172;
    private static final String id = "Random-UUID";

    private ObjectMapper objectMapper;

    @Before
    public void setUp() throws WWEException, IOException {
        objectMapper = mock(ObjectMapper.class);
        wrestlerList = new ArrayList <>();
        for(int i = 0;i<3;i++){
            wrestlerList.add(new Wrestler(signatures,name,weight,from,debut,height,id+i));
        }
        when(objectMapper.readValue(any(File.class),new TypeReference<List<Wrestler>>(){})).thenReturn(wrestlerList); //TODO : FIX
        wrestlerService = new WrestlerServiceImpl(objectMapper);
    }
    @Test
    public void getByID() throws Exception {
        wrestlerService.getByID(id+1);
        wrestlerService.getByID(id+2);
        wrestlerService.getByID(id+3);
    }

    @Test
    public void getAll() throws Exception {
    }

}