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

    /**
     * Create a racket object
     * @param width Width of the window
     * @param height Height of the window
     */
    public Racket(double width,double height){

        thickness = 30;
        offset = 10+thickness;
        posX = width - offset;
//        posX = width-10;
        posY = height/2;
        size = 100;
        colour = Color.RED;
    }

    /**
     * Create a racket object
     * @param height Height of the window
     */
    public Racket(double height){
        posX = 10;
        posY = height/2;
        thickness = 30;
        size = 100;
        colour = Color.YELLOW;
    }
//    public Racket(){
//        posX = 10;
//        posY = 100;
//        thickness = 30;
//        size = 100;
//        colour = Color.YELLOW;
//    }


    /**
     * Get the X position of the racket on the canvas
     * @return Return the X position of the racket
     */
    public double getPosX() {
        return this.posX;
    }

    /**
     * Get the Y position of the racket on the cavnas
     * @return Return the Y position of the racket
     */
    public double getPosY(){
        return this.posY;
    }

    /**
     * Get the thickness of the racket
     * @return Return the thickness of the racket
     */
    public double getThickness() {
        return this.thickness;
    }

    /**
     * Get the length of the racket
     * @return Return the length of the racket
     */
    public double getSize() {
        return this.size;
    }

    /**
     * Get the colour of the racket
     * @return Return the paint object of the racket
     */
    public Paint getColor() {
        return this.colour;
    }

    /**
     * Set the length of the racket
     * @param size The variable to set the length of the racket
     */
    public void setSize(double size) {
        this.size = size;
    }

    /**
     * Set the thickness of the racket
     * @param thickness The varuable to set the thickness of the racket
     */
    public void setThickness(double thickness){
        this.thickness = thickness;
    }

    /**
     * Allows the racket to change with the window width
     * @param factor The variable to multiply the thickness and poX so the racket can change on window width resize
     */
    @Override
    public void resizeX(double factor) {
        this.thickness =this.thickness*factor;
//        if (!(offset ==0)){
//            this.offset = this.offset*factor;
//            System.out.println(offset);
//        }
        this.posX=this.posX*factor;

    }

    /**
     * Allows the racket to change with the window height
     * @param factor The variable to multiply the thickness and poX so the racket can change on window height resize
     */
    @Override
    public void resizeY(double factor) {
        this.posY=this.posY*factor;
        this.size = this.size*factor;
    }

    /**
     * Move the racket up the screen
     */
    public void moveUp() {
        this.posY -= 10;
    }

    /**
     * Move the racket down the screen.
     */
    public void moveDown() {
        this.posY += 10;
    }
}
