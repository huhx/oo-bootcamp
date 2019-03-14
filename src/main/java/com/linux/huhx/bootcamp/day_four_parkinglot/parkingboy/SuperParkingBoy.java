package com.linux.huhx.bootcamp.day_four_parkinglot.parkingboy;

import com.linux.huhx.bootcamp.day_four_parkinglot.Car;
import com.linux.huhx.bootcamp.day_four_parkinglot.ParkingLot;
import com.linux.huhx.bootcamp.day_four_parkinglot.Ticket;
import com.linux.huhx.bootcamp.day_four_parkinglot.exception.NoAvailableSpaceException;
import java.util.Comparator;
import java.util.List;

public class SuperParkingBoy extends ParkingBoy {

  public SuperParkingBoy(List<ParkingLot> parkingLots) {
    super(parkingLots);
  }

  @Override
  public Ticket parkCar(Car car) {
    ParkingLot parkingLot = parkingLots.stream()
        .filter(item -> item.hasSpace())
        .max(Comparator.comparingDouble(ParkingLot::getRemainSpaceRate))
        .orElseThrow(NoAvailableSpaceException::new);
    return parkingLot.parkCar(car);
  }
}
