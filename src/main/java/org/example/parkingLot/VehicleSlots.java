package org.example.parkingLot;

public class VehicleSlots {
  private Integer slotNo;
  private String slot;
  private Vehicle vehicle;

  public String getSlot() {
    return slot;
  }

  public void setSlot(String slot) {
    this.slot = slot;
  }

  public Vehicle getVehicle() {
    return vehicle;
  }

  public void setVehicle(Vehicle vehicle) {
    this.vehicle = vehicle;
  }

  public Integer getSlotNo() {
    return slotNo;
  }

  public void setSlotNo(Integer slotNo) {
    this.slotNo = slotNo;
  }
}
