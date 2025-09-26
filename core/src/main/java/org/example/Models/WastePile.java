package org.example.Models;

public class WastePile extends Pile{
    @Override
    public boolean isMoveValid(Card card) {
        // only if it's the top card
        return card == peek();
    }
}
