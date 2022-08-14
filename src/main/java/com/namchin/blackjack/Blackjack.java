package com.namchin.blackjack;

import com.namchin.blackjack.carddeck.Card;
import com.namchin.blackjack.carddeck.Deck;
import com.namchin.blackjack.enums.PlayerAction;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static com.namchin.blackjack.ScoringUtil.getBestScore;
import static com.namchin.blackjack.ScoringUtil.scorePlayer;

public class Blackjack {
    private final int numPlayers;
    private final Deck deck = new Deck();
    private final BlackjackStrategy dealerStrategy;
    private final List<List<Card>> hands = new ArrayList<>();

    public Blackjack(int numPlayers, BlackjackStrategy strategy) {
        this.numPlayers = numPlayers;
        this.dealerStrategy = strategy;
    }

    public void play() {
        startGame();
        drawByPlayers();
        drawByComputer();
        showScores();
    }

    private void startGame() {
        System.out.println("Starting game with " + numPlayers + " players.");
        System.out.println("Shuffling.");
        deck.shuffle();
        for (int i = 0; i <= numPlayers; i++) {
            hands.add(new ArrayList<>());
        }
        for (int i = 1; i <= numPlayers; i++) {
            dealToPlayer(i);
            System.out.println();
        }
        dealToComputer(true);
        System.out.println();
    }

    private void drawByPlayers() {
        for (int i = 1; i <= numPlayers; i++) {
            PlayerAction action = PlayerAction.HIT;
            while (action == PlayerAction.HIT) {
                dealToPlayer(i);
                if (isPlayerBusted(i)) {
                    System.out.println("Busted over 21.");
                    break;
                }
                action = askPlayerAction();
            }
        }
    }

    private void drawByComputer() {
        boolean dealerStand = false;
        while (!dealerStand) {
            dealToComputer(false);
            if (isPlayerBusted(0)) {
                System.out.println("Dealer busted over 21.");
                break;
            }
            dealerStand = dealerStrategy.shouldStand(hands);
            if (!dealerStand) System.out.println(" Dealer hits.");
            else System.out.println(" Dealer stands.");
        }
    }

    private void dealToPlayer(int i) {
        hands.get(i).add(deck.deal());
        System.out.print("Dealing to player " + i + ", cards: " + hands.get(i).stream().map(Card::toString).collect(Collectors.joining(", ")) + ". ");
    }

    private void dealToComputer(boolean faceDown) {
        hands.get(0).add(deck.deal());
        System.out.print("Dealing to computer, cards: " + (faceDown ? "face down" : hands.get(0).stream().map(Card::toString).collect(Collectors.joining(", "))) + ". ");
    }

    private boolean isPlayerBusted(int i) {
        return getBestScore(hands.get(i)) > 21;
    }

    private PlayerAction askPlayerAction() {
        Scanner sc = new Scanner(System.in);
        String answer = "";

        while (!(answer.equalsIgnoreCase("hit") || answer.equalsIgnoreCase("h") || answer.equalsIgnoreCase("stand") || answer.equalsIgnoreCase("s"))) {
            System.out.print("Hit[h] or Stand[s]? > ");
            answer = sc.next();
        }
        return (answer.equalsIgnoreCase("hit") || answer.equalsIgnoreCase("h")) ? PlayerAction.HIT : PlayerAction.STAND;
    }

    private void showScores() {
        int dealerScore = getBestScore(hands.get(0));
        for (int i = 1; i <= numPlayers; i++) {
            int playerScore = getBestScore(hands.get(i));
            System.out.println(scorePlayer(i, playerScore, dealerScore));
        }
    }
}
