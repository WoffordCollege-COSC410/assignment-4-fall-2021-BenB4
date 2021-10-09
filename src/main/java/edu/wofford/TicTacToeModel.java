package edu.wofford;

import javax.swing.border.Border;

import org.assertj.swing.dependency.fest_util.ToString;

public class TicTacToeModel {
    // 2d array with values of -1, 0, or 1. "O" -> -1, blank -> 0, "X" -> 1
    private int[][] board;
    
    //-1 -> player "O"'s turn, 1 -> player "X"'s turn
    private int turn;


    public TicTacToeModel() {
        board = new int[3][3];
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                board[i][j] = 0;
            }
        }
        turn = 1;
        
    }


    public String getMark(int x, int y) {
        if (x < 0 || x > 2 || y < 0 || y > 2) {
            throw new ArrayIndexOutOfBoundsException();
        }

        if (board[x][y] == 1) {
            return "X";
        } else if (board[x][y] == -1) {
            return "O";
        }
        return " ";
    }


    private boolean isValidAtLocation(int x, int y) {
        if (x < 0 || x > 2 || y < 0 || y > 2) {
            return false;
        }
        return board[x][y] == 0;
    }


    public boolean markBoard(int x, int y) {
        if (isValidAtLocation(x, y)) {
            board[x][y] = turn;
            if (!isOver()) {
                turn *= -1;
            }
            return true;
        }
        return false;
    }


    private int sumRow(int row) {
        int sum = 0;
        for(int i=0; i<3; i++) {
            sum += board[row][i];
        }
        return sum;
    }


    private int sumCol(int col) {
        int sum = 0;
        for(int i=0; i<3; i++) {
            sum += board[i][col];
        }
        return sum;
    }


    private int sumTopLeftToBottomRightDiagonal() {
        return board[0][0] + board[1][1] + board[2][2];
    }


    private int sumTopRightToBottomLeftDiagonal() {
        return board[0][2] + board[1][1] + board[2][0];
    }


    public boolean hasWinner() {
        boolean threeInARow = false;

        for (int i=0; i<3; i++) {
            threeInARow = threeInARow || (Math.abs(sumCol(i)) == 3);
            threeInARow = threeInARow || (Math.abs(sumRow(i)) == 3);          
        }
        threeInARow = threeInARow || (Math.abs(sumTopLeftToBottomRightDiagonal()) == 3);
        threeInARow = threeInARow || (Math.abs(sumTopRightToBottomLeftDiagonal()) == 3);

        return threeInARow;
    }


    public boolean isFull() {
        boolean isZero = false;

        for (int j=0; j<3; j++){
            for (int k=0; k<3; k++) {
                isZero = isZero || (board[j][k] == 0);
            }
        }

        return !isZero;
    }

    public boolean isOver() {
        boolean threeInARow = hasWinner();
        boolean isZero = isFull();

        return threeInARow || isZero;
    }


    public String getPlayerTurn() {
        if (turn == 1) {
            return "X";
        }
        return "O";
    }


    public String toString() {
        String board_string = "";

        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                board_string += getMark(i, j);
                if (j < 2) {
                    board_string += "|";
                }
            }

            if (i < 2) {
                board_string += "\n-----\n";
            }
        }
        return board_string;
    }
}