package org.example.parkingLot;

import java.util.ArrayList;
import java.util.List;

public class ParkingFloor {
    List<VehicleSlots> vehicleSlots = new ArrayList<>();
    Integer slotLimit;
    public final static Double smallSlotPerc = 0.6;
    public final static Double mediumSlotPerc = 0.2;
    public final static Double heavySlotPerc = 0.2;

    public List<VehicleSlots> addVehicleSlots(List<VehicleSlots> vehicleSlot,String size){
      if(vehicleSlot == null || vehicleSlot.isEmpty()){
        return new ArrayList<>();
      }
      double perc = 0;
      List<VehicleSlots> subList = new ArrayList<>();
      if(size.equals("SMALL")){
        perc = smallSlotPerc;
      }else if(size.equals("MEDIUM")){
        perc = mediumSlotPerc;
      }else{
        perc = heavySlotPerc;
      }
      int percentCount = (int) Math.ceil(this.slotLimit * perc); // 10%
      subList = vehicleSlot.subList(0, percentCount);
      vehicleSlots.addAll(subList);
      vehicleSlot.removeAll(subList);
      return vehicleSlot;
    }

  public void setSlotLimit(Integer slotLimit) {
    this.slotLimit = slotLimit;
  }

  public List<VehicleSlots> getVacantVehicleSlots(){
      List<VehicleSlots> vacantslots = new ArrayList<>();
      for(VehicleSlots slot : vehicleSlots){
        if(slot.getVehicle() == null){
          vacantslots.add(slot);
        }
      }
      return vacantslots;
    }

    public Integer getVacantSlotscount(){
      Integer slotscount = 0;
      for(VehicleSlots slot : vehicleSlots){
        if(slot.getVehicle() == null){
          slotscount++;
        }
      }
      return slotscount;
    }
  public Integer getOccupiedSlotscount(){
    Integer slotscount = 0;
    for(VehicleSlots slot : vehicleSlots){
      if(slot.getVehicle() != null){
        slotscount++;
      }
    }
    return slotscount;
  }

  public Integer getSlotCount(){
      return vehicleSlots.size();
  }

  public Integer assignVehicleSlotToVehicle(Vehicle v) {
      Integer slotNumber = 0;
      for(VehicleSlots vehicleSlots1 : vehicleSlots){
        if(vehicleSlots1.getSlot().equals(v.getSlotSize()) && vehicleSlots1.getVehicle()==null){
          vehicleSlots1.setVehicle(v);
          slotNumber = vehicleSlots1.getSlotNo();
        }
      }
      return slotNumber;
  }
}
