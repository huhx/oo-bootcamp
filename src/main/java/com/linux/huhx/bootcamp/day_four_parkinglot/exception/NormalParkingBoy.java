package com.linux.huhx.bootcamp.day_four_parkinglot.exception;

import com.linux.huhx.bootcamp.day_four_parkinglot.Car;
import com.linux.huhx.bootcamp.day_four_parkinglot.ParkingBoy;
import com.linux.huhx.bootcamp.day_four_parkinglot.ParkingLot;
import com.linux.huhx.bootcamp.day_four_parkinglot.Ticket;
import java.util.List;

public class NormalParkingBoy extends ParkingBoy {

  public NormalParkingBoy(List<ParkingLot> parkingLots) {
    super(parkingLots);
  }

  @Override
  public Ticket parkCar(Car car) {
    ParkingLot parkingLot = parkingLots.stream()
        .filter(item -> item.hasSpace())
        .findAny()
        .orElseThrow(NoAvailableSpaceException::new);
    return parkingLot.parkCar(car);
  }
}
