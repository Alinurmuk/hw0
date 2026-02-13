package edu.narxoz.galactic.drones;

public class HeavyDroneFactory extends DroneFactory {

    @Override
    protected Drone createDrone(String id, double maxPayloadKg) {
        return new HeavyDrone(id, maxPayloadKg);
    }
}