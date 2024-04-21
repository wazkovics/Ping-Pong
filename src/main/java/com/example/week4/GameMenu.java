package com.example.week4;



import com.example.week4.Listener.MenuListener;
import javafx.scene.control.*;


public class GameMenu {
    public MenuBar menubar = new MenuBar();
    private Menu file = new Menu("Game");
    private MenuItem filemenuitem1 = new MenuItem("New Game");

    private MenuItem filemenuitem2 = new MenuItem("Play/Pause game");

    private MenuItem filemenuitem3 = new MenuItem("Save Game");

    private MenuItem filemenuitem4 = new MenuItem("Load Saved Game");

    private MenuItem filemenuitem5 = new MenuItem("Save Game to Database");

    private MenuItem filemenuitem6 = new MenuItem("Load Saved Game from Database");
    private MenuItem filemenuitem7 = new MenuItem("Exit");
    private Menu settings = new Menu("Settings");

//    private MenuItem resetball = new MenuItem("Reset Ball");

    private MenuItem allsettings = new MenuItem("Open Settings");
    private Menu help = new Menu("Help");
    private Menu about = new Menu("About");

    private MenuListener menuListener;

    /**
     * Create a game menu object with a listener
     * @param listener The menu listener which listens for interactions between the menu and the user
     */
    public GameMenu(MenuListener listener){
        this.menuListener = listener;

        file.getItems().addAll(filemenuitem1,filemenuitem2,filemenuitem3,filemenuitem4,filemenuitem5,filemenuitem6,filemenuitem7);
        settings.getItems().addAll(allsettings);
        menubar.getMenus().addAll(file,settings,help,about);
        handleClicking();

    }

    /**
     * Handles the interactions between the user and the game menu
     */
    private void handleClicking(){
        filemenuitem1.setOnAction(e->menuListener.newGame());
        filemenuitem2.setOnAction(e-> menuListener.playPause());
        filemenuitem3.setOnAction(e->menuListener.saveGame());
        filemenuitem4.setOnAction(e->menuListener.loadGame());
        filemenuitem5.setOnAction(e->menuListener.saveGametoDatabase());
        filemenuitem6.setOnAction(e->menuListener.loadGamefromDatatbase());
        filemenuitem7.setOnAction(e->menuListener.setExit());
        about.setOnAction(e-> menuListener.setAbout());
        allsettings.setOnAction(e->menuListener.setAllSettings());
    }


}
