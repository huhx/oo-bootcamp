package com.linux.huhx.bootcamp.day_four_parkinglot;

import com.linux.huhx.bootcamp.day_four_parkinglot.exception.InvalidTicketException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ParkingLotTest {

  private Car car;

  @BeforeEach
  public void setUp() {
    car = new Car("京A168888");
  }

  @Test
  public void should_return_ticket_when_parking_lots_has_space_give_cars_coming() {
    Ticket ticket = new ParkingLot(1, "number").parkCar(car);

    assertNotNull(ticket);
  }

  @Test
  public void should_return_ticket_when_parking_lots_has_no_space_given_cars_coming() {
    Ticket ticket = new ParkingLot(0, "number").parkCar(car);

    assertNull(ticket);
  }

  @Test
  public void should_pick_up_success_when_customer_pick_up_car_given_valid_ticket() {
    ParkingLot parkingLot = new ParkingLot(16, "number");
    Ticket ticket = parkingLot.parkCar(car);

    Car actual = parkingLot.pickupCar(ticket);

    assertEquals(car, actual);
  }

  @Test
  public void should_throw_exception_when_customer_pick_up_car_given_invalid_ticket() {
    ParkingLot parkingLot = new ParkingLot(16, "number");
    parkingLot.parkCar(car);

    assertThrows(InvalidTicketException.class,
        () -> parkingLot.pickupCar(new Ticket("number", "invalid")));
  }

  @Test
  public void should_pick_up_correct_card_when_multiple_customer_pick_up_car_given_invalid_tickets() {
    ParkingLot parkingLot = new ParkingLot(16, "number");
    Car redCar = car;
    Car whiteCar = new Car("甲A026");
    Ticket redCarTicket = parkingLot.parkCar(redCar);
    Ticket whiteCarTicket = parkingLot.parkCar(whiteCar);

    Car redActual = parkingLot.pickupCar(redCarTicket);
    Car whiteActual = parkingLot.pickupCar(whiteCarTicket);

    assertEquals(redCar, redActual);
    assertEquals(whiteCar, whiteActual);
  }
}
