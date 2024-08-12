package org.timw.game;

// A GameInput represents a choice that a player can make in one turn of the game.
public class GameInput {
    String name;

    public String getName() {
        return name;
    }

    public GameInput(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof GameInput) {
            GameInput other = (GameInput) obj;
            return name.equals(other.name);
        }
        return super.equals(obj);
    }
}
