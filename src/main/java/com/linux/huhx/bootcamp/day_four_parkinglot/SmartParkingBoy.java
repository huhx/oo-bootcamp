package com.linux.huhx.bootcamp.day_four_parkinglot;

import com.linux.huhx.bootcamp.day_four_parkinglot.exception.NoAvailableSpaceException;
import java.util.Comparator;
import java.util.List;

public class SmartParkingBoy extends ParkingBoy {

  public SmartParkingBoy(List<ParkingLot> parkingLots) {
    super(parkingLots);
  }

  @Override
  public Ticket parkCar(Car car) {
    ParkingLot parkingLot = parkingLots.stream()
        .filter(item -> item.hasSpace())
        .max(Comparator.comparingInt(ParkingLot::getRemainSpace))
        .orElseThrow(NoAvailableSpaceException::new);
    return parkingLot.parkCar(car);
  }
}
