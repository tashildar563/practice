package org.example.parkingLot;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ParkingStation {
  Integer slotRegistered=0;
  /*
  * driver can be with multiple vehicles
  * vehicle -> small, medium, heavy
  * slots - > small, meducm, heavy
  * Parking floor ->
  * Parking Station -> with multiple parking floor
  *
  * Parking charges -> small=x*h, mediem=2x*h, heavy=3x*h
  *
  *
  * Parking mgmt ->
  * get vacant slots for parking based on vehicle size
  * allocate slot to vehicle
  * vacant slot allocated to vehicle
  * add the slots
  * remove the slots
  * */
  List<ParkingFloor> parkingFloorList = new ArrayList<>();
  public ParkingStation(Integer floorCount,Integer slotsPerFloor,Integer smallSlots,Integer mediumSlot, Integer heavySlots){
    this.createParkingFloor( floorCount, slotsPerFloor, smallSlots, mediumSlot,  heavySlots);
  }

  public List<ParkingFloor> createParkingFloor(Integer floorCount,Integer slotsPerFloor,Integer smallSlots,Integer mediumSlot, Integer heavySlots){
    List<VehicleSlots> smallVehicleSlots = new ArrayList<>();
    List<VehicleSlots> mediumVehicleSlots = new ArrayList<>();
    List<VehicleSlots> heavyVehicleSlots = new ArrayList<>();

    addSlot(smallSlots,"SMALL",null,smallVehicleSlots);
    addSlot(mediumSlot,"MEDIUM",null,mediumVehicleSlots);
    addSlot(heavySlots,"HEAVY",null,heavyVehicleSlots);

    while(floorCount>0){
      ParkingFloor parkingFloor = new ParkingFloor();
      parkingFloor.setSlotLimit(slotsPerFloor);
      smallVehicleSlots = parkingFloor.addVehicleSlots(smallVehicleSlots,"SMALL");
      mediumVehicleSlots = parkingFloor.addVehicleSlots(mediumVehicleSlots,"MEDIUM");
      heavyVehicleSlots = parkingFloor.addVehicleSlots(heavyVehicleSlots,"HEAVY");
      parkingFloorList.add(parkingFloor);
    }


    return parkingFloorList;
  }

  private void addSlot(Integer slotCount,String slotSize,Vehicle vehicle,List<VehicleSlots> list ) {
    while(slotCount >0){
      slotRegistered++;
      VehicleSlots slot = new VehicleSlots();
      slot.setSlot("SMALL");
      slot.setSlotNo(slotRegistered);
      slot.setVehicle(null);
      list.add(slot);
      slotCount--;
    }
  }

  public boolean addVehicle(String number, String vehicle, LocalDateTime localDateTime,String name){
    Vehicle v = creareVehicle(number,vehicle);
    User u = new User(name,v);
    Integer slot = 0;
    boolean parked = false;
    for(ParkingFloor parkingFloor : parkingFloorList){
      slot = parkingFloor.assignVehicleSlotToVehicle(v);
      if(slot!=0){
        parked = true;
        break;
      }
    }
    System.out.println("Vehicle :"+number+" parked in slot number "+slot);
    return parked;
  }

  private Vehicle creareVehicle(String number, String vehicle) {
    if(vehicle.equals("Bike")){
      return new Bike(number, LocalDateTime.now());
    }else if(vehicle.equals("Car")){
      return new Car(number, LocalDateTime.now());
    }else{
      return new Truck(number, LocalDateTime.now());
    }
  }

}
