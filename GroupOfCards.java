package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

public class GroupOfCards {
   
    private ArrayList<Card> cards;
    private int size;

    public GroupOfCards(int givenSize) {
        size = givenSize;
        cards = new ArrayList<>(givenSize);
    }

    public ArrayList<Card> showCards() {
        return cards;
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public int getSize() {
        return size;
    }

    public void setSize(int givenSize) {
        size = givenSize;
    }

    // Add this method to set the group of cards
    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }
}
