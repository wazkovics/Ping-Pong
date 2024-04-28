package com.example.week4;

import java.io.Serializable;

public class GameState implements Serializable {

    private double paddle1X;
    private double paddle1Y;

    private double paddle1width;

    private double paddle1length;

    private double paddle2X;
    private double paddle2Y;

    private double paddle2width;

    private double paddle2length;
    private double ballX;
    private double ballY;

    private double ballradius;
    private int scorePlayer1;
    private int scorePlayer2;

    private int endgamescore;



    private int gamedifficulty;

    private static GameState gameState = new GameState();

    private GameState(){

    }

    public static GameState getInstance(){
        return gameState;
    }

    public GameState(int paddle1X ,int paddle1Y, int paddle2X, int paddle2Y, int ballX, int ballY, int scorePlayer1, int scorePlayer2) {
        this.paddle1Y = paddle1Y;
        this.paddle2Y = paddle2Y;
        this.ballX = ballX;
        this.ballY = ballY;
        this.scorePlayer1 = scorePlayer1;
        this.scorePlayer2 = scorePlayer2;
    }



    //Getters
    /**
     * Get the X-coordinate of Paddle 1.
     *
     * @return The X-coordinate of Paddle 1.
     */
    public double getPaddle1X() {
        return paddle1X;
    }

    /**
     * Get the Y-coordinate of Paddle 1.
     *
     * @return The Y-coordinate of Paddle 1.
     */
    public double getPaddle1Y() {
        return paddle1Y;
    }

    /**
     * Get the width of Paddle 1.
     *
     * @return The width of Paddle 1.
     */
    public double getPaddle1width() {
        return paddle1width;
    }

    /**
     * Get the length of Paddle 1.
     *
     * @return The length of Paddle 1.
     */
    public double getPaddle1length() {
        return paddle1length;
    }

    /**
     * Get the X-coordinate of Paddle 2.
     *
     * @return The X-coordinate of Paddle 2.
     */
    public double getPaddle2X() {
        return paddle2X;
    }

    /**
     * Get the Y-coordinate of Paddle 2.
     *
     * @return The Y-coordinate of Paddle 2.
     */
    public double getPaddle2Y() {
        return paddle2Y;
    }

    /**
     * Get the width of Paddle 2.
     *
     * @return The width of Paddle 2.
     */
    public double getPaddle2width() {
        return paddle2width;
    }

    /**
     * Get the length of Paddle 2.
     *
     * @return The length of Paddle 2.
     */
    public double getPaddle2length() {
        return paddle2length;
    }

    /**
     * Get the X-coordinate of the Ball.
     *
     * @return The X-coordinate of the Ball.
     */
    public double getBallX() {
        return ballX;
    }

    /**
     * Get the Y-coordinate of the Ball.
     *
     * @return The Y-coordinate of the Ball.
     */
    public double getBallY() {
        return ballY;
    }

    /**
     * Get the radius of the Ball.
     *
     * @return The radius of the Ball.
     */
    public double getBallradius() {
        return ballradius;
    }

    /**
     * Get the score of Player 1.
     *
     * @return The score of Player 1.
     */
    public int getScorePlayer1() {
        return scorePlayer1;
    }

    /**
     * Get the score of Player 2.
     *
     * @return The score of Player 2.
     */
    public int getScorePlayer2() {
        return scorePlayer2;
    }

    /**
     * Get the score needed to end the game.
     *
     * @return The score needed to end the game.
     */
    public int getEndgamescore() {
        return endgamescore;
    }

    /**
     * Get the game difficulty of the game
     *
     * @return The game difficulty of the game
     */
    public int getGamedifficulty() {
        return gamedifficulty;
    }




    //Setters
    /**
     * Set the X-coordinate of Paddle 1.
     *
     * @param paddle1X The X-coordinate of Paddle 1.
     */
    public void setPaddle1X(double paddle1X) {
        this.paddle1X = paddle1X;
    }

    /**
     * Set the Y-coordinate of Paddle 1.
     *
     * @param paddle1Y The Y-coordinate of Paddle 1.
     */
    public void setPaddle1Y(double paddle1Y) {
        this.paddle1Y = paddle1Y;
    }

    /**
     * Set the width of Paddle 1.
     *
     * @param paddle1width The width of Paddle 1.
     */
    public void setPaddle1width(double paddle1width) {
        this.paddle1width = paddle1width;
    }

    /**
     * Set the length of Paddle 1.
     *
     * @param paddle1length The length of Paddle 1.
     */
    public void setPaddle1length(double paddle1length) {
        this.paddle1length = paddle1length;
    }

    /**
     * Set the X-coordinate of Paddle 2.
     *
     * @param paddle2X The X-coordinate of Paddle 2.
     */
    public void setPaddle2X(double paddle2X) {
        this.paddle2X = paddle2X;
    }

    /**
     * Set the Y-coordinate of Paddle 2.
     *
     * @param paddle2Y The Y-coordinate of Paddle 2.
     */
    public void setPaddle2Y(double paddle2Y) {
        this.paddle2Y = paddle2Y;
    }

    /**
     * Set the width of Paddle 2.
     *
     * @param paddle2width The width of Paddle 2.
     */
    public void setPaddle2width(double paddle2width) {
        this.paddle2width = paddle2width;
    }

    /**
     * Set the length of Paddle 2.
     *
     * @param paddle2length The length of Paddle 2.
     */
    public void setPaddle2length(double paddle2length) {
        this.paddle2length = paddle2length;
    }

    /**
     * Set the X-coordinate of the Ball.
     *
     * @param ballX The X-coordinate of the Ball.
     */
    public void setBallX(double ballX) {
        this.ballX = ballX;
    }

    /**
     * Set the Y-coordinate of the Ball.
     *
     * @param ballY The Y-coordinate of the Ball.
     */
    public void setBallY(double ballY) {
        this.ballY = ballY;
    }

    /**
     * Set the radius of the Ball.
     *
     * @param ballradius The radius of the Ball.
     */
    public void setBallradius(double ballradius) {
        this.ballradius = ballradius;
    }

    /**
     * Set the score of Player 1.
     *
     * @param scorePlayer1 The score of Player 1.
     */
    public void setScorePlayer1(int scorePlayer1) {
        this.scorePlayer1 = scorePlayer1;
    }

    /**
     * Set the score of Player 2.
     *
     * @param scorePlayer2 The score of Player 2.
     */
    public void setScorePlayer2(int scorePlayer2) {
        this.scorePlayer2 = scorePlayer2;
    }

    /**
     * Set the score needed to end the game.
     *
     * @param endgamescore The score needed to end the game.
     */
    public void setEndgamescore(int endgamescore) {
        this.endgamescore = endgamescore;
    }

    /**
     * Set the game difficulty of the game
     *
     * @param gamedifficulty The game difficulty of the game
     */
    public void setGamedifficulty(int gamedifficulty) {
        this.gamedifficulty = gamedifficulty;
    }


}

// Getters and setters for the variables
//    public double getPaddle1Y() {
//        return paddle1Y;
//    }
//
//    public void setPaddle1Y(double paddle1Y) {
//        this.paddle1Y = paddle1Y;
//    }
//
//    public double getPaddle2Y() {
//        return paddle2Y;
//    }
//
//    public void setPaddle2Y(double paddle2Y) {
//        this.paddle2Y = paddle2Y;
//    }
//
//    public double getBallX() {
//        return ballX;
//    }
//
//    public void setBallX(double ballX) {
//        this.ballX = ballX;
//    }
//
//    public double getBallY() {
//        return ballY;
//    }
//
//    public void setBallY(double ballY) {
//        this.ballY = ballY;
//    }
//
//
//    public int getScorePlayer1() {
//        return scorePlayer1;
//    }
//
//    public void setScorePlayer1(int scorePlayer1) {
//        this.scorePlayer1 = scorePlayer1;
//    }
//
//    public int getScorePlayer2() {
//        return scorePlayer2;
//    }
//
//    public void setScorePlayer2(int scorePlayer2) {
//        this.scorePlayer2 = scorePlayer2;
//    }

