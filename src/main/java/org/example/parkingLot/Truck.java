package org.example.parkingLot;

import java.time.LocalDateTime;

public class Truck implements Vehicle{
  public final static String size = "HEAVY";
  String number;
  String userId;
  LocalDateTime parkedInAt;

  public Truck(String number, LocalDateTime now) {
    this.number = number;
    this.parkedInAt = now;
  }
  @Override
  public String getNumber() {
    return number;
  }

  @Override
  public String getSlotSize() {
    return size;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public LocalDateTime getParkedInAt() {
    return parkedInAt;
  }

  public void setParkedInAt(LocalDateTime parkedInAt) {
    this.parkedInAt = parkedInAt;
  }
}
