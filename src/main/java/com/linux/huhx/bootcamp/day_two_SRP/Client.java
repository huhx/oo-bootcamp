package com.linux.huhx.bootcamp.day_two_SRP;

import com.linux.huhx.bootcamp.day_two_SRP.convert.Converter;
import com.linux.huhx.bootcamp.day_two_SRP.convert.DefaultDateConverter;
import com.linux.huhx.bootcamp.day_two_SRP.print.ConsolePrinter;
import com.linux.huhx.bootcamp.day_two_SRP.print.Printer;

public class Client {

  public static void main(String[] args) {
    Converter converter = new DefaultDateConverter();
    Printer printer = new ConsolePrinter();
    System.out.println(new StringProcessor(converter, printer).output("2099-09-09"));
  }
}