package com.linux.huhx.bootcamp.day_two_SRP.print;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConsolePrinterTest {

  private Printer printer;

  @Before
  public void setUp() {
    printer = new ConsolePrinter();
  }

  @Test
  public void should_print_console_string_when_print_given_input() {
    String actual = printer.print("hello world.");

    assertEquals("console: hello world.", actual);
  }
}