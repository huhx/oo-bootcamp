package com.linux.huhx.bootcamp.day_four_parkinglot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ParkingManagerTest {

  private Car car;

  @BeforeEach
  public void setUp() {
    car = new Car("京A168888");
  }

  @Test
  public void should_return_ticket_when_parking_given_parking_manager_have_parking_boys_and_have_available_lot() {
    SmartParkingBoy smartParkingBoy = new SmartParkingBoy(asList(
        new ParkingLot(4, "b"),
        new ParkingLot(5, "a")));
    ParkingManager parkingManager = new ParkingManager(asList(smartParkingBoy));

    Ticket ticket = parkingManager.parkCar(car);

    assertNotNull(ticket);
  }
}