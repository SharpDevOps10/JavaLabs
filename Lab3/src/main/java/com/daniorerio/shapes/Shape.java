package com.daniorerio.shapes;

import com.daniorerio.drawable.Drawable;

public abstract class Shape implements Drawable {
    protected String shapeColor;

    public Shape(String shapeColor) {
        this.shapeColor = shapeColor;
    }

    public abstract double calcArea();

    @Override
    public String toString() {
        return super.toString();
    }
}
