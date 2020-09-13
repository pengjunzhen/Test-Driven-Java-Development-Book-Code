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

}
