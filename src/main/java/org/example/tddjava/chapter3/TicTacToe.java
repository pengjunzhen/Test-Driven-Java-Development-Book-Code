package org.example.tddjava.chapter3;

public class TicTacToe {

    private Character[][] board = {{'\0', '\0', '\0'}, {'\0', '\0', '\0'}, {'\0', '\0', '\0'}};
    private Character lastPlayer = '\0';
    private static final int SIZE = 3;

    public String play(int x, int y) {
        checkAxis(x);
        checkAxis(y);
        lastPlayer = nextPlayer();
        setBox(x, y);
        if (isWin(x, y)) {
            return lastPlayer + " is the winner";
        } else if (isDraw()) {
            return "The result is draw";
        }
        return "no winner";
    }

    private boolean isDraw() {
        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
                if (board[x][y] == '\0') {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isWin(int x, int y) {

        int playerTotal = lastPlayer * 3;
        char diagonal1, diagonal2, horizontal, vertical;
        diagonal1 = diagonal2 = horizontal = vertical = '\0';
        for (int i = 0; i < SIZE; i++) {
            vertical += board[x - 1][i];
            horizontal += board[i][y - 1];
            diagonal1 += board[i][i];
            diagonal2 += board[i][SIZE - i - 1];
        }

        if (diagonal1 == playerTotal
                || diagonal2 == playerTotal
                || horizontal == playerTotal
                || vertical == playerTotal) {
            return true;
        }
        return false;
    }

    private void checkAxis(int axis) {
        if (axis < 1 || axis > 3) {
            throw new RuntimeException();
        }
    }

    private void setBox(int x, int y) {
        if (board[x - 1][y - 1] != '\0') {
            throw new RuntimeException();
        } else {
            board[x - 1][y - 1] = lastPlayer;
        }
    }

    public char nextPlayer() {
        if (lastPlayer != 'X') {
            return 'X';
        }
        return 'O';
    }
}
