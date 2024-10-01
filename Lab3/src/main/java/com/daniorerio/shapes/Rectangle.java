package com.daniorerio.shapes;

public class Rectangle extends Shape {
    private final double width;
    private final double height;

    public Rectangle(String shapeColor, double width, double height) {
        super(shapeColor);
        this.width = width;
        this.height = height;
    }

    @Override
    public double calcArea() {
        return width * height;
    }

    @Override
    public String toString() {
        return super.toString() + ", Rectangle: width = " + width + ", height = " + height + ", area = " + calcArea();
    }

    @Override
    public void draw() {
        System.out.println("Drawing rectangle");
    }
}
