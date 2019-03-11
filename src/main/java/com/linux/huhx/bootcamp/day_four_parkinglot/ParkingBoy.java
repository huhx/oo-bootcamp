package com.linux.huhx.bootcamp.day_four_parkinglot;

import com.linux.huhx.bootcamp.day_four_parkinglot.exception.InvalidTicketException;
import com.linux.huhx.bootcamp.day_four_parkinglot.exception.NoTicketException;
import java.util.List;
import java.util.Objects;

public abstract class ParkingBoy {

  public ParkingBoy(List<ParkingLot> parkingLots) {
    this.parkingLots = parkingLots;
  }

  public Car pickupCar(Ticket ticket) {
    if (Objects.isNull(ticket)) {
      throw new NoTicketException();
    }
    ParkingLot parkingLot = parkingLots.stream()
        .filter(item -> item.getLotNumber().equals(ticket.getParkingLotNumber()))
        .findAny()
        .orElseThrow(InvalidTicketException::new);
    return parkingLot.pickUpCar(ticket);
  }

  protected List<ParkingLot> parkingLots;

  public abstract Ticket parkCar(Car car);
}
