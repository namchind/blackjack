package com.namchin;

import com.namchin.blackjack.BlackjackStrategy;
import com.namchin.blackjack.StrategyCautiousPlay;
import com.namchin.blackjack.carddeck.Card;
import com.namchin.blackjack.enums.Rank;
import com.namchin.blackjack.enums.Suit;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestStrategyCautiousPlay {
    private final BlackjackStrategy classUnderTest = new StrategyCautiousPlay();

    @Test
    public void testStand(){
        List<List<Card>> hands = new ArrayList<>();
        hands.add(Arrays.asList(new Card(Rank.FOUR, Suit.CLUBS), new Card(Rank.FOUR, Suit.DIAMONDS), new Card(Rank.FOUR, Suit.HEARTS)));
        hands.add(Collections.singletonList(new Card(Rank.FIVE, Suit.CLUBS)));
        boolean actual = classUnderTest.shouldStand(hands);
        assertTrue(actual);
    }

    @Test
    public void testStandWhenAllPlayersBusted(){
        List<List<Card>> hands = new ArrayList<>();
        hands.add(Arrays.asList(new Card(Rank.FOUR, Suit.CLUBS), new Card(Rank.FOUR, Suit.DIAMONDS), new Card(Rank.FOUR, Suit.HEARTS)));
        hands.add(Collections.singletonList(new Card(Rank.FIVE, Suit.CLUBS)));
        boolean actual = classUnderTest.shouldStand(hands);
        assertTrue(actual);
    }

    @Test
    public void testHit(){
        List<List<Card>> hands = new ArrayList<>();
        hands.add(Arrays.asList(new Card(Rank.FOUR, Suit.CLUBS), new Card(Rank.FOUR, Suit.DIAMONDS), new Card(Rank.TWO, Suit.HEARTS)));
        hands.add(Collections.singletonList(new Card(Rank.FIVE, Suit.CLUBS)));
        boolean actual = classUnderTest.shouldStand(hands);
        assertFalse(actual);
    }
}
