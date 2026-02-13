package edu.narxoz.galactic.dispatcher;

import edu.narxoz.galactic.cargo.Cargo;
import edu.narxoz.galactic.drones.Drone;

public interface DeliveryFactory {
    Drone createDrone(String id);
    Cargo createCargo(String description);
}