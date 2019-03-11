package com.linux.huhx.bootcamp.day_four_parkinglot;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Ticket {

  private String parkingLotNumber;

  private String ticketNumber;
}
