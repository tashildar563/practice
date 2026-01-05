package org.example.parkingLot;

import java.util.Scanner;
import org.example.Solution;

public class ParkingStationManagement implements Solution {

  @Override
  public void logic() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Create Parking station Enter 1 : ");
    System.out.println("Add Vehicle Enter 2 : ");
    int operation = sc.nextInt();
    ParkingStation parkingStation ;
    switch (operation){
      case 1:
        System.out.println("How many floor: ");
        int floor = sc.nextInt();
        System.out.println("How many slots per floor: ");
        int slotsPerFloor = sc.nextInt();
        System.out.println("How many small slots to create: ");
        int smallSlots = sc.nextInt();
        System.out.println("How many medium slots to create: ");
        int mediumSlots = sc.nextInt();
        System.out.println("How many heavy vehicle slots to create: ");
        int heavySlots = sc.nextInt();
        parkingStation = new ParkingStation(floor,slotsPerFloor,smallSlots,mediumSlots,heavySlots);
        break;
      case 2:
        parkVehicle(sc);
        break;
      default:
        System.out.print("Thank you");
    }
  }

  private void parkVehicle(Scanner sc) {
    System.out.println("Provide the vehicle Number : ");
    String number = sc.nextLine();
    System.out.println("Select the vehicle : 1. Bike, 2. Car, 3. Truck");
    int vehicle = sc.nextInt();
    String vehicleType = "Truck";
    if(vehicle==1){
      vehicleType = "Bike";
    }else{
      vehicleType = "Car";
    }

  }

  @Override
  public String description() {
    return "";
  }

  @Override
  public String problemStatement() {
    return "";
  }
}
