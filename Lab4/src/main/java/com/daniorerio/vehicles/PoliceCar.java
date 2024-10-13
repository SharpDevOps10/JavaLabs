package com.daniorerio.vehicles;

import com.daniorerio.passengers.Policeman;

public class PoliceCar<T extends Policeman> extends Car<T> {
    public PoliceCar(int maxSeats, String name) {
        super(maxSeats, name);
    }
}