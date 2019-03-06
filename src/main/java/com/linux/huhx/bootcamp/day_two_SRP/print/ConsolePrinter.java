package com.linux.huhx.bootcamp.day_two_SRP.print;

public class ConsolePrinter implements Printer {

  @Override
  public String print(String input) {
    return "console: " + input;
  }
}
