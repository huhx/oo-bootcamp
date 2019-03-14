package com.linux.huhx.bootcamp.day_four_parkinglot;

import com.linux.huhx.bootcamp.day_four_parkinglot.exception.InvalidTicketException;
import com.linux.huhx.bootcamp.day_four_parkinglot.exception.NoAvailableSpaceException;
import com.linux.huhx.bootcamp.day_four_parkinglot.exception.NoTicketException;
import com.linux.huhx.bootcamp.day_four_parkinglot.parkingboy.ParkingManager;
import com.linux.huhx.bootcamp.day_four_parkinglot.parkingboy.SmartParkingBoy;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

  @Test
  public void should_return_ticket_when_parking_given_parking_manager_have_no_parking_boys_and_have_available_lot() {
    ParkingManager parkingManager = new ParkingManager(Arrays.asList(new ParkingLot(4, "b")));

    Ticket ticket = parkingManager.parkCar(car);

    assertNotNull(ticket);
  }

  @Test
  public void should_throw_no_available_exception_when_parking_given_parking_manager_have_parking_boys_and_have_no_available_lot() {
    SmartParkingBoy smartParkingBoy = new SmartParkingBoy(asList(new ParkingLot(1, "b")));
    smartParkingBoy.parkCar(new Car("car"));
    ParkingManager parkingManager = new ParkingManager(asList(smartParkingBoy));

    assertThrows(NoAvailableSpaceException.class, () -> parkingManager.parkCar(car));
  }

  @Test
  public void should_return_car_when_pick_up_car_given_valid_ticket() {
    SmartParkingBoy smartParkingBoy = new SmartParkingBoy(asList(new ParkingLot(1, "b")));
    ParkingManager parkingManager = new ParkingManager(asList(smartParkingBoy));
    Ticket ticket = parkingManager.parkCar(car);

    assertEquals(car, parkingManager.pickupCar(ticket));
  }

  @Test
  public void should_throw_invalid_ticket_exception_when_pick_up_car_given_invalid_ticket() {
    SmartParkingBoy smartParkingBoy = new SmartParkingBoy(asList(new ParkingLot(1, "b")));
    ParkingManager parkingManager = new ParkingManager(asList(smartParkingBoy));
    parkingManager.parkCar(car);

    assertThrows(InvalidTicketException.class, () -> parkingManager.pickupCar(new Ticket("3", "5")));
  }

  @Test
  public void should_throw_invalid_ticket_exception_when_pick_up_car_given_use_valid_ticket_to_pick_up_twice() {
    SmartParkingBoy smartParkingBoy = new SmartParkingBoy(asList(new ParkingLot(1, "b")));
    ParkingManager parkingManager = new ParkingManager(asList(smartParkingBoy));
    Ticket ticket = parkingManager.parkCar(car);
    parkingManager.pickupCar(ticket);

    assertThrows(InvalidTicketException.class, () -> parkingManager.pickupCar(ticket));
  }

  @Test
  public void should_throw_no_ticket_exception_when_pick_up_car_given_use_no_ticket_to_pick_up() {
    SmartParkingBoy smartParkingBoy = new SmartParkingBoy(asList(new ParkingLot(1, "b")));
    ParkingManager parkingManager = new ParkingManager(asList(smartParkingBoy));
    parkingManager.parkCar(car);

    assertThrows(NoTicketException.class, () -> parkingManager.pickupCar(null));
  }
}