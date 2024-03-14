package com.example.week4;

public interface Resizable {
    /**
     * Allows the classes implementing this method to dynamically resize when called
     * @param factor The factor by which the window has changed in the X axis
     */
    public void resizeX(double factor);
    /**
     * Allows the classes implementing this method to dynamically resize when called
     * @param factor The factor by which the window has changed in the Y axis
     */
    public void resizeY(double factor);

}
