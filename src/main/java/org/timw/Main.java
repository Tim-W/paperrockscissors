// @Author Tim-W

package org.timw;

import org.timw.game.Game;
import org.timw.game.GameInput;
import org.timw.player.Computer;
import org.timw.player.Person;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// A simple rock paper scissors game.
// User enters rock, paper or scissors in the CLI and the computer will select either
// rock, paper or scissors randomly. The game continues until one player wins.
public class Main {
    // All the possible options that a player has when playing rock paper scissors game
    public static GameInput rock = new GameInput("rock");
    public static GameInput paper = new GameInput("paper");
    public static GameInput scissors = new GameInput("scissors");
    public static GameInput[] rpsOptions = new GameInput[] {rock, paper, scissors};

    // The game rules of Rock Paper Scissors in a map.
    // It maps relations between two game inputs in the following way: <key, value> marks <winning, losing>.
    public static Map<GameInput, GameInput> rockPaperScissorsRules() {
        Map<GameInput, GameInput> rpsRules = new HashMap<>();
        // For example, this means that paper beats rock, as paper is the key and rock the value in the map.
        rpsRules.put(paper, rock);
        rpsRules.put(rock, scissors);
        rpsRules.put(scissors, paper);
        return rpsRules;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the Rock Paper Scissors game.");
        Game game = new Game(rpsOptions, rockPaperScissorsRules(), new Person(), new Computer());

        play(game);

        Scanner scanner = new Scanner(System.in);
        // If the game was a tie, we will keep playing
        while (!scanner.nextLine().equals("finish")) {
            play(game);
        }
        game.finish();
    }

    private static void play(Game game) {
        game.play();
        System.out.println("Press enter to start another round.");
        System.out.println("Or, type 'finish' to finish the game and see the overall score.");
    }
}
