package org.example.Models;

import org.example.Models.Enums.Rank;
import org.example.Models.Enums.Suit;

public class FoundationPile extends Pile{
    private Suit suit;

    public FoundationPile(Suit suit) {
        super();
        this.suit = suit;
    }

    @Override
    public boolean isMoveValid(Card card) {
        if (card.getSuit() != suit) return false;
        if (isEmpty()) return card.getRank() == Rank.A;
        return card.getRank().getValue() == peek().getRank().getValue() + 1;
    }

}
