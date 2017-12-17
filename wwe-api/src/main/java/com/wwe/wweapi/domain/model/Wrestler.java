package com.wwe.wweapi.domain.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Wrestler{

    private List<String> signatures;
    private String id;
    private String name;
    private int weight;
    private String from;
    private String debutGame;
    private float height;

    public Wrestler(@JsonProperty("signatures") List<String> signatures,@JsonProperty("name") String name,@JsonProperty("weight") int weight,@JsonProperty("billed_from") String from,@JsonProperty("debut_game") String debutGame,@JsonProperty("height") float height,@JsonProperty("id") String id){
        this.signatures=signatures;
        this.name=name;
        this.weight=weight;
        this.from=from;
        this.debutGame=debutGame;
        this.height=height;
        this.id=id;
    }

    public List<String> getSignatures(){
        return signatures;
    }

    public String getName(){
        return name;
    }

    public int getWeight(){
        return weight;
    }

    public String getFrom(){
        return from;
    }

    public String getDebutGame(){
        return debutGame;
    }

    public float getHeight(){
        return height;
    }

    public String getID(){
        return id;
    }
}
