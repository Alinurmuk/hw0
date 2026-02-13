package edu.narxoz.galactic.drones;

public abstract class DroneFactory {

    public Drone create(String id, double maxPayloadKg) {
        return createDrone(id, maxPayloadKg);
    }

    protected abstract Drone createDrone(String id, double maxPayloadKg);
}