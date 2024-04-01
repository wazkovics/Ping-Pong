package com.example.week4;


import java.io.*;

public class Game implements Resizable, Serializable {

    private double dimensionX;


    private double dimensionY;

    private Player player1;


    private Player player2;
    private Ball ball;


    private int gameendingscr;



    private int gamedifficulty;

    private GameState gameState;


    /**
     * Save the game to a file
     */
    public void saveGame(){
        gameState = GameState.getInstance();
        //gameState.setBallradius(ball.getRadius());
        //gameState.setPaddle1X(player1.getRacket().getPosX());
        //gameState.setPaddle1Y(player1.getRacket().getPosY());
        gameState.setPaddle1length(player1.getRacket().getSize());
        gameState.setPaddle1width(player1.getRacket().getThickness());
        //gameState.setPaddle2X(player2.getRacket().getPosX());
        //gameState.setPaddle2Y(player2.getRacket().getPosY());
        gameState.setPaddle2length(player2.getRacket().getSize());
        gameState.setPaddle2width(player2.getRacket().getThickness());
        gameState.setScorePlayer1(player1.getScore());
        gameState.setScorePlayer2(player2.getScore());
        gameState.setEndgamescore(gameendingscr);
        gameState.setGamedifficulty(gamedifficulty);

        try {
            FileOutputStream fileOut = new FileOutputStream("Saved_game.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(gameState);
            out.close();
            fileOut.close();
            System.out.println("Game state saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadGame(){
        try {
            FileInputStream fileIn = new FileInputStream("Saved_game.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            gameState = (GameState) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Game state loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        player1.getRacket().setSize(gameState.getPaddle1length());
        player1.getRacket().setThickness(gameState.getPaddle1width());
        player2.getRacket().setSize(gameState.getPaddle2length());
        player2.getRacket().setThickness(gameState.getPaddle2width());
        player1.setScore(gameState.getScorePlayer1());
        player2.setScore(gameState.getScorePlayer2());
        gameendingscr = gameState.getEndgamescore();
        gamedifficulty = gameState.getGamedifficulty();
        ball.resetBall();

    }

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