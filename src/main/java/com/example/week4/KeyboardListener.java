package com.example.week4;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class KeyboardListener implements EventHandler<KeyEvent> {
    private Game game;
    private LabCanvas canvas;
    public KeyboardListener(Game game2, LabCanvas canvas) {
        this.game =game2;
        this.canvas =canvas;
    }

    /**
     * Handle the keyboard inputs which move the rackets
     * @param keyEvent The key being pressed down
     */
    @Override
    public void handle(KeyEvent keyEvent) {
        System.out.println(keyEvent);
        KeyCode key=keyEvent.getCode();
        if (KeyCode.UP.equals(key))
        {
            if(game.getPlayer2().getRacket().getPosY()>0){
                game.getPlayer2().getRacket().moveUp();
            }

        }else if (KeyCode.DOWN.equals(key))
        {
            if (game.getPlayer2().getRacket().getPosY()+game.getPlayer2().getRacket().getSize()< game.getDimensionY()){
                game.getPlayer2().getRacket().moveDown();
            }

        }
        if (KeyCode.W.equals(key))
        {
            if (game.getPlayer1().getRacket().getPosY()>0){
                game.getPlayer1().getRacket().moveUp();
            }

        }else if (KeyCode.S.equals(key))
        {
            if (game.getPlayer1().getRacket().getPosY()+game.getPlayer1().getRacket().getSize()< game.getDimensionY()){
                game.getPlayer1().getRacket().moveDown();
            }

        }
        canvas.drawGame(game);
    }
}