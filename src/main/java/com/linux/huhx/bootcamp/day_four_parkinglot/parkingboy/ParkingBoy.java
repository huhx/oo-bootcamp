package com.linux.huhx.bootcamp.day_four_parkinglot.parkingboy;

import com.linux.huhx.bootcamp.day_four_parkinglot.Car;
import com.linux.huhx.bootcamp.day_four_parkinglot.ParkAble;
import com.linux.huhx.bootcamp.day_four_parkinglot.ParkingLot;
import com.linux.huhx.bootcamp.day_four_parkinglot.Ticket;
import com.linux.huhx.bootcamp.day_four_parkinglot.exception.InvalidTicketException;
import com.linux.huhx.bootcamp.day_four_parkinglot.exception.NoTicketException;
import java.util.List;
import java.util.Objects;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class ParkingBoy implements ParkAble {

  protected List<ParkingLot> parkingLots;

  @Override
  public Car pickupCar(Ticket ticket) {
    if (Objects.isNull(ticket)) {
      throw new NoTicketException();
    }
    ParkingLot parkingLot = parkingLots.stream()
        .filter(item -> item.getLotNumber().equals(ticket.getLotNumber()))
        .findAny()
        .orElseThrow(InvalidTicketException::new);
    return parkingLot.pickupCar(ticket);
  }

  public boolean hasSpace() {
    return parkingLots.stream().anyMatch(parkingLot -> parkingLot.hasSpace());
  }

  @Override
  public boolean hasCarParked(Ticket ticket) {
    return parkingLots.stream()
        .anyMatch(parkingLot -> parkingLot.getLotNumber().equals(ticket.getLotNumber()));
  }
}
