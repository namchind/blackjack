package com.namchin.blackjack.carddeck;

import com.namchin.blackjack.enums.Rank;
import com.namchin.blackjack.enums.Suit;

import java.util.Collections;
import java.util.Stack;

public class Deck {
    final private Stack<Card> cards;

    public Deck() {
        cards = new Stack<>();
        for (Rank rank: Rank.values()) {
            for(Suit suit: Suit.values()) {
                cards.add(new Card(rank, suit));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card deal() {
        if (getCount()==0)
            throw new RuntimeException("Deck is empty!");
        return cards.pop();
    }

    public int getCount(){
        return cards.size();
    }

}
