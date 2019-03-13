package com.linux.huhx.bootcamp.day_four_parkinglot;

import com.linux.huhx.bootcamp.day_four_parkinglot.exception.InvalidTicketException;
import com.linux.huhx.bootcamp.day_four_parkinglot.exception.NoAvailableSpaceException;
import com.linux.huhx.bootcamp.day_four_parkinglot.exception.NoTicketException;
import java.util.List;
import java.util.Objects;

public class ParkingManager {

  private List<ParkingBoy> parkingBoys;

  private List<ParkingLot> parkingLots;

  public ParkingManager(List<ParkingBoy> parkingBoys, List<ParkingLot> parkingLots) {
    this.parkingBoys = parkingBoys;
    this.parkingLots = parkingLots;
  }

  public Ticket parkCar(Car car) {
    ParkingBoy parkingBoy = parkingBoys.stream()
        .filter(item -> item.existRemainParkingLot())
        .findAny().orElse(null);
    if (Objects.nonNull(parkingBoy)) {
      return parkingBoy.parkCar(car);
    }
    if (existRemainParkingLot()) {
      return parkingLots.stream().filter(parkingLot -> parkingLot.hasSpace()).findAny().get().parkCar(car);
    }
    throw new NoAvailableSpaceException();
  }

  public boolean existRemainParkingLot() {
    return parkingLots.stream().filter(parkingLot -> parkingLot.hasSpace()).count() > 0;
  }


  public Car pickupCar(Ticket ticket) {
    if (Objects.isNull(ticket)) {
      throw new NoTicketException();
    }
    ParkingLot parkingLot = parkingLots.stream().filter(item -> item.getLotNumber().equals(ticket.getParkingLotNumber())).findAny().orElse(null);
    if (Objects.nonNull(parkingLot)) {
      return parkingLot.pickUpCar(ticket);
    }

    ParkingBoy parkingBoy = parkingBoys.stream()
        .filter(item -> getParkingLot(item, ticket))
        .findAny()
        .orElseThrow(InvalidTicketException::new);

    return parkingBoy.pickupCar(ticket);
  }

  private boolean getParkingLot(ParkingBoy parkingBoy, Ticket ticket) {
    return parkingBoy.parkingLots.stream()
        .filter(parkingLot -> parkingLot.getLotNumber().equals(ticket.getParkingLotNumber()))
        .count() > 0;
  }
}
