package com.daniorerio.controller;

import com.daniorerio.model.ShapeModel;
import com.daniorerio.shapes.Circle;
import com.daniorerio.shapes.Rectangle;
import com.daniorerio.shapes.Shape;
import com.daniorerio.shapes.Triangle;
import com.daniorerio.utils.ShapeFileManager;
import com.daniorerio.utils.UserInputHandler;
import com.daniorerio.view.ShapeView;

import java.util.HashMap;
import java.util.Map;

public class ShapeController {
    private ShapeModel model;
    private final ShapeView view;
    private final UserInputHandler userInputHandler;
    private final ShapeFileManager fileManager;

    public ShapeController(int numberOfShapes) {
        this.model = new ShapeModel(numberOfShapes);
        this.view = new ShapeView();
        this.userInputHandler = new UserInputHandler();
        this.fileManager = new ShapeFileManager();
    }

    public void startInteraction() {
        view.displayMessage(view.AVAILABLE_COMMANDS);
        Map<String, Runnable> commands = new HashMap<>();

        commands.put("display", () -> {
            view.displayMessage(view.DISPLAYING_SHAPES);
            displayShapes();
            displayTotalArea();
        });

        commands.put("load", () -> {
            String loadedFile = userInputHandler.askForFileName("load");
            Shape[] loadedShapes = fileManager.loadShapesFromFile(loadedFile);
            if (loadedShapes != null) {
                model = new ShapeModel(loadedShapes.length);
                System.arraycopy(loadedShapes, 0, model.getShapes(), 0, loadedShapes.length);
                view.displayMessage("Shapes loaded successfully.");
                view.displayShapes(loadedShapes);
            } else {
                view.displayMessage("Failed to load shapes.");
            }
        });

        commands.put("save", () -> {
            String savedFile = userInputHandler.askForFileName("save");
            fileManager.saveShapesToFile(model.getShapes(), savedFile);
            view.displayMessage("Shapes saved successfully.");
        });

        commands.put("sort area", this::sortByArea);
        commands.put("sort color", this::sortByColor);
        commands.put("total area", this::displayTotalAreaForAllTypes);

        commands.put("exit", () -> {
            view.displayMessage(view.EXIT_PROGRAM);
            userInputHandler.close();
        });

        while (true) {
            String command = userInputHandler.askForCommand().toLowerCase();

            Runnable action = commands.get(command);
            if (action != null) {
                action.run();
                if (command.equals("exit")) break;
            } else {
                view.displayMessage(view.INVALID_COMMAND);
            }
        }
    }

    public void displayShapes() {
        view.displayShapes(model.getShapes());
    }

    public void displayTotalArea() {
        double totalArea = model.getTotalArea();
        view.displayTotalArea(totalArea);
    }

    public void displayTotalAreaForAllTypes() {
        double totalAreaTriangles = model.getTotalAreaByType(Triangle.class);
        double totalAreaCircles = model.getTotalAreaByType(Circle.class);
        double totalAreaRectangles = model.getTotalAreaByType(Rectangle.class);

        view.displayTotalAreaByType(totalAreaTriangles, "Triangle");
        view.displayTotalAreaByType(totalAreaCircles, "Circle");
        view.displayTotalAreaByType(totalAreaRectangles, "Rectangle");
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