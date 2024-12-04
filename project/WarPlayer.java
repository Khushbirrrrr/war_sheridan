package ca.sheridancollege.project;

import java.util.ArrayList;

public class WarPlayer extends Player {
    private ArrayList<WarCard> hand;

    public WarPlayer(String name) {
        super(name);
        hand = new ArrayList<>();
    }

    // it adds a card to the player's hand
    public void addCard(WarCard card) {
        hand.add(card); // it adss the card to the end of the hand
    }

    // this adds a card to the bottom of the player's hand
    public void addCardToBottom(WarCard card) {
        hand.add(card); // adds the card to the bottom of the hand (end of the ArrayList)
    }

    // method to return the number of cards in the hand
    public int handSize() {
        return hand.size(); // retrunds the size of the hand
    }

    public WarCard playCard() {
        if (!hand.isEmpty()) {
            return hand.remove(0); // this draws and removes the top card (first in the ArrayList)
        }
        return null;
    }

    public boolean hasCards() {
        return !hand.isEmpty();
    }

    //  to collect multiple cards at once, used for collecting winnings in a war
    public void collectCards(ArrayList<WarCard> cards) {
        hand.addAll(cards); // all the cards to the end of the player's hand
    }

    @Override
    public void play() {
        // no needed for WarPlayer, as the game logic is handled in WarGame
    }
}
