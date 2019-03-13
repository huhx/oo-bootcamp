package com.linux.huhx.bootcamp.day_four_parkinglot;

public interface ParkAble {

  Ticket parkCar(Car car);

  Car pickupCar(Ticket ticket);

  boolean existRemainParkingLot();

  boolean isPark(Ticket ticket);
}
