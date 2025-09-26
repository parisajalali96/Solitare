package org.example.Models;

import java.util.List;
import java.util.Stack;

abstract class Pile {
    protected Stack<Card> cards;

    public Pile() {
        this.cards = new Stack<>();
    }

    public void addCard(Card card) {
        cards.push(card);
    }

    public Card removeCard() {
        return cards.isEmpty() ? null : cards.pop();
    }

    public Card peek() {
        return cards.isEmpty() ? null : cards.peek();
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }

    public int size() {
        return cards.size();
    }

    // abstract method for children to override
    public abstract boolean isMoveValid(Card card);

    // for moving multiple cards together
    public List<Card> getMovableStack(Card startCard) {
        return List.of(startCard);
    }

}
