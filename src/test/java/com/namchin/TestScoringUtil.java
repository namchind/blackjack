package com.namchin;

import com.namchin.blackjack.ScoringUtil;
import com.namchin.blackjack.carddeck.Card;
import com.namchin.blackjack.enums.Rank;
import com.namchin.blackjack.enums.Suit;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestScoringUtil {

    @Test
    public void testGetBestScore_without_ace() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Rank.FIVE, Suit.CLUBS));
        cards.add(new Card(Rank.SEVEN,Suit.CLUBS));
        cards.add(new Card(Rank.SIX, Suit.CLUBS));
        cards.add(new Card(Rank.THREE, Suit.CLUBS));

        assertEquals(21, ScoringUtil.getBestScore(cards));
    }

    @Test
    public void testGetBestScore_1_ace() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Rank.THREE, Suit.CLUBS));
        cards.add(new Card(Rank.SIX, Suit.CLUBS));
        cards.add(new Card(Rank.SEVEN, Suit.CLUBS));
        cards.add(new Card(Rank.ACE, Suit.CLUBS));

        assertEquals(17, ScoringUtil.getBestScore(cards));
    }

    @Test
    public void testGetBestScore_4_aces() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Rank.SEVEN, Suit.CLUBS));
        cards.add(new Card(Rank.ACE, Suit.CLUBS));
        cards.add(new Card(Rank.ACE, Suit.DIAMONDS));
        cards.add(new Card(Rank.ACE, Suit.HEARTS));
        cards.add(new Card(Rank.ACE, Suit.SPADES));

        assertEquals(21, ScoringUtil.getBestScore(cards));
    }

    @Test
    public void testPlayerWins(){
        String actual = ScoringUtil.scorePlayer(1, 20, 19);
        String expected = "Scoring player 1 has 20, dealer has 19. Player 1 wins.";
        assertTrue(expected.equalsIgnoreCase(actual));
    }

    @Test
    public void testDealerWins(){
        String actual = ScoringUtil.scorePlayer(1, 20, 20);
        String expected = "Scoring player 1 has 20, dealer has 20. Dealer wins.";
        assertTrue(expected.equalsIgnoreCase(actual));
    }

    @Test
    public void testPlayerBusted(){
        String actual = ScoringUtil.scorePlayer(1, 23, 20);
        String expected = "Scoring player 1 busted. Dealer wins.";
        assertTrue(expected.equalsIgnoreCase(actual));
    }

    @Test
    public void testDealerBusted(){
        String actual = ScoringUtil.scorePlayer(1, 17, 22);
        String expected = "Scoring player 1 has 17, dealer busted. Player 1 wins.";
        assertTrue(expected.equalsIgnoreCase(actual));
    }

    @Test
    public void testDealerAndPlayerBusted(){
        String actual = ScoringUtil.scorePlayer(1, 23, 22);
        String expected = "Scoring player 1 and dealer busted. Player 1 ties.";
        assertTrue(expected.equalsIgnoreCase(actual));
    }
}
