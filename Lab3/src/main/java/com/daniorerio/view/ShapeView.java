package com.daniorerio.view;

import com.daniorerio.shapes.Shape;

public class ShapeView {
    public void displayShapes(Shape[] shapes) {
        for (Shape shape : shapes) {
            System.out.println(shape);
        }
    }

    public void displayTotalArea(double totalArea) {
        System.out.println("Total area of all shapes: " + totalArea);
    }

    public void displayTotalAreaByType(double totalArea, String shapeType) {
        System.out.println("Total area of " + shapeType + "s: " + totalArea);
    }

    public void displaySortedShapes(String sortingCriteria) {
        System.out.println("\nSorting by " + sortingCriteria + ":");
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
}