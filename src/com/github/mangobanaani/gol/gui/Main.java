package com.github.mangobanaani.gol.gui;

import com.github.mangobanaani.gol.game.GameBoard;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 Copyright (c) by mangobanaani 2017.

 This program is free software: you can redistribute it and/or modify
 it under the terms of the GNU General Public License as published by
 the Free Software Foundation, either version 3 of the License, or
 (at your option) any later version.
 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.
 You should have received a copy of the GNU General Public License
 along with this program.  If not, see <http://www.gnu.org/licenses/>
 */

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception{

        final int width = 800;
        final int height = 800;

        stage.setTitle("Game of Life");

        Group root = new Group();
        Scene scene = new Scene(root);
        stage.setScene(scene);

        Canvas canvas = new Canvas(width, height);
        root.getChildren().add(canvas);

        GraphicsContext gc = canvas.getGraphicsContext2D();

        GameBoard board = new GameBoard(200, 200);
        board.initRandomly();

        new AnimationTimer() {
            private static final long sleepNanoseconds = 500000000L;
            private long prevTime = 0;

            public void handle(long currentNanoTime) {
                if ((currentNanoTime - prevTime) < sleepNanoseconds) {
                    return;
                }

                gc.setFill(Color.WHITE);
                gc.clearRect(0, 0, width, height);  // clear screen

                gc.setFill(Color.BLACK);
                int[][] boardcopy = board.getBoard(); //  draw board with 4*4 blocks
                int x = 0;
                while (x < boardcopy.length) {
                    int y = 0;
                    while (y < boardcopy[x].length) {
                        int value = boardcopy[x][y];
                        if (value == 1) {
                            gc.fillRect(x * 4, y * 4, 4, 4);
                        }
                        y++;
                    }
                    x++;
                }

                board.evolve();
                prevTime = currentNanoTime;
            }
        }.start();

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
