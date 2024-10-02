package com.daniorerio;

import com.daniorerio.controller.ShapeController;

public class Main {
    public static void main(String[] args) {
        ShapeController controller = new ShapeController(10);
        controller.startInteraction();
    }
}