package com.linux.huhx.bootcamp.day_four_parkinglot;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Car {

  private String plate;

  private String owner;

  private String color;
}
