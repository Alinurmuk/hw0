package edu.narxoz.galactic.demo; // Пакет атауы ерікті, бірақ логикалық тұрғыдан дұрыс

import edu.narxoz.galactic.bodies.*;
import edu.narxoz.galactic.cargo.Cargo;
import edu.narxoz.galactic.dispatcher.*;
import edu.narxoz.galactic.drones.*;
import edu.narxoz.galactic.task.*;

public class Demo {
    public static void main(String[] args) {
        Planet earth = new Planet("Earth", 0, 0, "Nitrogen/Oxygen"); [cite: 86]
        SpaceStation moonBase = new SpaceStation("Moon Base Alpha", 300, 400, 1); [cite: 96]
        
        Cargo heavyCargo = new Cargo(500.0, "Mining Equipment"); [cite: 151]
        DeliveryTask task = new DeliveryTask(earth, moonBase, heavyCargo); [cite: 173]
        
        Dispatcher dispatcher = new Dispatcher(); [cite: 203]

        Drone lightDrone = new LightDrone("L-001", 100.0); [cite: 132]
        Result failResult = dispatcher.assignTask(task, lightDrone); [cite: 203, 205]
        System.out.println("1. Assignment to LightDrone (Expected Failure): " + failResult.ok() + 
                           " | Reason: " + failResult.reason()); [cite: 203, 206]

        Drone heavyDrone = new HeavyDrone("H-999", 1000.0); [cite: 141]
        Result successResult = dispatcher.assignTask(task, heavyDrone); [cite: 205]
        System.out.println("2. Assignment to HeavyDrone (Expected Success): " + successResult.ok()); [cite: 206]


        System.out.println("3. Estimated Time: " + task.estimateTime() + " minutes"); [cite: 206]

        Result completeResult = dispatcher.completeTask(task); [cite: 205]
        System.out.println("4. Completion Status: " + completeResult.ok()); [cite: 206]
        System.out.println("Final Drone Status: " + heavyDrone.getStatus()); [cite: 56, 206]
        System.out.println("Final Task State: " + task.getState()); [cite: 55, 206]
    }
}