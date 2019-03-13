package com.linux.huhx.bootcamp.day_four_parkinglot;

import com.linux.huhx.bootcamp.day_four_parkinglot.exception.InvalidTicketException;
import com.linux.huhx.bootcamp.day_four_parkinglot.exception.NoAvailableSpaceException;
import com.linux.huhx.bootcamp.day_four_parkinglot.exception.NoTicketException;
import java.util.List;
import java.util.Objects;

public class ParkingManager {

  private List<ParkAble> parkAbles;

  public ParkingManager(List<ParkAble> parkAbles) {
    this.parkAbles = parkAbles;
  }

  public Ticket parkCar(Car car) {
    ParkAble parkable = parkAbles.stream()
        .filter(item -> item.existRemainParkingLot())
        .findAny().orElseThrow(NoAvailableSpaceException::new);
    return parkable.parkCar(car);
  }

  public Car pickupCar(Ticket ticket) {
    if (Objects.isNull(ticket)) {
      throw new NoTicketException();
    }
    ParkAble parkAble = parkAbles.stream()
        .filter(item -> item.isPark(ticket))
        .findAny()
        .orElseThrow(InvalidTicketException::new);
    return parkAble.pickupCar(ticket);
  }
}
