package com.linux.huhx.bootcamp.day_two_SRP.convert;

import java.util.regex.Pattern;

public class SimpleDateConverter implements Converter {

  Pattern pattern = Pattern.compile("^\\d{4}/\\d{2}/\\d{2}$");

  @Override
  public String convert(String dateString) {
    boolean isMatch = pattern.matcher(dateString).matches();
    if (isMatch) {
      return String.join("", dateString.split("/"));
    }
    return countCharacters(dateString);
  }
}
