package com.linux.huhx.bootcamp.day_two_SRP.convert;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DefaultDateConverterTest {

  private Converter converter;

  @Before
  public void setUp() {
    converter = new DefaultDateConverter();
  }

  @Test
  public void should_return_date_string_when_convert_given_default_date_format_string() {
    String input = "2019-09-23";
    String actual = converter.convert(input);

    assertEquals("20190923", actual);
  }

  @Test
  public void should_return_map_string_when_convert_given_not_date_format_string() {
    String input = "2019-23/1";
    String actual = converter.convert(input);

    assertEquals("{0=1, 1=2, 2=2, 3=1, 9=1, -=1, /=1}", actual);
  }
}