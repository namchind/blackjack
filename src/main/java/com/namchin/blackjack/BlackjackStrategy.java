package com.namchin.blackjack;

import com.namchin.blackjack.carddeck.Card;

import java.util.List;

public interface BlackjackStrategy {
    boolean shouldStand(List<List<Card>> playersHand);
}

