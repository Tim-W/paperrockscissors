package org.timw.player;

import org.timw.game.GameInput;

import java.util.Random;

public class Computer implements Player {
    @Override
    public GameInput pickOption(GameInput[] options) {
        Random random = new Random();
        int computerInput = random.nextInt(0, options.length);

        System.out.println("The computer chose " + options[computerInput].getName());

        return options[computerInput];
    }
}
