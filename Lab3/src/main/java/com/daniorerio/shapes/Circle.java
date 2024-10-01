package com.daniorerio.shapes;

public class Circle extends Shape {
    private final double radius;

    public Circle(String shapeColor, double radius) {
        super(shapeColor);
        this.radius = radius;
    }

    @Override
    public double calcArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return super.toString() + ", Circle: radius = " + radius + ", area = " + calcArea();
    }

    @Override
    public void draw() {
        System.out.println("Drawing Circle");
    }
}
