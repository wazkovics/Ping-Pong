package com.example.week4;

public class BallManager implements Runnable{
    private final Game game;
    private final LabCanvas canvas;
    private final LabController controller;

    /**
     * Create a Ball manager object ,which will manager the interactions between the ball and its environment
     * @param c The game object for which to manage the ball for
     * @param canvas The canvas on which the ball is drawn
     */
    public BallManager(Game c, LabCanvas canvas,LabController labController) {
        this.game=c;
        this.canvas=canvas;
        this.controller = labController;
    }

    /**
     * Starts the ball movement and checks its interactions with its surroundings like the paddles and the top/bottom of the game window
     */
    @Override
    public void run() {
        Ball ball = game.getBall();
        Player winner = null;
        int counter=0;
        int bouncecounter = 0;
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
                bouncecounter = 0;
//                if (game.getGamedifficulty()>1){
//                    ball.setSpeedup();
//                    ball.startSpeed();
//                }
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
                bouncecounter = 0;
//                if (game.getGamedifficulty()>1){
//                    ball.setSpeedup();
//                    ball.startSpeed();
//                }
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
                bouncecounter++;
            }
            //player1 racket bouncing
//            if ((game.getPlayer1().getRacket().getPosX()+game.getPlayer1().getRacket().getThickness() >= ball.getPosX())&&game.getPlayer1().getRacket().getPosY()<= ball.getPosY()&& ball.getPosY() <=game.getPlayer1().getRacket().getPosY()+game.getPlayer1().getRacket().getSize()){
//                ball.bounceX();
//            }
            if(controller.player1bounce()){
                ball.bounceX();
                bouncecounter++;
            }
            //player 2 racket bouncing not working yet
//            if ((game.getPlayer2().getRacket().getPosX() <= ball.getPosX()+ ball.getRadius()/2)&&game.getPlayer2().getRacket().getPosY()<= ball.getPosY()&& ball.getPosY() <=game.getPlayer2().getRacket().getPosY()+game.getPlayer2().getRacket().getSize()){
//                ball.bounceX();
//            }
            if (controller.player2bounce()){
                ball.bounceX();
                bouncecounter++;
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
            if (bouncecounter > 3){
                bouncecounter = 0;
                ball.setSpeedup();
                ball.startSpeed();
            }




        }
    }
}
