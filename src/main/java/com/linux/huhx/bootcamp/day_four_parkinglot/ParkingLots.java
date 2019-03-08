package com.linux.huhx.bootcamp.day_four_parkinglot;

import java.util.HashMap;
import java.util.Map;
import lombok.Getter;

@Getter
public class ParkingLots {

  public static final int DEFAULT_CAPACITY = 16;
  private int capacity;
  private Map<String, Car> parkingMap = new HashMap<>();

  public ParkingLots() {
    this.capacity = DEFAULT_CAPACITY;
  }

  public ParkingLots(int capacity) {
    this.capacity = capacity;
  }

  public String parkCar(Car car) {
    if (!hasSpace()) {
      return null;
    }
    String plate = car.getPlate();
    parkingMap.put(plate, car);
    return plate;
  }

  public Car pickUpCar(String ticket) {
    return parkingMap.remove(ticket);
  }

  private boolean hasSpace() {
    return parkingMap.size() < capacity;
  }
}
