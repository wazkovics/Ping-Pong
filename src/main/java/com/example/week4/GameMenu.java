package com.example.week4;



import javafx.scene.control.*;
import javafx.scene.layout.HBox;


public class GameMenu {
    public MenuBar menubar = new MenuBar();
    private Menu file = new Menu("File");
    private MenuItem filemenuitem1 = new MenuItem("New Game");
    private MenuItem filemenuitem2 = new MenuItem("Exit");
    private Menu settings = new Menu("Settings");

    private MenuItem allsettings = new MenuItem("Open Settings");
    private Menu help = new Menu("Help");
    private Menu about = new Menu("About");

    private MenuListener menuListener;


    public GameMenu(MenuListener listener){
        this.menuListener = listener;

        file.getItems().addAll(filemenuitem1,filemenuitem2);
        settings.getItems().add(allsettings);
        menubar.getMenus().addAll(file,settings,help,about);

        handleClicking();

    }

    private void handleClicking(){
        filemenuitem2.setOnAction(e->menuListener.setExit());
        about.setOnAction(e->menuListener.setAbout());
        allsettings.setOnAction(e->menuListener.setAllSettings());
    }


}
