package com.namchin.blackjack;

import com.namchin.blackjack.carddeck.Card;
import com.namchin.blackjack.enums.Rank;

import java.util.List;

public class ScoringUtil {
     public static int getBestScore(List<Card> cards) {
        int totalScore = cards.stream().filter(card -> card.getRank().getValue() != 1).mapToInt(card -> card.getRank().getValue()).sum();
        int countAces = (int) cards.stream().filter(card -> card.getRank() == Rank.ACE).count();
        switch (countAces) {
            case 4:
                if (totalScore <= 7) totalScore += 14;
                else totalScore += 4;
                break;
            case 3:
                if (totalScore <= 8) totalScore += 13;
                else totalScore += 3;
                break;
            case 2:
                if (totalScore <= 9) totalScore += 12;
                else totalScore += 2;
                break;
            case 1:
                if (totalScore <= 10) totalScore += 11;
                else totalScore += 1;
                break;
        }
        return totalScore;
    }

    public static String scorePlayer(int playerNum, int playerScore, int dealerScore) {

        if (playerScore > 21) {
            if (dealerScore <= 21)
                return "Scoring player " + playerNum + " busted. Dealer wins.";
            else
                return "Scoring player " + playerNum + " and dealer busted. Player " + playerNum + " ties.";
        }

        if (dealerScore > 21)
            return "Scoring player " + playerNum + " has " + playerScore + ", dealer busted. Player " + playerNum + " wins.";

        if (dealerScore >= playerScore)
            return "Scoring player " + playerNum + " has " + playerScore + ", dealer has " + dealerScore + ". Dealer wins.";
        else
            return "Scoring player " + playerNum + " has " + playerScore + ", dealer has " + dealerScore + ". Player " + playerNum + " wins.";
    }
}
