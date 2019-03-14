package com.linux.huhx.bootcamp.day_four_parkinglot;

import com.linux.huhx.bootcamp.day_four_parkinglot.exception.InvalidTicketException;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

@Getter
public class ParkingLot implements ParkAble {

  private String lotNumber;
  private int capacity;
  private List<Car> carList = new ArrayList<>();

  public ParkingLot(int capacity, String lotNumber) {
    this.capacity = capacity;
    this.lotNumber = lotNumber;
  }

  @Override
  public Ticket parkCar(Car car) {
    if (!hasSpace()) {
      return null;
    }
    Ticket ticket = new Ticket(lotNumber, car.getPlate());
    carList.add(car);
    return ticket;
  }

  @Override
  public Car pickupCar(Ticket ticket) {
    Car car = carList.stream()
        .filter(item -> item.getPlate().equals(ticket.getTicketNumber()))
        .findAny().orElseThrow(InvalidTicketException::new);
    carList.remove(car);
    return car;
  }

  @Override
  public boolean hasSpace() {
    return getRemainSpace() > 0;
  }

  @Override
  public boolean hasCarParked(Ticket ticket) {
    return lotNumber.equals(ticket.getLotNumber());
  }

  public int getRemainSpace() {
    return capacity - carList.size();
  }

  public double getRemainSpaceRate() {
    return getRemainSpace() / (double) capacity;
  }
}
