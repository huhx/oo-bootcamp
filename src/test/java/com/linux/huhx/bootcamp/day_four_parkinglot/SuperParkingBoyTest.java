package com.linux.huhx.bootcamp.day_four_parkinglot;

import com.linux.huhx.bootcamp.day_four_parkinglot.exception.InvalidTicketException;
import com.linux.huhx.bootcamp.day_four_parkinglot.exception.NoAvailableSpaceException;
import com.linux.huhx.bootcamp.day_four_parkinglot.exception.NoTicketException;
import com.linux.huhx.bootcamp.day_four_parkinglot.parkingboy.ParkingBoy;
import com.linux.huhx.bootcamp.day_four_parkinglot.parkingboy.SmartParkingBoy;
import com.linux.huhx.bootcamp.day_four_parkinglot.parkingboy.SuperParkingBoy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SuperParkingBoyTest {

  private ParkingBoy superParkingBoy;
  private Car car;

  @BeforeEach
  public void setUp() {
    superParkingBoy = new SuperParkingBoy(asList(
        new ParkingLot(4, "b"),
        new ParkingLot(5, "a")
    ));
    car = new Car("京A168888");
  }

  @Test
  public void should_return_ticket_with_parking_lot_number_is_b_when_parking_given_a_has_3_lots_with_2_available_and_b_has_3_lots_with_1_available() {
    ParkingLot parkingLotA = new ParkingLot(3, "a");
    parkingLotA.parkCar(new Car("1"));
    ParkingLot parkingLotB = new ParkingLot(3, "b");
    parkingLotB.parkCar(new Car("2"));
    parkingLotB.parkCar(new Car("3"));

    superParkingBoy = new SuperParkingBoy(asList(
        parkingLotA,
        parkingLotB
    ));
    Ticket ticket = superParkingBoy.parkCar(car);

    assertNotNull(ticket);
    assertEquals("a", ticket.getLotNumber());
  }

  @Test
  public void should_return_ticket_with_parking_lot_number_is_a_when_parking_given_a_has_3_lots_with_2_available_and_b_has_3_lots_with_2_available() {
    ParkingLot parkingLotA = new ParkingLot(3, "a");
    parkingLotA.parkCar(new Car("1"));
    ParkingLot parkingLotB = new ParkingLot(3, "b");
    parkingLotB.parkCar(new Car("2"));

    superParkingBoy = new SuperParkingBoy(asList(
        parkingLotA,
        parkingLotB
    ));
    Ticket ticket = superParkingBoy.parkCar(car);

    assertNotNull(ticket);
    assertEquals("a", ticket.getLotNumber());
  }

  @Test
  public void should_throw_no_available_exception_when_parking_given_parking_lots_has_no_available_space() {
    superParkingBoy = new SmartParkingBoy(asList(
        new ParkingLot(1, "b"),
        new ParkingLot(1, "a")
    ));
    superParkingBoy.parkCar(new Car("AAAA"));
    superParkingBoy.parkCar(new Car("BBBB"));

    assertThrows(NoAvailableSpaceException.class, () -> superParkingBoy.parkCar(car));
  }

  @Test
  public void should_return_car_when_pick_up_car_given_valid_ticket() {
    Ticket ticket = superParkingBoy.parkCar(car);

    assertEquals(car, superParkingBoy.pickupCar(ticket));
  }

  @Test
  public void should_throw_invalid_ticket_exception_when_pick_up_car_given_invalid_ticket() {
    superParkingBoy.parkCar(car);

    assertThrows(InvalidTicketException.class, () -> superParkingBoy.pickupCar(new Ticket("123", "123")));
  }


  @Test
  public void should_throw_no_ticket_exception_when_customer_pick_up_car_given_no_ticket() {
    superParkingBoy.parkCar(car);

    assertThrows(NoTicketException.class, () -> superParkingBoy.pickupCar(null));
  }

  @Test
  public void should_throw_invalid_ticket_exception_when_pick_up_car_given_use_valid_ticket_to_pick_up_twice() {
    Ticket ticket = superParkingBoy.parkCar(car);

    superParkingBoy.pickupCar(ticket);

    assertThrows(InvalidTicketException.class, () -> superParkingBoy.pickupCar(ticket));

  }
}