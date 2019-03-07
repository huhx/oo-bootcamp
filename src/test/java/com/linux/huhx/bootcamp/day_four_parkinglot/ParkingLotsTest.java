package com.linux.huhx.bootcamp.day_four_parkinglot;

import org.junit.Assert;
import org.junit.Test;

public class ParkingLotsTest {

  @Test
  public void should_return_ticket_when_parking_lots_has_space_give_cars_coming() {
    String ticket = new ParkingLots(1).parkCar(new Car());

    Assert.assertNotNull(ticket);
  }

  @Test
  public void should_return_ticket_when_parking_lots_has_no_space_give_cars_coming() {
    String ticket = new ParkingLots(0).parkCar(new Car());

    Assert.assertNull(ticket);
  }

  @Test
  public void should_pick_up_success_when_customer_pick_up_car_given_valid_ticket() {
    ParkingLots parkingLots = new ParkingLots();
    Car car = new Car();
    parkingLots.parkCar(car);

    Car actual = parkingLots.pickUpCar("ticket");

    Assert.assertEquals(car, actual);
  }

  @Test
  public void should_pick_up_fail_when_customer_pick_up_car_given_invalid_ticket() {
    ParkingLots parkingLots = new ParkingLots();
    parkingLots.parkCar(new Car());

    Car actual = parkingLots.pickUpCar("invalid");

    Assert.assertNull(actual);
  }
}
