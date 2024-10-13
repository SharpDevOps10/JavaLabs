package com.daniorerio.vehicles;

import com.daniorerio.passengers.Firefighter;

public class FirefighterCar<T extends Firefighter> extends Car<T> {
    public FirefighterCar(int maxSeats, String name) {
        super(maxSeats, name);
    }
}