package com.linux.huhx.bootcamp.day_four_parkinglot.parkingboy;

import com.linux.huhx.bootcamp.day_four_parkinglot.Car;
import com.linux.huhx.bootcamp.day_four_parkinglot.ParkAble;
import com.linux.huhx.bootcamp.day_four_parkinglot.Ticket;
import com.linux.huhx.bootcamp.day_four_parkinglot.exception.InvalidTicketException;
import com.linux.huhx.bootcamp.day_four_parkinglot.exception.NoAvailableSpaceException;
import com.linux.huhx.bootcamp.day_four_parkinglot.exception.NoTicketException;
import java.util.List;
import java.util.Objects;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ParkingManager {

  private List<ParkAble> parkAbles;

  public Ticket parkCar(Car car) {
    ParkAble parkable = parkAbles.stream()
        .filter(item -> item.hasSpace())
        .findAny()
        .orElseThrow(NoAvailableSpaceException::new);
    return parkable.parkCar(car);
  }

  public Car pickupCar(Ticket ticket) {
    if (Objects.isNull(ticket)) {
      throw new NoTicketException();
    }
    ParkAble parkAble = parkAbles.stream()
        .filter(item -> item.hasCarParked(ticket))
        .findAny()
        .orElseThrow(InvalidTicketException::new);
    return parkAble.pickupCar(ticket);
  }
}
