package com.example.week4;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.paint.Color;


import java.io.IOException;


public class Main extends Application {


    private final LabCanvas can = new LabCanvas();
    @Override
    public void start(Stage stage) throws Exception {

        BorderPane top = new BorderPane();

        MenuBar menubar = new MenuBar();
        Menu file = new Menu("File");
        MenuItem filemenuitem1 = new MenuItem("New Game");
        MenuItem filemenuitem2 = new MenuItem("Exit");
        Menu edit = new Menu("Edit");
        Menu help = new Menu("Help");

        file.getItems().addAll(filemenuitem1,filemenuitem2);
        menubar.getMenus().addAll(file,edit,help);

        top.setTop(menubar);
        Group root = new Group(can);

        root.getChildren().addAll(top);

        Scene screen = new Scene(root,300,300,Color.BLACK);
        stage.setScene(screen);

        menubar.prefWidthProperty().bind(stage.widthProperty());
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}