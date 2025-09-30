package org.example.Models.Enums;

public enum Suit {
    hearts("Hearts"), spades("Spades"),
    clubs("Clubs"), diamonds("Diamonds");

    private String name;
    Suit(String name) {
        this.name = name;
    }
    public boolean isRed(){
       return this == Suit.hearts || this == Suit.diamonds;
    }
    public String getName() {
        return name;
    }

}
