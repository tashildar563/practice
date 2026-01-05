package org.example.parkingLot;

import java.time.LocalDateTime;

public class Car implements Vehicle{
  String number;
  String userId;
  LocalDateTime parkedInAt;
  public final static String size = "MEDIUM";

  public Car(String number, LocalDateTime localDateTime) {
    this.number = number;
    this.parkedInAt = parkedInAt;
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
