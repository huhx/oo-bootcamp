package com.linux.huhx.bootcamp.day_four_parkinglot;

import com.linux.huhx.bootcamp.day_four_parkinglot.exception.InvalidTicketException;
import com.linux.huhx.bootcamp.day_four_parkinglot.exception.NoAvailableSpaceException;
import com.linux.huhx.bootcamp.day_four_parkinglot.exception.NoTicketException;
import com.linux.huhx.bootcamp.day_four_parkinglot.parkingboy.NormalParkingBoy;
import com.linux.huhx.bootcamp.day_four_parkinglot.parkingboy.ParkingBoy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NormalParkingBoyTest {

  private ParkingBoy normalParkingBoy;
  private Car car;

  @BeforeEach
  public void setUp() {
    car = new Car("京A168888");
    normalParkingBoy = new NormalParkingBoy(asList(
        new ParkingLot(1, "parkingNumber1"),
        new ParkingLot(1, "parkingNumber2")
    ));
  }

  @Test
  public void should_return_ticket_when_parking_given_parking_lots_has_available_space() {
    Ticket ticket = normalParkingBoy.parkCar(car);

    assertNotNull(ticket);
  }

  @Test
  public void should_throw_no_available_exception_when_parking_given_parking_lots_has_no_available_space() {
    normalParkingBoy.parkCar(new Car("AAAA"));
    normalParkingBoy.parkCar(new Car("BBBB"));

    assertThrows(NoAvailableSpaceException.class, () -> normalParkingBoy.parkCar(car));
  }

  @Test
  public void should_return_car_when_pick_up_car_given_valid_ticket() {
    Ticket ticket = normalParkingBoy.parkCar(car);

    assertEquals(car, normalParkingBoy.pickupCar(ticket));
  }

  @Test
  public void should_throw_invalid_ticket_exception_when_pick_up_car_given_invalid_ticket() {
    normalParkingBoy.parkCar(car);

    assertThrows(InvalidTicketException.class, () -> normalParkingBoy.pickupCar(new Ticket("123", "123")));
  }


  @Test
  public void should_throw_no_ticket_exception_when_customer_pick_up_car_given_no_ticket() {
    normalParkingBoy.parkCar(car);

    assertThrows(NoTicketException.class, () -> normalParkingBoy.pickupCar(null));
  }
}