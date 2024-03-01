package com.example.week4;

import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class Nameandscores {

    private Game game;
    private String player1name;
    private String player2name;
    private int player1score;
    private int player2score;

    public Nameandscores(Game game){
        this.game = game;
        player1name = game.getPlayer1().getName();
        player2name = game.getPlayer2().getName();
        player1score = game.getPlayer1().getScore();
        player2score = game.getPlayer2().getScore();
    }

    public void player1scored(){
        game.getPlayer1().incrementScore();
        player1score = game.getPlayer1().getScore();
    }

    public void player2scored(){
        game.getPlayer2().incrementScore();
        player1score = game.getPlayer2().getScore();
    }

    public void gameended(){
        game.getPlayer1().resetScore();
        game.getPlayer2().resetScore();
        player1score = game.getPlayer1().getScore();
        player2score = game.getPlayer2().getScore();
    }

    public void playerrenamed(){
        player1name = game.getPlayer1().getName();
        player2name = game.getPlayer2().getName();
    }

//    public HBox scoresandnames = new HBox();
//
//
//    private TextField player1name = new TextField();
//
//
//    private TextField player1score = new TextField();
//
//
//
//    private TextField player2name = new TextField();
//
//
//
//    private TextField player2score = new TextField();
//
//    public Nameandscores(){
//        player1name.setText("Player 1");
//        player1score.setText("0");
//        player2name.setText("Player 2");
//        player2score.setText("0");
//        player1name.setEditable(false);
//        player1score.setEditable(false);
//        player2name.setEditable(false);
//        player1score.setEditable(false);
//
//        scoresandnames.getChildren().addAll(player1name,player1score,player2name,player2score);
//    }

    //Getters


    //Setters
//    public void setPlayer1name(String player1name) {
//        this.player1name.setText(player1name);
//    }
//
//    public void setPlayer1score(int player1score) {
//        this.player1score.setText(String.valueOf(player1score));
//    }
//
//    public void setPlayer2name(String player2name) {
//        this.player2name.setText(player2name);
//    }
//
//    public void setPlayer2score(int player2score) {
//        this.player2score.setText(String.valueOf(player2score));
//    }
}
