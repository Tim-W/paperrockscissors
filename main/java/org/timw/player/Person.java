package org.timw.player;

import org.timw.game.GameInput;

import java.util.Scanner;

public class Person implements Player {

    public GameInput pickOption(GameInput[] options) {
        // Reading the word that the player selects, and seeing if it exists in one of the input options.
        // If not, prompt the user to try again.
        Scanner scanner = new Scanner(System.in);
        String playerInputText;
        int playerInput = -1;

        while(playerInput == -1) {
            System.out.print("Please enter your choice, one of: ");
            String optionsDisplay = "";
            for (int i = 0; i < options.length; i++) {
                optionsDisplay += options[i].getName();
                if (i != options.length - 1) {
                    optionsDisplay += ", ";
                }
            }
            optionsDisplay += ".\n";
            System.out.print(optionsDisplay);

            playerInputText = scanner.next();
            playerInput = interpretInput(options, playerInputText);
        }

        return options[playerInput];
    }

    private static int interpretInput(GameInput[] options, String playerInput) {
        playerInput = playerInput.toLowerCase();
        for (int i = 0; i < options.length; i++) {
            if (playerInput.equals(options[i].getName())) {
                return i;
            }
        }
        return -1;
    }
}
