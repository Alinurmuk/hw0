package edu.narxoz.galactic.dispatcher;

import edu.narxoz.galactic.cargo.Cargo;
import edu.narxoz.galactic.drones.*;

public class LightDeliveryFactory implements DeliveryFactory {
    @Override
    public Drone createDrone(String id) {
        return new LightDrone(id, 20.0);
    }

    @Override
    public Cargo createCargo(String description) {
        return new Cargo(10.0, description);
    }
}