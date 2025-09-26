package org.example.Models;

import org.example.Models.Enums.Rank;

import java.util.List;

public class TableauPile extends Pile{

    @Override
    public boolean isMoveValid(Card card) {
        if (isEmpty()) return card.getRank() == Rank.KING;
        Card top = peek();
        return ((top.getSuit().isRed() != card.getSuit().isRed()) &&
            (top.getRank().getValue() == card.getRank().getValue() - 1));
    }

    @Override
    public List<Card> getMovableStack(Card startCard) {
        int index = cards.indexOf(startCard);
        if (index == -1 || !startCard.isFaceUp()) return List.of();
        return cards.subList(index, cards.size());
    }

}
