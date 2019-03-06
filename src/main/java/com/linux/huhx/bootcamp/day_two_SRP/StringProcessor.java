package com.linux.huhx.bootcamp.day_two_SRP;

import com.linux.huhx.bootcamp.day_two_SRP.convert.Converter;
import com.linux.huhx.bootcamp.day_two_SRP.print.Printer;

public class StringProcessor {

  private Converter converter;

  private Printer printer;

  StringProcessor(Converter converter, Printer printer) {
    this.converter = converter;
    this.printer = printer;
  }

  public void output(String input) {
    printer.print(converter.convert(input));
  }
}