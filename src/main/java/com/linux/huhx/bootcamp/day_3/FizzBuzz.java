package com.linux.huhx.bootcamp.day_3;

public class FizzBuzz {

  public String convert(int number) {
    if (number % 15 == 0) {
      return "FizzBuzz";
    } else if (number % 3 == 0) {
      return "Fizz";
    } else if (number % 5 == 0) {
      return "Buzz";
    } else {
      return String.valueOf(number);
    }
  }
}
