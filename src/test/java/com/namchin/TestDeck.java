package com.namchin;

import com.namchin.blackjack.carddeck.Card;
import com.namchin.blackjack.carddeck.Deck;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestDeck {
    Deck classUnderTest;
    final static int NUMBER_OF_CARDS = 52;

    @BeforeEach
    public void beforeEach(){
        classUnderTest = new Deck();
    }

    @Test
    public void testNumberOfCards(){
        assertEquals(NUMBER_OF_CARDS, classUnderTest.getCount());
    }

    @Test
    public void testDeal() {
        classUnderTest.deal();
        assertEquals(NUMBER_OF_CARDS-1, classUnderTest.getCount());
    }

    @Test
    public void testShuffle() {
        classUnderTest.shuffle();
        int diff = 0;
        Deck notShuffled = new Deck();

        for (int i = 0; i < NUMBER_OF_CARDS; i++) {
            Card card1 = notShuffled.deal();
            Card card2 = classUnderTest.deal();
            if (card1.getRank() != card2.getRank() || card1.getSuit() != card2.getSuit())
                diff++;
        }
        assertTrue(diff > 0);
    }

    @Test
    public void testEmptyDeck() {
        Exception thrown = assertThrows(Exception.class, () -> {
            for (int i = 0; i < NUMBER_OF_CARDS+1; i++) {
                classUnderTest.deal();
            }
        });
        assertEquals("Deck is empty!", thrown.getMessage());
    }

}
