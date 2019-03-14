package com.linux.huhx.bootcamp.day_four_parkinglot;

import com.linux.huhx.bootcamp.day_four_parkinglot.exception.InvalidTicketException;
import com.linux.huhx.bootcamp.day_four_parkinglot.exception.NoAvailableSpaceException;
import com.linux.huhx.bootcamp.day_four_parkinglot.exception.NoTicketException;
import com.linux.huhx.bootcamp.day_four_parkinglot.parkingboy.ParkingBoy;
import com.linux.huhx.bootcamp.day_four_parkinglot.parkingboy.SmartParkingBoy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SmartParkingBoyTest {

  private ParkingBoy smartParkingBoy;
  private Car car;

  @BeforeEach
  public void setUp() {
    car = new Car("京A168888");
    smartParkingBoy = new SmartParkingBoy(asList(
        new ParkingLot(4, "b"),
        new ParkingLot(5, "a")
    ));
  }

  @Test
  public void should_return_ticket_with_parking_lot_number_is_a_when_parking_given_parking_lots_a_with_5_available_space_and_parking_lots_b_with_4_available_space() {
    Ticket ticket = smartParkingBoy.parkCar(car);

    assertNotNull(ticket);
    assertEquals("a", ticket.getLotNumber());
  }

  @Test
  public void should_return_ticket_with_parking_lot_number_is_any_when_parking_given_parking_lots_a_with_4_available_space_and_parking_lots_b_with_4_available_space() {
    smartParkingBoy = new SmartParkingBoy(asList(
        new ParkingLot(4, "b"),
        new ParkingLot(4, "a")
    ));
    Ticket ticket = smartParkingBoy.parkCar(car);

    assertNotNull(ticket);
    assertEquals("b", ticket.getLotNumber());
  }

  @Test
  public void should_throw_no_available_exception_when_parking_given_parking_lots_has_no_available_space() {
    smartParkingBoy = new SmartParkingBoy(asList(
        new ParkingLot(1, "b"),
        new ParkingLot(1, "a")
    ));
    smartParkingBoy.parkCar(new Car("AAAA"));
    smartParkingBoy.parkCar(new Car("BBBB"));

    assertThrows(NoAvailableSpaceException.class, () -> smartParkingBoy.parkCar(car));
  }

  @Test
  public void should_return_car_when_pick_up_car_given_valid_ticket() {
    Ticket ticket = smartParkingBoy.parkCar(car);

    assertEquals(car, smartParkingBoy.pickupCar(ticket));
  }

  @Test
  public void should_throw_invalid_ticket_exception_when_pick_up_car_given_invalid_ticket() {
    smartParkingBoy.parkCar(car);

    assertThrows(InvalidTicketException.class, () -> smartParkingBoy.pickupCar(new Ticket("123", "123")));
  }

  @Test
  public void should_throw_no_ticket_exception_when_customer_pick_up_car_given_no_ticket() {
    smartParkingBoy.parkCar(car);

    assertThrows(NoTicketException.class, () -> smartParkingBoy.pickupCar(null));
  }
}