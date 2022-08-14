package com.namchin.blackjack.enums;

public enum Suit {
    HEARTS("Hearts"), SPADES("Spades"), CLUBS("Clubs"), DIAMONDS("Diamonds");
    private final String name;

    Suit(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

}
