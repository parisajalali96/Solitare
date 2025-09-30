package org.example.Models;

import java.util.Collections;

public class DeckPile extends Pile{
    @Override
    public boolean isMoveValid(Card card) {
        // can't move to the deck
        return false;
    }

    public void dealTo(WastePile waste) {
        if (!isEmpty()) {
            Card top = removeCard();
            top.setFaceUp(true);
            waste.addCard(top);
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }
}
