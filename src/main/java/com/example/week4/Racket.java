package com.example.week4;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class Racket implements Resizable{

    private double posX;
    private double posY;

    private double thickness;

    private double size;

    private Paint colour;

    private double offset = 0;

    public Racket(double width,double height){

        thickness = 30;
        offset = 10+thickness;
        posX = width - offset;
//        posX = width-10;
        posY = height/2;
        size = 100;
        colour = Color.RED;
    }
    public Racket(double height){
        posX = 10;
        posY = height/2;
        thickness = 30;
        size = 100;
        colour = Color.YELLOW;
    }
    public Racket(){
        posX = 10;
        posY = 100;
        thickness = 30;
        size = 100;
        colour = Color.YELLOW;
    }



    public double getPosX() {
        return this.posX;
    }

    public double getPosY(){
        return this.posY;
    }

    public double getThickness() {
        return this.thickness;
    }

    public double getSize() {
        return this.size;
    }

    public Paint getColor() {
        return this.colour;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public void setThickness(double thickness){
        this.thickness = thickness;
    }

    @Override
    public void resizeX(double factor) {
        this.thickness =this.thickness*factor;
//        if (!(offset ==0)){
//            this.offset = this.offset*factor;
//            System.out.println(offset);
//        }
        this.posX=this.posX*factor;

    }

    @Override
    public void resizeY(double factor) {
        this.posY=this.posY*factor;
        this.size = this.size*factor;
    }
}
