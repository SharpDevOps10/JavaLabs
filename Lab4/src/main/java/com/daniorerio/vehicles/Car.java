package com.daniorerio.vehicles;

import com.daniorerio.passengers.Human;

class Car<T extends Human> extends Vehicle<T> {
    public Car(int maxSeats, String name) {
        super(maxSeats, name);
    }
}
