package com.linux.huhx.bootcamp.day_one;

public enum UnitEnum {

  CM(10), DM(100), M(100);

  private int times;

  UnitEnum(int times) {
    this.times = times;
  }

  public int getTimes() {
    return this.times;
  }
}
