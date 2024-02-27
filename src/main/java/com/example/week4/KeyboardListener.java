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
    @Override
    public void handle(KeyEvent keyEvent) {
        System.out.println(keyEvent);
        KeyCode key=keyEvent.getCode();
        if (KeyCode.UP.equals(key))
        {
            game.getPlayer2().getRacket().moveUp();
        }
        if (KeyCode.DOWN.equals(key))
        {
            game.getPlayer2().getRacket().moveDown();
        }
        if (KeyCode.W.equals(key))
        {
            game.getPlayer1().getRacket().moveUp();
        }
        if (KeyCode.S.equals(key))
        {
            game.getPlayer1().getRacket().moveDown();
        }
        canvas.drawGame(game);
    }
}