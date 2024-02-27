package com.example.week4;

public class BallManager implements Runnable{
    private Game game;
    private LabCanvas canvas;
    public BallManager(Game c, LabCanvas canvas) {
        this.game=c;
        this.canvas=canvas;
    }
    @Override
    public void run() {
        Ball ball = game.getBall();
        int counter=0;
        while(true)
        {
            counter++;
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            ball.move();
            if (ball.getPosX()<5)
            {
//player 2 has scored, add code here
            }
            if (ball.getPosX()>game.getDimensionX()-ball.getRadius())
            {
//player 1 has scored, add code here
            }
            if (ball.getPosY() == game.getDimensionY() - ball.getRadius() || ball.getPosY() == ball.getRadius()){
                ball.bounceTopOrBottom();
            }
// CODE to CHECK BOUNCING WITH RACKET
            canvas.drawGame(game);
        }
    }
}
