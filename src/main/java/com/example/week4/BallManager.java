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
        Player winner = null;
        int counter=0;
        boolean gameend = false;
        while(true)
        {
            counter++;
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            ball.move();
            if(ball.getSpeedX() != 0){
                gameend = false;
            }
            if (ball.getPosX()<5)
            {
                if (game.getGamedifficulty()>1){
                    ball.setSpeedup();
                    ball.StartSpeed();
                }
                game.getPlayer2().incrementScore();
                ball.resetBall();
                canvas.drawGoal(game.getPlayer2());
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                canvas.drawGame(game);
//player 2 has scored, add code here
            }
            if (ball.getPosX()>game.getDimensionX()-ball.getRadius())
            {
                if (game.getGamedifficulty()>1){
                    ball.setSpeedup();
                    ball.StartSpeed();
                }
                game.getPlayer1().incrementScore();
                ball.resetBall();
                canvas.drawGoal(game.getPlayer1());
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                canvas.drawGame(game);
//player 1 has scored, add code here
            }
            if (ball.getPosY() >= game.getDimensionY() - ball.getRadius() || ball.getPosY() <= ball.getRadius()){
                ball.bounceTopOrBottom();
            }
            //player1 racket bouncing
            if ((game.getPlayer1().getRacket().getPosX()+game.getPlayer1().getRacket().getThickness() >= ball.getPosX())&&game.getPlayer1().getRacket().getPosY()<= ball.getPosY()&& ball.getPosY() <=game.getPlayer1().getRacket().getPosY()+game.getPlayer1().getRacket().getSize()){
                ball.bounceX();
            }
            //player 2 racket bouncing not working yet
            if ((game.getPlayer2().getRacket().getPosX() <= ball.getPosX()+ ball.getRadius()/2)&&game.getPlayer2().getRacket().getPosY()<= ball.getPosY()&& ball.getPosY() <=game.getPlayer2().getRacket().getPosY()+game.getPlayer2().getRacket().getSize()){
                ball.bounceX();
            }
            if (game.getGameendingscr() == game.getPlayer1().getScore() && !gameend){

                game.getBall().setSpeedStop();
                gameend = true;
                winner = game.getPlayer1();
            }
            if (game.getGameendingscr() == game.getPlayer2().getScore() && !gameend){

                game.getBall().setSpeedStop();
                gameend = true;
                winner = game.getPlayer2();

            }
            if(gameend){
                canvas.drawWin(winner);
            }else {
                canvas.drawGame(game);
            }




        }
    }
}
