package org.timw.game;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.timw.Main;
import org.timw.player.Player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.timw.Main.*;

@ExtendWith(MockitoExtension.class)
class GameTest {
    Player player1 = mock(Player.class);
    Player player2 = mock(Player.class);

    @Test
    void TestRockPaperScissors() {
        Game game = new Game(Main.rpsOptions, Main.rockPaperScissorsRules(), player1, player2);

        // "Randomly" pick out of 1 option, to fix the game beforehand
        // Player 1 should lose
        when(player1.pickOption(rpsOptions)).thenReturn(rock);
        when(player2.pickOption(rpsOptions)).thenReturn(paper);
        assertEquals(game.play(), -1);

        // Should be a tie
        when(player1.pickOption(rpsOptions)).thenReturn(rock);
        when(player2.pickOption(rpsOptions)).thenReturn(rock);
        assertEquals(game.play(), 0);

        // Player 1 should win
        when(player1.pickOption(rpsOptions)).thenReturn(scissors);
        when(player2.pickOption(rpsOptions)).thenReturn(paper);
        assertEquals(game.play(), 1);

        assertEquals(game.playerAWins, 1);
        assertEquals(game.playerBWins, 1);
        assertEquals(game.ties, 1);

        game.finish();
    }
}