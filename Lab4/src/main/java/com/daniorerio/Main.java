package com.daniorerio;

import com.daniorerio.passengers.Firefighter;
import com.daniorerio.passengers.Human;
import com.daniorerio.passengers.Policeman;
import com.daniorerio.road.Road;
import com.daniorerio.vehicles.Bus;
import com.daniorerio.vehicles.FirefighterCar;
import com.daniorerio.vehicles.PoliceCar;
import com.daniorerio.vehicles.Taxi;

public class Main {
    public static void main(String[] args) {
        Road road = new Road();
        Bus<Human> bus = new Bus<>(50, "5 DUK");
        Taxi<Human> taxi = new Taxi<>(4, "DriveTrek");
        FirefighterCar<Firefighter> firefighterCar = new FirefighterCar<>(8, "Battalion");
        PoliceCar<Policeman> policeCar = new PoliceCar<>(9, "Duke");

        Human john = new Human("John");
        Human mike = new Human("Mike");
        Firefighter sam = new Firefighter("Firefighter Sam");
        Policeman smith = new Policeman("Officer Smith");

        bus.addPassenger(john);
        taxi.addPassenger(mike);
        firefighterCar.addPassenger(sam);
        policeCar.addPassenger(smith);

        road.addCarToRoad(bus);
        road.addCarToRoad(taxi);
        road.addCarToRoad(firefighterCar);
        road.addCarToRoad(policeCar);

        System.out.println("Total passengers on road: " + road.getCountOfHumans());

        road.removeCarFromRoad(policeCar);
        System.out.println("Total passengers on road: " + road.getCountOfHumans());

        bus.removePassenger(john);

        System.out.println("John's current vehicle: " + john.getPassengerVehicle());

    }
}