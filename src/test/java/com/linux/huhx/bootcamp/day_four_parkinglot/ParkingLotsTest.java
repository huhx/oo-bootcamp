package com.linux.huhx.bootcamp.day_four_parkinglot;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ParkingLotsTest {

  private Car car;

  @Before
  public void setUp() {
    car = new Car("京A168888", "222", "white");
  }

  @Test
  public void should_return_ticket_when_parking_lots_has_space_give_cars_coming() {
    ParkingLots parkingLots = new ParkingLots(1);
    String ticket = parkingLots.parkCar(car);

    Assert.assertNotNull(ticket);
  }

  @Test
  public void should_return_ticket_when_parking_lots_has_no_space_given_cars_coming() {
    String ticket = new ParkingLots(0).parkCar(car);

    Assert.assertNull(ticket);
  }

  @Test
  public void should_pick_up_success_when_customer_pick_up_car_given_valid_ticket() {
    ParkingLots parkingLots = new ParkingLots();
    String ticket = parkingLots.parkCar(car);

    Car actual = parkingLots.pickUpCar(ticket);

    Assert.assertEquals(car, actual);
  }

  @Test
  public void should_pick_up_fail_when_customer_pick_up_car_given_invalid_ticket() {
    ParkingLots parkingLots = new ParkingLots();
    parkingLots.parkCar(car);

    Car actual = parkingLots.pickUpCar("invalid ticket");

    Assert.assertNull(actual);
  }

  @Test
  public void should_pick_up_correct_card_when_multiple_customer_pick_up_car_given_invalid_tickets() {
    ParkingLots parkingLots = new ParkingLots();
    Car redCar = car;
    Car whiteCar = new Car("甲A026", "222", "white");
    String redCarTicket = parkingLots.parkCar(redCar);
    String whiteCarTicket = parkingLots.parkCar(whiteCar);

    Car redActual = parkingLots.pickUpCar(redCarTicket);
    Car whiteActual = parkingLots.pickUpCar(whiteCarTicket);

    Assert.assertEquals(redCar, redActual);
    Assert.assertEquals(whiteCar, whiteActual);
  }
}
