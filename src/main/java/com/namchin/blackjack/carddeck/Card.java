package com.namchin.blackjack.carddeck;

import com.namchin.blackjack.enums.Rank;
import com.namchin.blackjack.enums.Suit;
import lombok.Getter;

@Getter
public class Card {
    private final Rank rank;
    private final Suit suit;

    public Card(Rank rank, Suit suit) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public String toString(){
        return rank.getName() + " " + suit.getName();
    }

}
