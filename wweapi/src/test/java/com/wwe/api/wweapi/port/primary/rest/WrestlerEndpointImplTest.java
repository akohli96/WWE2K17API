package com.wwe.api.wweapi.port.primary.rest;

import com.wwe.api.wweapi.domain.WrestlerService;
import com.wwe.api.wweapi.domain.model.Wrestler;
import com.wwe.api.wweapi.port.primary.WrestlerEndpoint;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class WrestlerEndpointImplTest {

    @Mock
    private WrestlerService wrestlerService;

    private WrestlerEndpoint wrestlerEndpoint;

    private static final List<String> signatures = asList((String) "Signature1,Signature2");
    private static final String name = "wrestlerName";
    private static final int weight = 100;
    private static final String from = "Location";
    private static final String debut = "Debut game";
    private static final float height = 172;
    private static final String id = "Random-UUID";

    List <Wrestler> wrestlerList;

    @Before
    public void setUp(){
        wrestlerService = mock(WrestlerService.class);
        wrestlerEndpoint = new WrestlerEndpointImpl(wrestlerService);
        wrestlerList = new ArrayList<>();
        for(int i = 0;i<3;i++){
            wrestlerList.add(new Wrestler(signatures,name,weight,from,debut,height,id+i));
        }
    }

    @Test
    public void getAllReturnsAllWrestlers() throws Exception {
        when(wrestlerService.getAll()).thenReturn(wrestlerList);
        Response response = wrestlerEndpoint.getAll();
        List<Wrestler> wrestlerList = (List <Wrestler>) response.getEntity(); //TODO : Check if alternatives
        assertEquals(response.getStatus(),202);
        assertEquals(wrestlerList.size(),3);
        for(int i=0;i<wrestlerList.size();i++){
            assertEquals(wrestlerList.get(i).getID(),id+i);
        }
    }

    @Test
    public void getByIDReturnsWrestlersByID() throws Exception {
        when(wrestlerService.getByID(anyString())).thenReturn(wrestlerList.get(0));
        Response response = wrestlerEndpoint.getByID("ID");
        Wrestler responseWrestler = (Wrestler) response.getEntity(); //TODO: Check if convention
        assertEquals(response.getStatus(),202);
        assertEquals(responseWrestler.getID(),id+0);
    }

}