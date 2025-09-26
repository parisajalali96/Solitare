package org.example.Models;

import java.util.List;

public class GameState {
    List<TableauPile> tableaus;
    List<FoundationPile> foundations;
    DeckPile deck;
    WastePile waste;

    void init(){
        //TODO shuffle and deal
    }

    boolean canMove(Card card, Pile targetPile) {
        // TODO canMove method in targetPile
        return false;
    }

    void move(Card card, Pile targetPile) {
        // TODO move card to target pile
    }

    boolean checkWin(){
        // TODO check if player has won
        return false;
    }

}
