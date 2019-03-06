package com.linux.huhx.bootcamp.day_two_SRP.convert;

import java.util.HashMap;
import java.util.Map;

public interface Converter {

  String convert(String input);

  default String countCharacters(String dateString) {
    Map<Character, Integer> map = new HashMap<>();
    char[] chars = dateString.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      if (map.get(chars[i]) == null) {
        map.put(chars[i], 0);
      }
      map.put(chars[i], map.get(chars[i]) + 1);
    }
    return map.toString();
  }
}
