package com.linux.huhx.bootcamp.day_four_parkinglot;

import com.linux.huhx.bootcamp.day_four_parkinglot.exception.InvalidTicketException;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

@Getter
public class ParkingLot {

  private String lotNumber;
  private int capacity;
  private List<Car> carList = new ArrayList<>();

  public ParkingLot(int capacity, String lotNumber) {
    this.capacity = capacity;
    this.lotNumber = lotNumber;
  }

  public Ticket parkCar(Car car) {
    if (!hasSpace()) {
      return null;
    }
    Ticket ticket = new Ticket(lotNumber, car.getPlate());
    carList.add(car);
    return ticket;
  }

  public Car pickUpCar(Ticket ticket) {
    Car car = carList.stream()
        .filter(item -> item.getPlate().equals(ticket.getTicketNumber()))
        .findAny().orElseThrow(InvalidTicketException::new);
    carList.remove(car);
    return car;
  }

  public boolean hasSpace() {
    return carList.size() < capacity;
  }

  public int getRemainSpace() {
    return capacity - carList.size();
  }

  public double getRemainSpaceRate() {
    return getRemainSpace() / capacity;
  }
}
