package com.linux.huhx.bootcamp.day_two_SRP.print;

public class PaperPrinter implements Printer {

  @Override
  public String print(String input) {
    return "paper: " + input;
  }
}
