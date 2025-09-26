package org.example.Models;

import org.example.Models.Enums.Rank;
import org.example.Models.Enums.Suit;

public class Card {
    private final Suit suit;
    private final Rank rank;
    private boolean isFaceUp;
    private Pile currentPile;

    public Card(Suit suit, Rank rank){
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }
    public Rank getRank() {
        return rank;
    }
    public boolean isFaceUp() {
        return isFaceUp;
    }
    public Pile getCurrentPile() {
        return currentPile;
    }
    public void setCurrentPile(Pile currentPile) { // for moving the card
        this.currentPile = currentPile;
    }
    public void setFaceUp(boolean faceUp) {
        isFaceUp = faceUp;
    }

}
