package com.example.week4;

public class Player implements Resizable {

    private String name;

    private Racket racket;

    private double namex;
    private double namey;

    private int score;


//    public Player(){
//        racket = new Racket();
//    }

    /**
     * Creates a new player object with a new racket object
     * @param width Width of the window
     * @param height Height of the window
     */
    public Player (double width,double height){
        racket = new Racket(width,height);
        name = "Player 2";
        score = 0;
        namex = width/2;
        namey = 30;
    }

    /**
     * Creates a new player object with a new racket object
     * @param height Height of the window
     */
    public Player(double height){
        racket = new Racket(height);
        name = "Player 1";
        score = 0;
        namey = 30;
    }

    /**
     * Get the racket of the player
     * @return Return the racket object of the player
     */
    public Racket getRacket() {
        return this.racket;
    }

    /**
     * Get the name of the player
     * @return Return the name of the player
     */
    public String getName(){
        return this.name;
    }

    /**
     * Get the score of the player
     * @return Return the score of the player
     */
    public int getScore(){
        return score;
    }

    /**
     * Get the X position of the name which is displayed on the canvas
     * @return Return the X position  of the name
     */
    public double getNamex(){
        return namex;
    }

    /**
     * Get the Y position of the name which is displayed on the canvas
     * @return Return the Y position of the name
     */
    public double getNamey() {
        return namey;
    }

    /**
     * Increment the player score by 1
     */
    public void incrementScore(){
        score +=1;
    }

    /**
     * Reset the score to 0
     */
    public void resetScore(){
        score = 0;
    }

    /**
     * Set the name of the player
     * @param name The name to be set for the player
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Dynamically move the name in the X axis to fit with the window width
     * @param factor The number by which increase or decrease the X location of the name of the player on canvas
     */
    @Override
    public void resizeX(double factor) {
        namex = namex*factor;
    }

    /**
     * Dynamically move the name in the Y axis to fit with the window height
     * @param factor The number by which increase or decrease the Y location of the name of the player on canvas
     */
    @Override
    public void resizeY(double factor) {
        namey = namey*factor;
    }
}
