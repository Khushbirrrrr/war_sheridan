package ca.sheridancollege.project;

public class WarMain {
    public static void main(String[] args) {
        WarPlayer player1 = new WarPlayer("Player 1");
        WarPlayer player2 = new WarPlayer("Player 2");
        
        WarGame game = new WarGame("War", player1, player2);
        
        // Assuming isGameOver() and playRound() are defined in WarGame
        while (!game.isGameOver()) {
            game.playRound();
        }
        
        System.out.println("Game Over!");
    }
}
