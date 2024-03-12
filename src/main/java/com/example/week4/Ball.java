package com.example.week4;

import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;

public class Ball implements Resizable{

    private String imagepath = "/images/cage1.png";
    private Image cage;

    private double posX;

    private double posY;

    private double radius;


    private int speed = 1;

    private int speedX = 1;
    private int speedY = 1;

    /**
     * Create a new ball object with default values
     */
    public Ball() {
        posX = 250;
        posY = 120;
        radius = 30 ;
        cage = new Image(getClass().getResourceAsStream(imagepath));

    }

    /**
     * Get the X position of the ball
     * @return Return the X position of the ball
     */
    public double getPosX() {
        return this.posX;
    }

    /**
     * Get the Y position of the ball
     * @return Return the Y position on the ball
     */
    public double getPosY() {
        return this.posY;
    }

    /**
     * Get the radius of the ball
     * @return Return the radius of the ball
     */
    public double getRadius() {
        return this.radius;
    }

    /**
     * Get the image of the ball
     * @return Return the image of the ball
     */
    public Image getCage(){
        return this.cage;
    }

    /**
     * Get the speed of the ball
     * @return Return the speed of the ball
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * Resize the ball by the factor
     * @param factor The multiplier by which to change the ball size
     */
    @Override
    public void resizeX(double factor) {
        this.posX = this.posX*factor;
        this.radius = this.radius*factor;
    }

    /**
     * Resize the ball by the factor
     * @param factor The multiplier by which to change the ball size
     */
    @Override
    public void resizeY(double factor) {
        this.posY = this.posY*factor;
        this.radius = this.radius*factor;
    }

    /**
     * Increment the speed by 1 as long as its less than 5
     */
    public void setSpeedup() {
        if(speed <5){
            this.speed++;
        }
    }

    /**
     * Decrement the speed by 1 as long as its greater than 1
     */
    public void setSpeedDown() {
        if (speed>1){
            this.speed--;
        }
    }

    /**
     * Start the ball movement
     */
    public void StartSpeed(){
        this.speedX = speed;
        this.speedY = speed;
    }

    /**
     * Stop the ball movement
     */
    public void setSpeedStop(){
        this.speedX = 0;
        this.speedY = 0;
    }

    /**
     * Get the X speed of the ball
     * @return Return the X speed of the ball
     */
    public int getSpeedX(){
        return speedX;
    }
//    public int getSpeedY(){
//        return speedY;
//    }

//    public void setSpeedStart(int speedx,int speedy){
//        this.speedX  = speedx;
//        this.speedY = speedy;
//    }

    /**
     * Move the ball on the canvas
     */
    public void move() {
        posY += speedY;
        posX += speedX;
    }

    /**
     * Ball bounce if it hits the top or bottom of the canvas
     */
    public void bounceTopOrBottom(){
        speedY = speedY*-1;
    }

    /**
     * Bounce the ball if it hits the paddles
     */
    public void bounceX(){
        speedX = speedX*-1;
    }

    /**
     * Reset the ball to the original position
     */
    public void resetBall(){
        posX = 300;
        posY = 320;
    }
}
