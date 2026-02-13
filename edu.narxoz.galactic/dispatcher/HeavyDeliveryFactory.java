package edu.narxoz.galactic.dispatcher;

import edu.narxoz.galactic.cargo.Cargo;
import edu.narxoz.galactic.drones.*;

public class HeavyDeliveryFactory implements DeliveryFactory {

    @Override
    public Drone createDrone(String id) {
        return new HeavyDrone(id, 1000.0);
    }

    @Override
    public Cargo createCargo(String description) {
        return new Cargo(500.0, description);
    }
}