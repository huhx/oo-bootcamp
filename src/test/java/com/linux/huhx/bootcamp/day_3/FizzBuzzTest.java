package com.linux.huhx.bootcamp.day_3;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FizzBuzzTest {


  @Test
  public void should_return_fizz_when_convert_given_number_3() {
    String actual = new FizzBuzz().convert(3);

    assertEquals("Fizz", actual);
  }

  @Test
  public void should_return_buzz_when_convert_given_number_5() {
    assertEquals("Buzz", new FizzBuzz().convert(5));
  }

}
