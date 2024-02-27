package com.example.week4;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class Main extends Application {


    private final LabCanvas canvas = new LabCanvas(600,450);

    private final LabController labController = new LabController();
    @Override
    public void start(Stage primaryStage) {

        BorderPane top = new BorderPane();

        Nameandscores namesandscr = new Nameandscores();

        MenuListener menuListener = new MenuListener(labController.getGame(),labController,canvas,namesandscr);

        GameMenu menu = new GameMenu(menuListener);


        VBox menuandplayers = new VBox(menu.menubar,namesandscr.scoresandnames);

        top.setTop(menuandplayers);
        top.setCenter(canvas);

        canvas.drawGame(labController.getGame());


        Scene screen = new Scene(top);
        primaryStage.setScene(screen);

        menu.menubar.prefWidthProperty().bind(primaryStage.widthProperty());
        primaryStage.setTitle("Ping Pong");
        primaryStage.show();



        primaryStage.widthProperty().addListener(observable -> {
            double factor = primaryStage.getWidth() / labController.getGame().getDimensionX();
//            System.out.println("Width changed " + primaryStage.getWidth() + " " + factor);
            labController.getGame().setDimensionX(primaryStage.getWidth());
            labController.getGame().resizeX(factor);
            canvas.drawGame(labController.getGame());
        });

        primaryStage.heightProperty().addListener(observable -> {
            double factor = primaryStage.getHeight() / labController.getGame().getDimensionY();
//            System.out.println("Height changed " + primaryStage.getHeight() + " " + factor);
            labController.getGame().setDimensionY(primaryStage.getHeight());
            labController.getGame().resizeY(factor);
            canvas.drawGame(labController.getGame());

        });
    }


    public static void main(String[] args) {
        launch();
    }


}