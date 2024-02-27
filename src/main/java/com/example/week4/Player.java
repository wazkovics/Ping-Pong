package com.example.week4;

public class Player {

    private String name;

    private Racket racket;
    public Player(){
        racket = new Racket();
    }

    public Player (double width,double height){
        racket = new Racket(width,height);
        name = "Player 2";
    }

    public Player(double height){
        racket = new Racket(height);
        name = "Player 1";
    }
    public Racket getRacket() {
        return this.racket;
    }

    public String getName(){
        return this.name;
    }


    public void setName(String name) {
        this.name = name;
    }


}
