package org.example.tddjava.chapter3;

public class TicTacToe {

    public void play(int x, int y) {
        if (x < 1 || x > 3) {
            throw new RuntimeException();
        } else if (y < 1 || y > 3) {
            throw new RuntimeException();
        }
    }
}
