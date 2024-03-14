package com.example.week4;



public class LabController {

    private Game game;

    /**
     * Create a new labcontroller object
     * @param game1 A current game object which is used inside this Ping Pong game
     */
    public LabController (Game game1){
        game = game1;
    }


    //Constructor and Getters/Setters here

    //Getter

    /**
     * Get the game object used within the game.
     * @return
     */
    public Game getGame(){
        return game;
    }


    //Setter

//    public void setGame(Game game) {
//        this.game = game;
//    }


}


