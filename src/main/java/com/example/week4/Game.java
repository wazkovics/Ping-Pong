package com.example.week4;



public class Game implements Resizable {

    private double dimensionX;


    private double dimensionY;

    private Player player1;


    private Player player2;
    private Ball ball;



    private int gameendingscr;



    private int gamedifficulty;

    public Game(){
        dimensionX = 600;
        dimensionY = 450;
        player1 = new Player(dimensionY);
        player2 = new Player(dimensionX,dimensionY);
        ball = new Ball();
        gameendingscr = 2;
        gamedifficulty = 1;
    }

    //Getters
    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public Ball getBall() {
        return ball;
    }

    public double getDimensionX() {
        return dimensionX;
    }

    public double getDimensionY() {
        return dimensionY;
    }

    public int getGameendingscr() {
        return gameendingscr;
    }

    public int getGamedifficulty() {
        return gamedifficulty;
    }



    //Setters
    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }

    public void setDimensionX(double dimensionX) {
        this.dimensionX = dimensionX;
    }

    public void setDimensionY(double dimensionY) {
        this.dimensionY = dimensionY;
    }



    public void setGameendingscrUp() {
        this.gameendingscr++;
    }
    public void setGameendingscrDown() {
        this.gameendingscr--;
    }

    public void setGamedifficultyUp() {
        this.gamedifficulty++;
    }

    public void setGamedifficultyDown() {
        this.gamedifficulty--;
    }



    @Override
    public void resizeX(double factor) {
        player1.getRacket().resizeX(factor);
        player2.getRacket().resizeX(factor);
        ball.resizeX(factor);
        player1.resizeX(factor);
        player2.resizeX(factor);
    }

    @Override
    public void resizeY(double factor) {
        player1.getRacket().resizeY(factor);
        player2.getRacket().resizeY(factor);
        ball.resizeY(factor);
        player1.resizeY(factor);
        player2.resizeY(factor);
    }
}