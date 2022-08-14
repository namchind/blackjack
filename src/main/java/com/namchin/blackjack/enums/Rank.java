package com.namchin.blackjack.enums;

import lombok.Getter;

public enum Rank {
    ACE(1, "Ace"), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(10, "Jack"), QUEEN(10, "Queen"), KING(10, "King");
    @Getter
    private final int value;
    @Getter
    private final String name;
    Rank(int value, String name){
        this.value = value;
        this.name = name;
    }
    Rank(int value){
        this.value = value;
        this.name = String.valueOf(value);
    }
}
