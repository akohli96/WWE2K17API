package com.wwe.api.wweapi.domain.model;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

public class WrestlerTest {

    private Wrestler wrestler;
    private static final List<String> signatures = asList((String) "Signature1,Signature2");
    private static final String name = "wrestlerName";
    private static final int weight = 100;
    private static final String from = "Location";
    private static final String debut = "Debut game";
    private static final float height = 172;
    private static final String id = "Random-UUID";

    @Before
    public void setUp(){
        wrestler = new Wrestler(signatures,name,weight,from,debut,height,id);
    }
    @Test
    public void getSignaturesShouldReturnSignatures(){
        assertEquals(wrestler.getSignatures(), asList((String) "Signature1,Signature2"));
    }

    @Test
    public void getNameShouldReturnNames() {
        assertEquals(wrestler.getName(),"wrestlerName");
    }

    @Test
    public void getWeightShouldReturnWeignt() {
        assertEquals(wrestler.getWeight(),100);
    }

    @Test
    public void getFromShoudldReturnFrom() {
        assertEquals(wrestler.getFrom(),"Location");
    }

    @Test
    public void getDebutGameShouldReturnDebutGame() {
        assertEquals(wrestler.getDebutGame(),"Debut game");
    }

    @Test
    public void getHeightShouldReturnHeight() {
        assertEquals(wrestler.getHeight(),172,1);
    }

    @Test
    public void getIDShouldReturnID() {
        assertEquals(wrestler.getID(),"Random-UUID");
    }

}