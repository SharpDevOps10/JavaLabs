package com.daniorerio.shapes;

import com.daniorerio.drawable.Drawable;

public abstract class Shape implements Drawable {
    public String shapeColor;

    public Shape(String shapeColor) {
        this.shapeColor = shapeColor;
    }

    public abstract double calcArea();

    @Override
    public void draw() {
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
