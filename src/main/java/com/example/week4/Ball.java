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


    private int speed = 2;

    private int speedX = 1;
    private int speedY = 1;

    public Ball() {
        posX = 250;
        posY = 120;
        radius = 30 ;
        cage = new Image(getClass().getResourceAsStream(imagepath));

    }

    public double getPosX() {
        return this.posX;
    }

    public double getPosY() {
        return this.posY;
    }

    public double getRadius() {
        return this.radius;
    }

    public Image getCage(){
        return this.cage;
    }

    public int getSpeed() {
        return speed;
    }

    @Override
    public void resizeX(double factor) {
        this.posX = this.posX*factor;
        this.radius = this.radius*factor;
    }

    @Override
    public void resizeY(double factor) {
        this.posY = this.posY*factor;
        this.radius = this.radius*factor;
    }

    public void setSpeedup() {
        this.speed++;
    }

    public void setSpeedDown() {
        this.speed--;
    }

    public void setSpeedStop(){
        this.speedX = 0;
        this.speedY = 0;
    }
    public int getSpeedX(){
        return speedX;
    }
    public int getSpeedY(){
        return speedY;
    }

    public void setSpeedStart(int speedx,int speedy){
        this.speedX  = speedx;
        this.speedY = speedy;
    }


    public void move() {
        posY += speedY;
        posX += speedX;
    }

    public void bounceTopOrBottom(){
        speedY = speedY*-1;
    }

    public void bounceX(){
        speedX = speedX*-1;
    }

    public void resetBall(){
        posX = 250;
        posY = 120;
    }
}
