package com.example.week4;

import com.example.week4.Listener.LabController;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LabControllerTest {

    @Test
    void player1bounce() {
        LabController controller = new LabController(new Game());
        assertFalse(controller.player1bounce());
    }

    @Test
    void player2bounce() {
        LabController controller = new LabController(new Game());
        assertFalse(controller.player2bounce());
    }
}