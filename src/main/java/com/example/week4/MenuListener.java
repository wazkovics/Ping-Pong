package com.example.week4;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.Optional;

public class MenuListener {
    private Game game;

    private LabController labController;

    private LabCanvas canvas;

    private GameMenu menu;

    private Nameandscores nameandscores;
    public MenuListener(Game game,LabController controller, LabCanvas labCanvas, Nameandscores nmsandscr)
    {
        this.game=game;
        this.labController = controller;
        this.canvas = labCanvas;
        this.nameandscores = nmsandscr;
    }
    public void setExit() {
        System.out.println("EXIT");
        Platform.exit();
    }
    public void setAbout() {
        System.out.println("ABOUT");
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Super Ping pong");
        alert.setHeaderText("Made in Cork");
        alert.setContentText("All rights resereved");
        alert.showAndWait().ifPresent((btnType) -> {
        });
    }

    public void setAllSettings(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Settings");
        alert.setHeaderText("Game settings");

        //players
        Label player1 = new Label("Player 1 name");
        TextField player1name = new TextField("Player 1");
        player1name.setMaxWidth(150);
        Label player2 = new Label("Player 2 name");
        TextField player2name = new TextField("Player 2");
        player2name.setMaxWidth(150);
        VBox player = new VBox(player1,player1name,player2,player2name);

        //ball
        Label ballspeedlabel = new Label("Ball Speed ");
        TextField ballspeedin = new TextField(String.valueOf(labController.getGame().getBall().getSpeed()));
        ballspeedin.setEditable(false);
        Button ballspeedup = new Button("Increase");
        Button ballspeeddown = new Button("Decrease");
        HBox ballspeedHBOX = new HBox(ballspeedlabel,ballspeedin,ballspeedup,ballspeeddown);

        ballspeedup.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(labController.getGame().getBall().getSpeed() < 5){
                    labController.getGame().getBall().setSpeedup();
                    ballspeedin.setText(String.valueOf(labController.getGame().getBall().getSpeed()));
                }
            }
        });

        ballspeeddown.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(labController.getGame().getBall().getSpeed() > 1){
                    labController.getGame().getBall().setSpeedDown();
                    ballspeedin.setText(String.valueOf(labController.getGame().getBall().getSpeed()));
                }
            }
        });

        //paddle
        Label paddlewidthlabel = new Label("Paddle width");
        Slider paddlewidth = new Slider(15,45,20);
        paddlewidth.setShowTickLabels(true);
        paddlewidth.setShowTickMarks(true);
        paddlewidth.setMajorTickUnit(5);
        paddlewidth.setSnapToTicks(true);
        paddlewidth.setBlockIncrement(5);

        Label paddlelengthlabel = new Label("Paddle length");
        Slider paddlelength = new Slider(100,200,125);
        paddlelength.setShowTickLabels(true);
        paddlelength.setShowTickMarks(true);
        paddlelength.setMajorTickUnit(25);
        paddlelength.setSnapToTicks(true);
        paddlelength.setBlockIncrement(25);
        paddlelength.setMinorTickCount(5);

        VBox paddle = new VBox(paddlewidthlabel,paddlewidth,paddlelengthlabel,paddlelength);

        //game ending score
        Label gameendingscrlabel = new Label("Game ending score");
        TextField gameendingscr = new TextField(String.valueOf(labController.getGame().getGameendingscr()));
        gameendingscr.setEditable(false);
        Button scrup = new Button("Increase");
        Button scrdown = new Button("Decrease");
        HBox gameenedingHBOX = new HBox(gameendingscrlabel,gameendingscr,scrup,scrdown);

        scrup.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(labController.getGame().getGameendingscr() < 6){
                    labController.getGame().setGameendingscrUp();
                    gameendingscr.setText(String.valueOf(labController.getGame().getGameendingscr()));
                }
            }
        });

        scrdown.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(labController.getGame().getGameendingscr() > 1){
                    labController.getGame().setGameendingscrDown();
                    gameendingscr.setText(String.valueOf(labController.getGame().getGameendingscr()));
                }
            }
        });

        //game difficulty

        Label difficultylabel = new Label("Difficulty");
        TextField difficultyfield = new TextField(String.valueOf(labController.getGame().getGamedifficulty()));
        difficultyfield.setEditable(false);
        Button difficultyup = new Button("Increase");
        Button difficultydown = new Button("Decrease");
        HBox difficultyHBOX = new HBox(difficultylabel,difficultyfield,difficultyup,difficultydown);

        difficultyup.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(labController.getGame().getGamedifficulty() < 3){
                    labController.getGame().setGamedifficultyUp();
                    difficultyfield.setText(String.valueOf(labController.getGame().getGamedifficulty()));
                }
            }
        });

        difficultydown.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(labController.getGame().getGamedifficulty() > 1){
                    labController.getGame().setGamedifficultyDown();
                    difficultyfield.setText(String.valueOf(labController.getGame().getGamedifficulty()));
                }
            }
        });


        VBox root = new VBox(player,ballspeedHBOX,paddle,gameenedingHBOX,difficultyHBOX);

        alert.getDialogPane().setContent(root);

        //alert.showAndWait();

        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                labController.getGame().getPlayer1().setName(String.valueOf(player1name));
                labController.getGame().getPlayer1().setName(String.valueOf(player2name));
                labController.getGame().getPlayer1().getRacket().setSize(paddlelength.getValue());
                labController.getGame().getPlayer2().getRacket().setSize(paddlelength.getValue());
                labController.getGame().getPlayer1().getRacket().setThickness(paddlewidth.getValue());
                labController.getGame().getPlayer2().getRacket().setThickness(paddlewidth.getValue());
                nameandscores.setPlayer1name(player1name.getText());
                nameandscores.setPlayer2name(player2name.getText());
                canvas.drawGame(labController.getGame());

            }
        });
    }


}