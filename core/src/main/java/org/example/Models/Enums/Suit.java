package org.example.Models.Enums;

public enum Suit {
    hearts, spades,
    clubs, diamonds;

    public boolean isRed(){
       return this == Suit.hearts || this == Suit.diamonds;
    }

}
