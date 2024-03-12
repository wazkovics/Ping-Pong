package com.example.week4;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class LabCanvas extends Canvas {

    private GraphicsContext gc;
    private Game game;

    /**
     * Create a new canvas with width and height
     * @param width The width in pixels,of the canvas you would like to create
     * @param height The height in pixels, of the canvas you would like to create
     */
    public LabCanvas(double width, double height) {
        super(width, height);
    }

    /**
     * Draw the canvas and the objects on it
     * @param game The game object used to play the game
     */
    public void drawGame(Game game) {
        this.game = game;
        resetSize(game);
        gc = this.getGraphicsContext2D();
        drawBackground(gc);
        drawBall(gc, game.getBall());
        drawRacket(gc, game.getPlayer1().getRacket());
        drawRacket(gc, game.getPlayer2().getRacket());
        drawTitle(gc, game.getPlayer1());
        drawTitle(gc, game.getPlayer2());
    }

    /**
     * Draw the ball on the canvas
     * @param gc The graphics context object being used
     * @param ball The ball object used inside the game
     */
    private void drawBall(GraphicsContext gc, Ball ball) {
        gc.drawImage(ball.getCage(),ball.getPosX(),ball.getPosY(),ball.getRadius(),ball.getRadius());
    }

    /**
     * Draw a racket on the canvas
     * @param gc The graphics context object being used
     * @param racket The racket object used by one of the players inside the game
     */
    private void drawRacket(GraphicsContext gc, Racket racket) {
        gc.setFill(racket.getColor());
        gc.fillRect(racket.getPosX(), racket.getPosY(), racket.getThickness(), racket.getSize());
    }

    /**
     * Resets the size of the canvas to the size of the game window width and height
     * @param game The game object used to play the game
     */
    private void resetSize(Game game) {
        this.setWidth(game.getDimensionX());
        this.setHeight(game.getDimensionY());
    }

    /**
     * Draw the background of the game/ draw the canvas
     * @param gc The graphics context object being used
     */
    private void drawBackground(GraphicsContext gc) {
        gc.setFill(Color.BLACK);
        gc.clearRect(0, 0, this.getWidth(), this.getHeight());
        gc.fillRect(0, 0, this.getWidth(), this.getHeight());
    }

    /**
     * Draw the name of the player on screen
     * @param gc The graphics context object being used
     * @param player The player object for which to draw the name on screen
     */
    private void drawTitle(GraphicsContext gc, Player player) {
        gc.setFill(Color.PINK);
        gc.setStroke(Color.PINK);
        gc.setFont(new Font(30));
        String nameandscore = player.getName()+ " " + player.getScore();
        gc.strokeText(nameandscore, player.getNamex(), player.getNamey());
    }

    /**
     * Draw who has scored on screen
     * @param player The player object who scored a goal
     */
    public void drawGoal(Player player){
        gc.setFill(Color.GREEN);
        gc.setStroke(Color.GREEN);
        gc.setFont(new Font(30));
        String score = player.getName()+ " "+"has scored!";
        gc.strokeText(score,game.getDimensionX()/4,game.getDimensionY()/2);
    }

    /**
     * Draw who has won the game
     * @param player The player object who has won the game
     */
    public void drawWin(Player player){
        gc.setFill(Color.GREEN);
        gc.setStroke(Color.GREEN);
        gc.setFont(new Font(30));
        String score = player.getName()+ " "+"has WON!";
        gc.strokeText(score,game.getDimensionX()/4,game.getDimensionY()/2);
    }

}

