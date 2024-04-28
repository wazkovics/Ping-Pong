package com.example.week4.Listener;


import com.example.week4.Ball;
import com.example.week4.Game;
import com.example.week4.GameState;

import java.io.*;

public class LabController implements Serializable {

    private Game game;
    private Ball ball;

    private GameState gameState;

    /**
     * Create a new labcontroller object
     * @param game1 A current game object which is used inside this Ping Pong game
     */
    public LabController (Game game1){
        game = game1;
        ball = game.getBall();
    }


    //Constructor and Getters/Setters here

    //Getter

    /**
     * Get the game object used within the game.
     * @return The current game object being used
     */
    public Game getGame(){
        return game;
    }


    //Setter

//    public void setGame(Game game) {
//        this.game = game;
//    }

    /**
     * Checks if the ball hit player1's racket
     * @return Returns true if the ball hit the player's racket
     */
    public boolean player1bounce(){
        return (game.getPlayer1().getRacket().getPosX() + game.getPlayer1().getRacket().getThickness() >= ball.getPosX()) && game.getPlayer1().getRacket().getPosY() <= ball.getPosY() && ball.getPosY() <= game.getPlayer1().getRacket().getPosY() + game.getPlayer1().getRacket().getSize();
    }

    /**
     * Checks if the ball hit player2's racket
     * @return Return true if the ball hit the player's racket
     */
    public boolean player2bounce() {
        return (game.getPlayer2().getRacket().getPosX() <= ball.getPosX()+ ball.getRadius()/2)&&game.getPlayer2().getRacket().getPosY()<= ball.getPosY()&& ball.getPosY() <=game.getPlayer2().getRacket().getPosY()+game.getPlayer2().getRacket().getSize();
    }

    /**
     * Save the game to a file
     */
    public void saveGame(){
        gameState = GameState.getInstance();
        gameState.setPaddle1length(game.getPlayer1().getRacket().getSize());
        gameState.setPaddle1width(game.getPlayer1().getRacket().getThickness());
        gameState.setPaddle2length(game.getPlayer2().getRacket().getSize());
        gameState.setPaddle2width(game.getPlayer2().getRacket().getThickness());
        gameState.setScorePlayer1(game.getPlayer1().getScore());
        gameState.setScorePlayer2(game.getPlayer2().getScore());
        gameState.setEndgamescore(game.getGameendingscr());
        gameState.setGamedifficulty(game.getGamedifficulty());

        try {
            FileOutputStream fileOut = new FileOutputStream("Saved_game.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(gameState);
            out.close();
            fileOut.close();
            System.out.println("Game state saved successfully.");
        } catch (IOException e) {
//            e.printStackTrace();
        }
    }

    /**
     * Load the game from a save file
     */
    public void loadGame(){
        try {
            FileInputStream fileIn = new FileInputStream("Saved_game.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            gameState = (GameState) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Game state loaded successfully.");
        } catch (IOException | ClassNotFoundException | NullPointerException e) {
            //e.printStackTrace();
            System.out.println("The save file couldn't be found, this is because it has not been saved before.\nSave first then try reloading again.");
        }

        game.getPlayer1().getRacket().setSize(gameState.getPaddle1length());
        game.getPlayer1().getRacket().setThickness(gameState.getPaddle1width());
        game.getPlayer2().getRacket().setSize(gameState.getPaddle2length());
        game.getPlayer2().getRacket().setThickness(gameState.getPaddle2width());
        game.getPlayer1().setScore(gameState.getScorePlayer1());
        game.getPlayer2().setScore(gameState.getScorePlayer2());
        game.setGameendingscr(gameState.getEndgamescore());
        game.setGamedifficulty(gameState.getGamedifficulty());
        ball.resetBall();

    }


}


