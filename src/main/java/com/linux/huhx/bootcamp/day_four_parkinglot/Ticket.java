package com.linux.huhx.bootcamp.day_four_parkinglot;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Ticket {

  private String lotNumber;

  private String ticketNumber;
}
