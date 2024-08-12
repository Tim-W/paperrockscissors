package org.timw.game;

import org.timw.player.Player;

import java.util.Map;

public class Game {
    // The different options that players can choose to play in a single round
    GameInput[] gameOptions;

    // The game rules described in a map: any <key, value> pair describes a
    // relation between two chosen options such as: <winning, losing>.
    // For example, the following means that paper beats rock, as paper is the key and rock the value in the map.
    // gameRules.put(new GameOption("paper"), new GameOption("rock"));
    Map<GameInput, GameInput> gameRules;

    // Player A is always the starting player
    Player playerA;
    Player playerB;

    int playerAWins = 0;
    int playerBWins = 0;
    int ties = 0;

    public Game(GameInput[] gameOptions, Map<GameInput, GameInput> gameRules, Player playerA, Player playerB) {
        this.gameOptions = gameOptions;
        this.gameRules = gameRules;
        this.playerA = playerA;
        this.playerB = playerB;
    }

    // Finish the game and print out the final score
    public void finish() {
        System.out.println("Wins: " + playerAWins);
        System.out.println("Losses: " + playerBWins);
        System.out.println("Ties: " + ties);
    }

    // Play the game, and return the value of comparePlayerOptions
    public int play() {
        GameInput playerAInput = playerA.pickOption(this.gameOptions);
        GameInput playerBInput = playerB.pickOption(this.gameOptions);

        int comparison = comparePlayerOptions(playerAInput, playerBInput);
        if (comparison == -1) {
            this.playerBWins++;
            System.out.println("Unfortunately, you lost...");
        } else if (comparison == 1) {
            this.playerAWins++;
            System.out.println("Congratulations, you won!");
        } else if (comparison == 0) {
            this.ties++;
            System.out.println("It was a tie.");
        }
        return comparison;
    }

    // Returns:
    // 1 if player A won
    // -1 if player B won
    // 0 if it was a tie
    private int comparePlayerOptions(GameInput playerAInput, GameInput playerBInput) {
        for (Map.Entry<GameInput, GameInput> entry: this.gameRules.entrySet()) {
            GameInput winningOpt = entry.getKey();
            GameInput losingOpt = entry.getValue();

            if (winningOpt == playerAInput && losingOpt == playerBInput) {
                // Player A wins
                return 1;
            }
            if (winningOpt == playerBInput && losingOpt == playerAInput) {
                // Player B wins
                return -1;
            }
        }
        return 0;
    }
}
