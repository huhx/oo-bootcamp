package com.linux.huhx.bootcamp.day_four_parkinglot;

import com.linux.huhx.bootcamp.day_four_parkinglot.exception.InvalidTicketException;
import com.linux.huhx.bootcamp.day_four_parkinglot.exception.NoTicketException;
import java.util.List;
import java.util.Objects;

public abstract class ParkingBoy implements ParkAble {

  public ParkingBoy(List<ParkingLot> parkingLots) {
    this.parkingLots = parkingLots;
  }

  @Override
  public Car pickupCar(Ticket ticket) {
    if (Objects.isNull(ticket)) {
      throw new NoTicketException();
    }
    ParkingLot parkingLot = parkingLots.stream()
        .filter(item -> item.getLotNumber().equals(ticket.getParkingLotNumber()))
        .findAny()
        .orElseThrow(InvalidTicketException::new);
    return parkingLot.pickupCar(ticket);
  }

  protected List<ParkingLot> parkingLots;

  public boolean existRemainParkingLot() {
    return parkingLots.stream().filter(parkingLot -> parkingLot.hasSpace()).count() > 0;
  }

  @Override
  public boolean isPark(Ticket ticket) {
    return parkingLots.stream().anyMatch(parkingLot -> parkingLot.getLotNumber().equals(ticket.getParkingLotNumber()));
  }
}
