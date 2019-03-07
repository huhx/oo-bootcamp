package com.linux.huhx.bootcamp.day_four_parkinglot;

import org.junit.Assert;
import org.junit.Test;

public class ParkingLotsTest {


  @Test
  public void should_return_ticket_when_parking_lots_has_space_give_cars_coming() {
    String ticket = new ParkingLots().parkCar(new Car());

    Assert.assertNotNull(ticket);
  }
}
