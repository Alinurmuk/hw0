package edu.narxoz.galactic.drones;

public class LightDroneFactory extends DroneFactory {

    @Override
    protected Drone createDrone(String id, double maxPayloadKg) {
        return new LightDrone(id, maxPayloadKg);
    }
}