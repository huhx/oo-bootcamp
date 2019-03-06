package com.linux.huhx.bootcamp.day_two_SRP.convert;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SimpleDateConverterTest {

  private Converter converter;

  @Before
  public void setUp() {
    converter = new SimpleDateConverter();
  }

  @Test
  public void should_return_date_string_when_convert_given_default_date_format_string() {
    String input = "2019/09/23";
    String actual = converter.convert(input);

    assertEquals("20190923", actual);
  }

  @Test
  public void should_return_map_string_when_convert_given_not_date_format_string() {
    String input = "2019-11-01";
    String actual = converter.convert(input);

    assertEquals("{0=2, 1=4, 2=1, 9=1, -=2}", actual);
  }
}