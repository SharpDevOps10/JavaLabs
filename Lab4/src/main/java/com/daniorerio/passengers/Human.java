package com.daniorerio.passengers;

import com.daniorerio.vehicles.Vehicle;

public class Human {
    private final String name;
    private Vehicle passengerVehicle = null;

    public Human(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Vehicle getPassengerVehicle() {
        return passengerVehicle;
    }

    public void setPassengerVehicle(Vehicle passengerVehicle) {
        this.passengerVehicle = passengerVehicle;
    }
}
