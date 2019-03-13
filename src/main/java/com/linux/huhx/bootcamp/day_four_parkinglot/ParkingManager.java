package com.linux.huhx.bootcamp.day_four_parkinglot;

import java.util.List;

public class ParkingManager {

  private List<ParkingBoy> parkingBoys;

  public ParkingManager(List<ParkingBoy> parkingBoys) {
    this.parkingBoys = parkingBoys;
  }

  public Ticket parkCar(Car car) {
   return new Ticket("1","1");
  }
}
