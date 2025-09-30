package org.example.Models;

import org.example.Models.Enums.Rank;
import org.example.Models.Enums.Suit;

import java.util.ArrayList;
import java.util.List;

public class GameState {
    private List<TableauPile> tableaus;
    private List<FoundationPile> foundations;
    private DeckPile deck;
    private WastePile waste;

    void init(){
        //initialize the piles
        tableaus = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            tableaus.add(new TableauPile());
        }

        foundations = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            foundations.add(new FoundationPile(suit));
        }

        deck = new DeckPile();
        waste = new WastePile();
        //create all 52 cards
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                deck.addCard(new Card(suit, rank));
            }
        }
        deck.shuffle();
        //deal cards into tableaus
        for (int i = 0; i < tableaus.size(); i++) {
            for (int j = 0; j <= i; j++) {
                Card card = deck.removeCard();
                if (j == i) {
                    card.setFaceUp(true); //last card faces up
                }
                tableaus.get(i).addCard(card);
                card.setCurrentPile(tableaus.get(i));
            }
        }

    }

    boolean canMove(Card card, Pile targetPile) {
        return targetPile.isMoveValid(card);
    }

    void move(Card card, Pile targetPile) {
        if (canMove(card, targetPile)) {
            Pile source = card.getCurrentPile();
            if (source != null) {
                source.removeCard();
                targetPile.addCard(card);
                card.setCurrentPile(targetPile);
            }
        }
    }

    boolean checkWin(){
        //win if all foundation piles are complete
        for (FoundationPile f : foundations) {
            if (f.size() < 13) return false;
        }
        return true;
    }

    public List<TableauPile> getTableaus() {
        return tableaus;
    }
    public List<FoundationPile> getFoundations() {
        return foundations;
    }
    public DeckPile getDeck() {
        return deck;
    }
    public WastePile getWaste() {
        return waste;
    }

}
