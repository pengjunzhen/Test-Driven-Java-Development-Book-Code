package org.example.tddjava.chapter3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TicTacToeTest {

    private TicTacToe ticTacToe;
    @BeforeEach
    public final void initEach() {
        this.ticTacToe = new TicTacToe();
    }

    @Test
    public void should_throw_RuntimeException_when_x_outside_board() {
        Assertions.assertThrows(RuntimeException.class, () -> ticTacToe.play(5, 1));
    }

    @Test
    public void should_throw_RuntimeException_when_y_outside_board() {
        Assertions.assertThrows(RuntimeException.class, () -> ticTacToe.play(1, 5));
    }

    @Test
    public void should_throw_RuntimeException_when_position_occupied() {
        ticTacToe.play(1, 2);
        Assertions.assertThrows(RuntimeException.class, () -> ticTacToe.play(1, 2));
    }

    @Test
    public void should_return_X_when_given_first_player() {
        Assertions.assertEquals('X', ticTacToe.nextPlayer());
    }

    @Test
    public void should_return_O_when_last_player_was_X() {
        ticTacToe.play(1, 2);
        Assertions.assertEquals('O', ticTacToe.nextPlayer());
    }

    @Test
    public void should_return_X_when_last_player_was_O() {
        ticTacToe.play(1, 2);
        ticTacToe.play(2, 3);
        Assertions.assertEquals('X', ticTacToe.nextPlayer());
    }

    @Test
    public void should_return_no_winner_when_play() {
        Assertions.assertEquals("no winner", ticTacToe.play(1, 2));
    }

    @Test
    public void should_return_winner_when_the_play_the_whole_horizontal_line() {
        ticTacToe.play(1, 1); // X
        ticTacToe.play(1, 2); // O
        ticTacToe.play(2, 1); // X
        ticTacToe.play(2, 2); // O
        String actual = ticTacToe.play(3, 1); // X
        Assertions.assertEquals("X is the winner", actual);
    }

    @Test
    public void should_return_winner_when_the_play_the_whole_vertical_line() {
        ticTacToe.play(1, 1); // X
        ticTacToe.play(2, 1); // O
        ticTacToe.play(1, 2); // X
        ticTacToe.play(2, 2); // O
        String actual = ticTacToe.play(1, 3); // X
        Assertions.assertEquals("X is the winner", actual);
    }

    @Test
    public void should_return_winner_when_bottom_to_top_diagonal_line_played() {
        ticTacToe.play(1, 1);   // X
        ticTacToe.play(2, 1);   // O
        ticTacToe.play(2, 2);   // X
        ticTacToe.play(1, 2);   // O
        String result = ticTacToe.play(3, 3);   // X
        Assertions.assertEquals("X is the winner", result);
    }

    @Test
    public void should_return_winner_when_top_bottom_diagonal_line_played() {
        ticTacToe.play(1, 3);   // X
        ticTacToe.play(1, 2);   // O
        ticTacToe.play(2, 2);   // X
        ticTacToe.play(2, 1);   // O
        String result = ticTacToe.play(3, 1);   // X
        Assertions.assertEquals("X is the winner", result);
    }

    @Test
    public void should_draw_when_all_boxes_were_filled() {
        ticTacToe.play(1, 1);
        ticTacToe.play(1, 2);
        ticTacToe.play(1, 3);
        ticTacToe.play(2, 1);
        ticTacToe.play(2, 3);
        ticTacToe.play(2, 2);
        ticTacToe.play(3, 1);
        ticTacToe.play(3, 3);
        String actual = ticTacToe.play(3, 2);
        Assertions.assertEquals("The result is draw", actual);
    }
}

