package com.linux.huhx.bootcamp.day_one_length;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Length implements Comparable<Length> {

  private int value;
  private UnitEnum unit;

  @Override
  public int compareTo(Length length) {
    int srcLength = value * unit.getTimes();
    int targetLength = length.value * length.unit.getTimes();
    if (srcLength < targetLength) {
      return -1;
    } else if (srcLength == targetLength) {
      return 0;
    } else {
      return 1;
    }
  }
}