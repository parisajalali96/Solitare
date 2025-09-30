package org.example.Models.Enums;

public enum Rank {
    A(1, "1"), TWO(2, "2"), THREE(3, "3"), FOUR(4, "4"), FIVE(5, "5"), SIX(6, "6"), SEVEN(7, "7"),
    EIGHT(8, "8"), NINE(9, "9"), TEN(10, "10"), JACK(11, "Jack"), QUEEN(12, "Queen"), KING(13, "King");

    private int value;
    private String name;
    Rank(int value, String name) {
        this.value = value;
        this.name = name;
    }
    public int getValue() {
        return value;
    }
    public String getName() {
        return name;
    }

}
