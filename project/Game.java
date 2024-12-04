
package ca.sheridancollege.project;

import java.util.ArrayList;


public abstract class Game 
{
    private final String gameName;
    private ArrayList<Player> players;

public Game(String givenName) {
    gameName = givenName;
    players = new ArrayList<Player>(); 
}


   
    public String getGameName() 
    {
        return gameName;
    }
    
    
    public ArrayList <Player> getPlayers() 
    {
        return players;
    }

    
    public void setPlayers(ArrayList <Player> players) 
    {
        this.players = players;
    }
    
    
    public abstract void play();
    
    
    public abstract void declareWinner();

   
    
}
