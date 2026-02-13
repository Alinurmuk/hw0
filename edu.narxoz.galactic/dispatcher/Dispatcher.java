package edu.narxoz.galactic.dispatcher;

import edu.narxoz.galactic.drones.Drone;
import edu.narxoz.galactic.drones.DroneStatus;
import edu.narxoz.galactic.task.DeliveryTask;
import edu.narxoz.galactic.task.TaskState;

public class Dispatcher {
    public Result assignTask(DeliveryTask task, Drone drone) {
        if (task == null || drone == null) return new Result(false, "Null input");
        if (task.getState() != TaskState.CREATED) return new Result(false, "Not CREATED");
        if (drone.getStatus() != DroneStatus.IDLE) return new Result(false, "Not IDLE");
        if (task.getCargo().getWeightKg() > drone.getMaxPayloadKg()) return new Result(false, "Overweight");

        task.setAssignedDrone(drone);
        task.setState(TaskState.ASSIGNED);
        drone.setStatus(DroneStatus.IN_FLIGHT);
        return new Result(true, null);
    }

    public Result completeTask(DeliveryTask task) {
        if (task == null || task.getState() != TaskState.ASSIGNED || task.getAssignedDrone() == null) {
            return new Result(false, "Invalid state");
        }
        if (task.getAssignedDrone().getStatus() != DroneStatus.IN_FLIGHT) {
            return new Result(false, "Drone not in flight");
        }

        task.setState(TaskState.DONE);
        task.getAssignedDrone().setStatus(DroneStatus.IDLE);
        return new Result(true, null);
    }
}