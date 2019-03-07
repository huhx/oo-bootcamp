package com.linux.huhx.bootcamp.day_four_parkinglot;

import java.util.HashMap;
import java.util.Map;
import lombok.Getter;

@Getter
public class ParkingLots {

  public static final int DEFAULT_CAPACITY = 16;
  private int size;
  private Map<String, Car> spaces = new HashMap<>();

  public ParkingLots() {
    this.size = DEFAULT_CAPACITY;
  }

  public ParkingLots(int size) {
    this.size = size;
  }

  public boolean hasSpace() {
    return spaces.size() < size;
  }

  public String parkCar(Car car) {
    if (!hasSpace()) {
      return null;
    }
    String plate = car.getPlate();
    spaces.put(plate, car);
    return plate;
  }

  public Car pickUpCar(String ticket) {
    return spaces.get(ticket);
  }
}
