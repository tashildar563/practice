package org.example.parkingLot;

import java.util.ArrayList;
import java.util.List;

public class User {

  String name;
  String id;
  List<Vehicle> vehiclesParked = new ArrayList<>();

  public User(String name, Vehicle v) {
    this.name = name;
    boolean present = false;
    for (Vehicle vehicle : vehiclesParked) {
      if (!vehicle.getNumber().equals(v.getNumber())) {
        present = true;
      }
    }
    if (!present) {
      this.vehiclesParked.add(v);
    }
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public boolean addVehicle(Vehicle veh) {
    return vehiclesParked.add(veh);
  }
}
