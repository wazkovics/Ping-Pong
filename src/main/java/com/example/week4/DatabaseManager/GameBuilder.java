package com.example.week4.DatabaseManager;

import com.example.week4.Game;

public class GameBuilder {
    private String player1Name;
    private String player2Name;
    private int player1Score;
    private int player2Score;
    private String name;
    private int target;
    public Game build() {
//        Game game = new Game();
//        Player player1= new Player();
//        Player player2= new Player();
//        game.getPlayer1().setName(player1Name);
//        game.getPlayer2().setName(player2Name);
//        game.getPlayer1().setScore(player1Score);
//        game.getPlayer2().setScore(player2Score);
//        game.setGameendingscr(target);
//        game.setName(name);
//        game.setPlayer1(player1);
//        game.setPlayer2(player2);
//        return game;
        return null;
    }
    public GameBuilder withName(String name) {
        this.name=name;
        return this;
    }
    public GameBuilder withPlayer1Name(String p1Name) {
        this.player1Name=p1Name;
        return this;
    }
    public GameBuilder withPlayer2Name(String p2Name) {
        this.player2Name=p2Name;
        return this;
    }
    public GameBuilder withPlayer1Score(int score) {
        this.player1Score=score;
        return this;
    }
    public GameBuilder withPlayer2Score(int score) {
        this.player2Score=score;
        return this;
    }
    public GameBuilder withTarget(int t) {
        this.target=t;
        return this;
    }
}
