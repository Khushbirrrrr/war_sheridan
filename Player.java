
package ca.sheridancollege.project;


public abstract class Player 
{
    private String playerID; 
    
    
    public Player(String name)
    {
        playerID= name;
    }
    
    
    public String getPlayerID() 
    {
        return playerID;
    }

    
    public void setPlayerID(String givenID) 
    {
        playerID = givenID;
    }
    
    
    public abstract void play();
    
}
