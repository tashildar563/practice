package org.example.parkingLot;

import java.time.LocalDateTime;

public class Bike implements Vehicle{
  String number;
  String userId;
  LocalDateTime parkedInAt;

  public Bike(String number, LocalDateTime now) {
    this.number = number;
    this.parkedInAt = now;
  }
  @Override
  public String getNumber() {
    return number;
  }

  @Override
  public String getSlotSize() {
    return "SMALL";
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
