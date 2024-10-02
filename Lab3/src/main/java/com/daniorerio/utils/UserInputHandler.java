package com.daniorerio.utils;

import java.util.Scanner;

public class UserInputHandler {
    private final Scanner scanner;

    public UserInputHandler() {
        this.scanner = new Scanner(System.in);
    }

    public boolean askToDisplayShapes() {
        System.out.print("Do you want to display all shapes? (y/n): ");
        return scanner.nextLine().equalsIgnoreCase("y");
    }

    public String askForShapeType() {
        System.out.print("For which figure do you need to calculate the total area (Triangle, Circle, Rectangle, All)? ");
        return scanner.nextLine().toLowerCase();
    }

    public boolean askToSortByArea() {
        System.out.print("Should I sort by area? (y/n): ");
        return scanner.nextLine().equalsIgnoreCase("y");
    }

    public boolean askToSortByColor() {
        System.out.print("Should I sort by color? (y/n): ");
        return scanner.nextLine().equalsIgnoreCase("y");
    }

    public void close() {
        scanner.close();
    }
}