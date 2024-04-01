package com.example.week4;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.HashSet;
import java.util.Set;

public class KeyboardListenercopy implements EventHandler<KeyEvent> {
    private Set<KeyCode> pressedKeys = new HashSet<>();
    private Game game;
    private LabCanvas canvas;
    private MenuListener menuListener;

    public KeyboardListenercopy(Game game, LabCanvas canvas, MenuListener menuListener) {
        this.game = game;
        this.canvas = canvas;
        this.menuListener = menuListener;
    }

    @Override
    public void handle(KeyEvent keyEvent) {
        KeyCode key = keyEvent.getCode();
        if (keyEvent.getEventType() == KeyEvent.KEY_PRESSED) {
            pressedKeys.add(key);
        } else if (keyEvent.getEventType() == KeyEvent.KEY_RELEASED) {
            pressedKeys.remove(key);
        }

        if (pressedKeys.contains(KeyCode.SPACE)) {
            menuListener.playPause();
        }

        if (pressedKeys.contains(KeyCode.W)) {
            if (game.getPlayer1().getRacket().getPosY() > 0) {
                game.getPlayer1().getRacket().moveUp();
            }
        }
        if (pressedKeys.contains(KeyCode.S)) {
            if (game.getPlayer1().getRacket().getPosY() + game.getPlayer1().getRacket().getSize() < game.getDimensionY()) {
                game.getPlayer1().getRacket().moveDown();
            }
        }

        if (pressedKeys.contains(KeyCode.UP)) {
            if (game.getPlayer2().getRacket().getPosY() > 0) {
                game.getPlayer2().getRacket().moveUp();
            }
        }
        if (pressedKeys.contains(KeyCode.DOWN)) {
            if (game.getPlayer2().getRacket().getPosY() + game.getPlayer2().getRacket().getSize() < game.getDimensionY()) {
                game.getPlayer2().getRacket().moveDown();
            }
        }

        canvas.drawGame(game);
    }
}
//    private Game game;
//    private LabCanvas canvas;
//
//    private MenuListener menuListener;
//
//    /**
//     * Create an object of the KeyBoard Listener class
//     * @param game2 Game object being used by the game
//     * @param canvas The canvas that is being used by the game
//     */
//    public KeyboardListenercopy(Game game2, LabCanvas canvas, MenuListener menuListener) {
//        this.game =game2;
//        this.canvas =canvas;
//        this.menuListener = menuListener;
//    }
//
//    /**
//     * Handle the keyboard inputs which move the rackets
//     * @param keyEvent The key being pressed down
//     */
//    @Override
//    public void handle(KeyEvent keyEvent) {
//        System.out.println(keyEvent);
//        KeyCode key=keyEvent.getCode();
//        if(KeyCode.SPACE.equals(key)){
//            menuListener.playPause();
//        }
//        if (KeyCode.UP.equals(key))
//        {
//            if(game.getPlayer2().getRacket().getPosY()>0){
//                game.getPlayer2().getRacket().moveUp();
//            }
//
//        }else if (KeyCode.DOWN.equals(key))
//        {
//            if (game.getPlayer2().getRacket().getPosY()+game.getPlayer2().getRacket().getSize()< game.getDimensionY()){
//                game.getPlayer2().getRacket().moveDown();
//            }
//
//        }
//        if (KeyCode.W.equals(key))
//        {
//            if (game.getPlayer1().getRacket().getPosY()>0){
//                game.getPlayer1().getRacket().moveUp();
//            }
//
//        }else if (KeyCode.S.equals(key))
//        {
//            if (game.getPlayer1().getRacket().getPosY()+game.getPlayer1().getRacket().getSize()< game.getDimensionY()){
//                game.getPlayer1().getRacket().moveDown();
//            }
//
//        }
//        canvas.drawGame(game);
//    }
