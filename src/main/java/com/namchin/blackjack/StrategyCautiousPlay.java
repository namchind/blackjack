package com.namchin.blackjack;

import com.namchin.blackjack.carddeck.Card;

import java.util.List;

import static com.namchin.blackjack.ScoringUtil.getBestScore;

public class StrategyCautiousPlay implements BlackjackStrategy {

    @Override
    public boolean shouldStand(List<List<Card>> hands) {
        boolean isAllPlayerBusted = true;
        for (int i = 1; i < hands.size(); i++) {
            if (getBestScore(hands.get(i)) <= 21) {
                isAllPlayerBusted = false;
                break;
            }
        }
        if (isAllPlayerBusted)
            return true;
        else
            return getBestScore(hands.get(0)) >= 12;
    }
}
