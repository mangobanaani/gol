package game;

import org.jetbrains.annotations.NotNull;

/**
 * Created by pekka on 11/05/2017.
 */

public class Board {

    @NotNull
    private final int[][] board;
    private final int boardHeight;
    private final int boardWidth;

    public Board(int xsize, int ysize) {
        this.board = new int[xsize][ysize];
        this.boardWidth=xsize;
        this.boardHeight=ysize;
    }

    public int getBoardWidth() {
        return this.boardWidth;
    }

    public int getBoardHeight() {
        return this.boardHeight;
    }

    public void set(int x, int y) {
        this.board[x][y] = 1;
    }

    public void unset(int x, int y) {
        this.board[x][y] = 0;
    }

    public boolean isSet(int x, int y) {
        return board[x][y] == 1;
    }

    public void clear(){
        for(int y=0;y<this.boardHeight;y++){
            for(int x=0;x<this.boardWidth;x++){
                this.board[x][y]=0;
            }
        }
    }

    @NotNull
    @Override
    public String toString(){
        StringBuilder sb=new StringBuilder();
        for(int y=0;y<this.boardHeight;y++){
            for(int x=0;x<this.boardWidth;x++){
                sb.append(this.board[x][y]);
            }
        }
        return sb.toString();
    }
}
