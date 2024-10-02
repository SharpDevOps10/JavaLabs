package com.daniorerio.controller;

import com.daniorerio.model.ShapeModel;
import com.daniorerio.shapes.Circle;
import com.daniorerio.shapes.Rectangle;
import com.daniorerio.shapes.Shape;
import com.daniorerio.shapes.Triangle;
import com.daniorerio.utils.UserInputHandler;
import com.daniorerio.view.ShapeView;

public class ShapeController {
    private final ShapeModel model;
    private final ShapeView view;
    private final UserInputHandler userInputHandler;

    public ShapeController(int numberOfShapes) {
        this.model = new ShapeModel(numberOfShapes);
        this.view = new ShapeView();
        this.userInputHandler = new UserInputHandler();
    }

    public void startInteraction() {
        if (userInputHandler.askToDisplayShapes()) {
            view.displayMessage("Displaying all shapes:");
            displayShapes();
            displayTotalArea();
        } else {
            view.displayMessage("Exiting program.");
            return;
        }

        String shapeTypeInput = userInputHandler.askForShapeType();

        if ("all".equals(shapeTypeInput)) {
            displayTotalAreaForAllTypes();
        } else {
            Class<? extends Shape> shapeType = model.getShapeType(shapeTypeInput);
            if (shapeType != null) {
                displayTotalAreaByType(shapeType, shapeTypeInput);
            } else {
                view.displayMessage("Invalid shape type. Exiting program.");
                return;
            }
        }

        if (userInputHandler.askToSortByArea()) {
            sortByArea();
        }

        if (userInputHandler.askToSortByColor()) {
            sortByColor();
        }

        userInputHandler.close();
    }

    public void displayShapes() {
        view.displayShapes(model.getShapes());
    }

    public void displayTotalArea() {
        double totalArea = model.getTotalArea();
        view.displayTotalArea(totalArea);
    }

    public void displayTotalAreaByType(Class<? extends Shape> shapeType, String shapeTypeName) {
        double totalArea = model.getTotalAreaByType(shapeType);
        view.displayTotalAreaByType(totalArea, shapeTypeName);
    }

    public void displayTotalAreaForAllTypes() {
        double totalAreaTriangles = model.getTotalAreaByType(Triangle.class);
        double totalAreaCircles = model.getTotalAreaByType(Circle.class);
        double totalAreaRectangles = model.getTotalAreaByType(Rectangle.class);

        view.displayTotalAreaByType(totalAreaTriangles, "Triangles");
        view.displayTotalAreaByType(totalAreaCircles, "Circles");
        view.displayTotalAreaByType(totalAreaRectangles, "Rectangles");
    }

    public void sortByArea() {
        model.sortByArea();
        view.displaySortedShapes("area");
        displayShapes();
    }

    public void sortByColor() {
        model.sortByColor();
        view.displaySortedShapes("color");
        displayShapes();
    }
}