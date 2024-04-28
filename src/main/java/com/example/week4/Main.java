package com.example.week4;

import com.example.week4.Listener.BallManager;
import com.example.week4.Listener.KeyboardListener;
import com.example.week4.Listener.LabController;
import com.example.week4.Listener.MenuListener;
import com.example.week4.Tests.Heap;
import com.example.week4.Tests.Stack;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class Main extends Application {


    private LabCanvas canvas;

    private final LabController labController = new LabController(new Game());
    @Override
    public void start(Stage primaryStage) {



        BorderPane top = new BorderPane();
        canvas = new LabCanvas(600,450);

        MenuListener menuListener = new MenuListener(labController.getGame(),labController,canvas);

        BallManager ballManager= new BallManager(labController.getGame(), canvas,labController);
        Thread thread = new Thread(ballManager);
        thread.start();
        Thread.yield();

        GameMenu menu = new GameMenu(menuListener);

        top.setTop(menu.menubar);
        top.setCenter(canvas);

        canvas.drawGame(labController.getGame());

        KeyboardListener keyboardListener = new KeyboardListener( labController.getGame(), canvas, menuListener);
        canvas.setOnKeyPressed(keyboardListener);
        canvas.setOnKeyTyped(keyboardListener);
        canvas.setFocusTraversable(true);
        //canvas = new LabCanvas(600,450);


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
//        launch();
        Heap.heapstest();
//        Stack.stacktest();
    }


}