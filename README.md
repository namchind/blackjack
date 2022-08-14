# Blackjack game 
A simple textual console version of blackjack card game.

### Rule of the game
1. Computer is the dealer and deals cards to the players.
2. Player makes the decision to receive(hit) another card or to stop(stand). 
3. Whoever comes closer to 21 without busting over 21 wins.
4. Numeric cards counted as their number, face cards counted 10 and the aces can be 1 or 11 for the best score.
5. Dealer(computer) receives cards after all players done.
6. Scores:
   1. If a player has more than 21, the player is busted. Dealer wins.
   2. If dealer is busted over 21, whichever players not busted win. And players busted tie.
   3. When dealer wins the players who have scores less than or equal to dealer's.

### Playing
When the game starts, computer deals everyone one each card.
Then players play their turn starting from the first player. 
Dealer does the turn after players
Finally, scoring will be printed.


### Running the app

1. Compile the app
```
mvn clean build
```

2. You can run the app with maven command like below or simply run it with a jvm.
```
mvn exec:java -Dexec.mainClass=com.namchin.App "-Dexec.args=3 1"
```

```
java -cp target/blackjack-1.0-SNAPSHOT.jar com.namchin.App 3
```

3. Once the game started, it asks each player to play. 
The player can enter `hit` or `stand` to the prompt.
```
Dealing to player 1, cards: 2 Clubs, 7 Clubs. Hit[h] or Stand[s]? > hit
```

4. After all player do their turns, the dealer completes the game and prints outs game result.

### Computer strategy

Dealer strategy can be changed by second command line argument.\
1 - StrategyCautiousPlay: Dealer stands if all players busted or whenever reaches 12.\
2 - StrategyBasicInstinct: Dealer stands whenever reaches 17.\
3 - StrategyFeelingLucky: Dealer won't stand until reaches 21.

If second command line argument is not provided then by default StrategyCautiousPlay is chosen.


