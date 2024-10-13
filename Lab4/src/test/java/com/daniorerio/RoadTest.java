package com.daniorerio;

import com.daniorerio.passengers.Firefighter;
import com.daniorerio.passengers.Human;
import com.daniorerio.passengers.Policeman;
import com.daniorerio.road.Road;
import com.daniorerio.vehicles.Bus;
import com.daniorerio.vehicles.PoliceCar;
import com.daniorerio.vehicles.Taxi;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RoadTest {
    private Road road;
    private Bus<Human> bus;
    private Taxi<Human> taxi;
    private PoliceCar<Policeman> policeCar;

    @Before
    public void setUp() {
        road = new Road();
        bus = new Bus<>(50, "City Bus");
        taxi = new Taxi<>(4, "TaxiCab");
        policeCar = new PoliceCar<>(9, "Police Cruiser");

        Human john = new Human("John");
        Human mike = new Human("Mike");
        Firefighter sam = new Firefighter("Sam");
        Policeman smith = new Policeman("Smith");

        bus.addPassenger(john);
        bus.addPassenger(mike);
        taxi.addPassenger(sam);
        policeCar.addPassenger(smith);
    }

    @Test
    public void testAddCarToRoad() {
        road.addCarToRoad(bus);
        road.addCarToRoad(taxi);
        assertTrue(road.carsInRoad.contains(bus));
        assertTrue(road.carsInRoad.contains(taxi));
    }

    @Test
    public void testRemoveCarFromRoad() {
        road.addCarToRoad(bus);
        road.removeCarFromRoad(bus);
        assertFalse(road.carsInRoad.contains(bus));
    }

    @Test
    public void testGetCountOfHumans() {
        road.addCarToRoad(bus);
        road.addCarToRoad(taxi);
        road.addCarToRoad(policeCar);

        int totalHumans = road.getCountOfHumans();
        assertEquals(4, totalHumans);
    }

    @Test
    public void testAddCarWithExistingRoad() {
        road.addCarToRoad(bus);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> road.addCarToRoad(bus));
        assertEquals("Vehicle already has a road", exception.getMessage());
    }

    @Test
    public void testRemoveCarNotInRoad() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> road.removeCarFromRoad(bus));
        assertEquals("Vehicle does not have a road", exception.getMessage());
    }
}