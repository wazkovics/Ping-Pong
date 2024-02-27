package com.example.week4;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class LabCanvas extends Canvas {
    public LabCanvas(double width, double height) {
        super(width, height);
    }

    public void drawGame(Game game) {
        resetSize(game);
        GraphicsContext gc = this.getGraphicsContext2D();
        drawBackground(gc);
        drawBall(gc, game.getBall());
        drawRacket(gc, game.getPlayer1().getRacket());
        drawRacket(gc, game.getPlayer2().getRacket());
//        drawTitle(gc, game.getPlayer1());
//        drawTitle(gc, game.getPlayer2());
    }

    private void drawBall(GraphicsContext gc, Ball ball) {
//        gc.setFill(Color.YELLOWGREEN);
//        gc.fillOval(ball.getPosX(), ball.getPosY(), ball.getRadius(), ball.getRadius());

        gc.drawImage(ball.getCage(),ball.getPosX(),ball.getPosY(),ball.getRadius(),ball.getRadius());
    }


    private void drawRacket(GraphicsContext gc, Racket racket) {
//        System.out.println("DRAW Racket " +
//                racket.getPosX() + "," + racket.getPosY() + "," + racket.getThickness() + "x" + racket.getSize());
        gc.setFill(racket.getColor());
        gc.fillRect(racket.getPosX(), racket.getPosY(), racket.getThickness(), racket.getSize());
    }

    private void resetSize(Game game) {
        this.setWidth(game.getDimensionX());
        this.setHeight(game.getDimensionY());
    }

    private void drawBackground(GraphicsContext gc) {
        gc.setFill(Color.BLACK);
        gc.clearRect(0, 0, this.getWidth(), this.getHeight());
        gc.fillRect(0, 0, this.getWidth(), this.getHeight());
    }
//    private void drawTitle(GraphicsContext gc, Player player1) {
//
//    }

}


