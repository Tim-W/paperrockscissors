package org.timw.player;

import org.timw.game.GameInput;

public interface Player {
    GameInput currentInput = null;
    public GameInput pickOption(GameInput[] options);
}
