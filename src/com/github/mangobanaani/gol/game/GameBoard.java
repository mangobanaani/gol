package com.github.mangobanaani.gol.game;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by mangobanaani on 11/05/2017.
 */

public class GameBoard extends Board{

    @SuppressWarnings("SameParameterValue")
    public GameBoard(int width, int height){
        super(width,height);
    }

    public void initRandomly() {
        Random rnd = new Random();

        int x = 0;
        while (x < board.length) {
            int y = 0;
            while (y < board[x].length) {
                if (rnd.nextDouble() < 0.2) board[x][y] = 1;
                y++;
            }
            x++;
        }
    }

    public void evolve() {
        int[][] clone = new int[this.board.length][this.board[0].length];

        for (int i = 0; i < board.length; i++) {
            System.arraycopy(board[i], 0, clone[i], 0, board[i].length);
        }

        for (int i = 0; i < clone.length; i++) {
            for (int j = 0; j < clone[i].length; j++) {
                if (clone[i][j] == 1 && !(livingNeighbours(clone, i, j) == 2 || livingNeighbours(clone, i, j) == 3)) {
                    board[i][j] = 0;
                }else if(clone[i][j] == 0 && livingNeighbours(clone, i, j) == 3) {
                    board[i][j] = 1;
                }
            }
        }

    }

    public int[][] getBoard() {
        return board;
    }

    private int livingNeighbours(int[][] t, int x, int y) {
        int count = 0;
        int[][] surrounding = {
                {x - 1, y - 1},
                {x - 1, y    },
                {x - 1, y + 1},
                {x    , y - 1},
                {x    , y + 1},
                {x + 1, y - 1},
                {x + 1, y    },
                {x + 1, y + 1}};
        for (int i[]: surrounding) {
            try {
                if (t[i[0]][i[1]] == 1) {
                    count++;
                }
            }
            catch (ArrayIndexOutOfBoundsException e) {
                Logger.getAnonymousLogger().log(Level.ALL,e.getLocalizedMessage());
            }
        }
        return count;
    }
}
