package com.an.gameengine_adk.Engine.Structure;

public class Circle {
    public double x;
    public double y;
    public double radius;

    public Circle(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public boolean contains(int x, int y){
        if (radius <= Math.sqrt((this.x - x) * (this.x - x) + (this.y - y) * (this.y - y)))
            return true;
        else
            return false;
    }
}
