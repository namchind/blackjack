package com.namchin;

import com.namchin.blackjack.*;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        int players;
        try {
            players = Integer.parseInt(args[0]);
        } catch (Exception e) {
            System.out.println("Failed to define number of players from command line argument. Setting with default value 1.");
            players = 1;
        }
        if (players > 3) {
            System.out.println("Number of players can't be " + players + ". Maximum number of players is 3. Resetting it with 3.");
            players = 3;
        }
        if (players < 1) {
            System.out.println("Number of players can't be " + players + ". Minimum number of players is 1. Resetting it with 1.");
            players = 1;
        }

        int dealerStrategyNumber = 1;
        if (args.length > 1)
            try {
                dealerStrategyNumber = Integer.parseInt(args[1]);
            } catch (Exception e) {
                // doNothing
            }
        BlackjackStrategy gameStrategy = new StrategyCautiousPlay();
        switch ((dealerStrategyNumber-1) % 3) {
            case 0: break;
            case 1: gameStrategy = new StrategyBasicInstinct(); break;
            case 2: gameStrategy = new StrategyFeelingLucky(); break;
        }
        System.out.println("Strategy:" + gameStrategy.getClass());

        Blackjack blackjack = new Blackjack(players, gameStrategy);
        blackjack.play();
    }
}
