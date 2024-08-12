package org.timw.game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameInputTest {
    GameInput a = new GameInput("abc");
    GameInput b = new GameInput("xyz");
    GameInput c = new GameInput("abc");

    @Test
    void TestEquals() {
        assertNotEquals(a, b);
        assertEquals(a, c);
    }
}