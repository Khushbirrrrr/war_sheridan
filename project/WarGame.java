package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 * this class represents the War card game.
 * it handles the game setup, gameplay logic, and determines the winner.
 */
public class WarGame extends Game {
    private GroupOfCards deck; // the deck of cards for the game
    private WarPlayer player1; // the first player
    private WarPlayer player2; // the second player
    private final int MAX_ROUNDS = 500; // a limit on the number of rounds to prevent endless play

    /**
     * it sets up the game with a name, two players, and initializes the deck and cards.
     * 
     * @param gameName the name of the game
     * @param player1 the first player
     * @param player2 the second player
     */
    public WarGame(String gameName, WarPlayer player1, WarPlayer player2) {
        super(gameName);
        this.player1 = player1;
        this.player2 = player2;
        initializeDeck(); // this prepares the deck of cards
        dealCards(); // to distribute cards between players
    }

    /**
     * create the main deck with 52 cards, one for each suit and rank, and shuffles it.
     */
    private void initializeDeck() {
        deck = new GroupOfCards(52);
        ArrayList<Card> cards = new ArrayList<>();

        for (WarCard.Suit suit : WarCard.Suit.values()) {
            for (WarCard.Rank rank : WarCard.Rank.values()) {
                cards.add(new WarCard(suit, rank)); // adds all cards to the deck
            }
        }
        deck.setCards(cards);
        deck.shuffle(); // shuffels the deck
    }

    /**
     * spreads the cards equally between the two players.
     */
    private void dealCards() {
        ArrayList<Card> cards = deck.showCards();
        for (int i = 0; i < cards.size(); i++) {
            if (i % 2 == 0) {
                player1.addCard((WarCard) cards.get(i)); // add to player 1
            } else {
                player2.addCard((WarCard) cards.get(i)); // add to player 2
            }
        }
    }

    /**
     * checks if the game is over (i.e., one of the players has no cards left).
     * 
     * @return true if the game is over, otherwise false
     */
    public boolean isGameOver() {
        return !player1.hasCards() || !player2.hasCards();
    }

    /**
     * plahs a single round of the game one by one, including handling ties (war scenario).
     */
    public void playRound() {
        if (!player1.hasCards() || !player2.hasCards()) {
            return; // also it end the round if any player has no cards left
        }

        WarCard card1 = player1.playCard();
        WarCard card2 = player2.playCard();

        ArrayList<WarCard> warPile = new ArrayList<>();
        warPile.add(card1);
        warPile.add(card2);

        // handles tie scenario (War)
        while (card1.getRankValue() == card2.getRankValue()) {
            if (player1.handSize() < 4 || player2.handSize() < 4) {
                System.out.println("Not enough cards for another war. Declaring draw.");
                return;
            }

            // extra cards to the war pile
            for (int i = 0; i < 3; i++) {
                warPile.add(player1.playCard());
                warPile.add(player2.playCard());
            }

            // drwaing additional cards to resolve the tie
            card1 = player1.playCard();
            card2 = player2.playCard();
            warPile.add(card1);
            warPile.add(card2);
        }

        // decides the winner of the round
        if (card1.getRankValue() > card2.getRankValue()) {
            player1.collectCards(warPile);
        } else {
            player2.collectCards(warPile);
        }
    }

    /**
     * repeats the game until it's over or reaches the maximum number of rounds.
     */
    @Override
    public void play() {
        int roundCount = 0;
        while (!isGameOver() && roundCount < MAX_ROUNDS) {
            playRound(); // Play one round
            roundCount++;
        }
        if (roundCount >= MAX_ROUNDS) {
            System.out.println("Reached maximum rounds. Declaring the game a draw!");
        } else {
            declareWinner(); // Determine the winner
        }
    }

    /**
     * declares the winner based on which player still has cards.
     */
    @Override
    public void declareWinner() {
        if (player1.hasCards() && !player2.hasCards()) {
            System.out.println(player1.getPlayerID() + " wins the game!");
        } else if (player2.hasCards() && !player1.hasCards()) {
            System.out.println(player2.getPlayerID() + " wins the game!");
        } else {
            System.out.println("The game is a draw!");
        }
    }
}
