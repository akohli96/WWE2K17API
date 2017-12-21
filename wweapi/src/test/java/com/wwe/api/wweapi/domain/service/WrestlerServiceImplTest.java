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
import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class WrestlerServiceImplTest {
    private WrestlerService wrestlerService;

    private static final List<String> signatures = asList((String) "Signature1,Signature2");
    private static final String name = "wrestlerName";
    private static final int weight = 100;
    private static final String from = "Location";
    private static final String debut = "Debut game";
    private static final float height = 172;
    private static final String id = "Random-UUID";

    @Mock
    private ObjectMapper objectMapper;

    @Before
    public void setUp() throws WWEException, IOException {
        objectMapper = mock(ObjectMapper.class);
        List <Wrestler> wrestlerList = new ArrayList <>();
        for(int i = 0;i<3;i++){
            wrestlerList.add(new Wrestler(signatures,name,weight,from,debut,height,id+i));
        }
        when(objectMapper.readValue(any(File.class),any(TypeReference.class))).thenReturn(wrestlerList);
        wrestlerService = new WrestlerServiceImpl(objectMapper);
    }
    @Test
    public void getByIDShouldReturnCorrectWrestlers() {
        assertEquals(wrestlerService.getByID(id+0).getID(),id+0);
        assertEquals(wrestlerService.getByID(id+1).getID(),id+1);
        assertEquals(wrestlerService.getByID(id+2).getID(),id+2);
    }

    @Test
    public void getAllShouldReturnCorrectWrestlerList()  {
        List<Wrestler> wrestlerList = wrestlerService.getAll();
        assertEquals(wrestlerList.size(),3);
        wrestlerList.forEach(wrestler -> assertThat(wrestler, instanceOf(Wrestler.class)));
    }

    @Test(expected = WWEException.class)
    public void wresterServiceConstructionThrowsWWEException() throws WWEException, IOException {
        when(objectMapper.readValue(any(File.class),any(TypeReference.class))).thenThrow(IOException.class);
        wrestlerService = new WrestlerServiceImpl(objectMapper);
    }

}