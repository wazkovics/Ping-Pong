package com.example.week4.Listener;


import com.example.week4.Ball;
import com.example.week4.Game;

public class LabController {

    private Game game;
    private Ball ball;

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
}


