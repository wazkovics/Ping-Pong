package com.example.week4;

public class Player implements Resizable {

    private String name;

    private Racket racket;

    private double namex;
    private double namey;

    private int score;
    public Player(){
        racket = new Racket();
    }

    public Player (double width,double height){
        racket = new Racket(width,height);
        name = "Player 2";
        score = 0;
        namex = width/2;
        namey = 30;
    }

    public Player(double height){
        racket = new Racket(height);
        name = "Player 1";
        score = 0;
        namey = 30;
    }
    public Racket getRacket() {
        return this.racket;
    }

    public String getName(){
        return this.name;
    }

    public int getScore(){
        return score;
    }

    public double getNamex(){
        return namex;
    }

    public double getNamey() {
        return namey;
    }

    public void incrementScore(){
        score +=1;
    }
    public void resetScore(){
        score = 0;
    }


    public void setName(String name) {
        this.name = name;
    }


    @Override
    public void resizeX(double factor) {
        namex = namex*factor;
    }

    @Override
    public void resizeY(double factor) {
        namey = namey*factor;
    }
}
