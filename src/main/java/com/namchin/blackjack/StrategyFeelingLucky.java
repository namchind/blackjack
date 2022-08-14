package com.namchin.blackjack;

import com.namchin.blackjack.carddeck.Card;

import java.util.List;

import static com.namchin.blackjack.ScoringUtil.getBestScore;

public class StrategyFeelingLucky implements BlackjackStrategy {

    @Override
    public boolean shouldStand(List<List<Card>> hands) {
        return getBestScore(hands.get(0)) >= 21;
    }
}
