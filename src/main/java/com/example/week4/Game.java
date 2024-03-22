package com.example.week4;



public class Game implements Resizable {

    private double dimensionX;


    private double dimensionY;

    private Player player1;


    private Player player2;
    private Ball ball;


    private int gameendingscr;



    private int gamedifficulty;

    /**
     * Creates a game object with 2 new players and a ball, sets the default window size
     */
    public Game(){
        dimensionX = 600;
        dimensionY = 450;
        player1 = new Player(dimensionY);
        player2 = new Player(dimensionX,dimensionY);
        ball = new Ball();
        gameendingscr = 4;
        gamedifficulty = 2;
    }

    //Getters

    /**
     * Gets the player 1 from the game
     * @return Return the player 1 object from the game
     */
    public Player getPlayer1() {
        return player1;
    }

    /**
     * Gets the player 1 from the game
     * @return Return the player 2 object from the game
     */
    public Player getPlayer2() {
        return player2;
    }

    /**
     * Get the ball that is currently being used by the game
     * @return Return the ball object that is currently being used by the game
     */
    public Ball getBall() {
        return ball;
    }

    /**
     * Get the current window width
     * @return Return the current window width
     */
    public double getDimensionX() {
        return dimensionX;
    }

    /**
     * Get the current window height
     * @return Return the current window height
     */
    public double getDimensionY() {
        return dimensionY;
    }

    /**
     * Get the game ending score from the game
     * @return Return the game ending score
     */
    public int getGameendingscr() {
        return gameendingscr;
    }

    /**
     * Get the game difficult from the game
     * @return Return the game difficulty from the game
     */
    public int getGamedifficulty() {
        return gamedifficulty;
    }




    //Setters
//    public void setPlayer1(Player player1) {
//        this.player1 = player1;
//    }
//
//    public void setPlayer2(Player player2) {
//        this.player2 = player2;
//    }
//
//    public void setBall(Ball ball) {
//        this.ball = ball;
//    }

    /**
     * Set the width of the game window
     * @param dimensionX New window width to be applied
     */
    public void setDimensionX(double dimensionX) {
        this.dimensionX = dimensionX;
    }

    /**
     * Set the height of the game window
     * @param dimensionY New window height to be applied
     */
    public void setDimensionY(double dimensionY) {
        this.dimensionY = dimensionY;
    }


    /**
     * Increment the game ending score by one
     */
    public void setGameendingscrUp() {
        this.gameendingscr++;
    }

    /**
     * Decrement the game ending score by one
     */
    public void setGameendingscrDown() {
        this.gameendingscr--;
    }

    /**
     * Increment the game difficulty by one
     */
    public void setGamedifficultyUp() {
        this.gamedifficulty++;
    }

    /**
     * Decrement the game difficulty by one
     */
    public void setGamedifficultyDown() {
        this.gamedifficulty--;
    }


    /**
     * Resize the Y dimension of the game objects whenever the width is increased by the user
     * @param factor The multiplier by which the game window has increased/decreased from previous value, this is used to then increase the size of game objects
     */
    @Override
    public void resizeX(double factor) {
        player1.getRacket().resizeX(factor);
        player2.getRacket().resizeX(factor);
        ball.resizeX(factor);
        player1.resizeX(factor);
        player2.resizeX(factor);
    }

    /**
     * Resize the Y dimension of the game objects whenever the height is increased by the user
     * @param factor The multiplier by which the game window has increased/decreased from previous value, this is used to then increase the size of game objects
     */
    @Override
    public void resizeY(double factor) {
        player1.getRacket().resizeY(factor);
        player2.getRacket().resizeY(factor);
        ball.resizeY(factor);
        player1.resizeY(factor);
        player2.resizeY(factor);
    }
}