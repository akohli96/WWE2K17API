package  org.kohli.object;

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

    public Wrestler(List<String> signatures,String name,int weight,String from,String debutGame,float height,String id){
        this.signatures=signatures;
        this.name=name;
        this.weight=weight;
        this.from=from;
        this.debutGame=debutGame;
        this.height=height;
        this.id=id;
    }

    @JsonProperty("signatures")
    public List<String> getSignatures(){
        return signatures;
    }

    @JsonProperty("name")
    public String getName(){
        return name;
    }

    @JsonProperty("weight")
    public int getWeight(){
        return weight;
    }

    @JsonProperty("billed_from")
    public String getFrom(){
        return from;
    }

    @JsonProperty("debut_game")
    public String getDebutGame(){
        return debutGame;
    }

    @JsonProperty("height")
    public float getHeight(){
        return height;
    }

    @JsonProperty("id")
    public String getID(){
        return id;
    }
}
