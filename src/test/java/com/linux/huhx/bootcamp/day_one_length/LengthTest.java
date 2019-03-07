package com.linux.huhx.bootcamp.day_one_length;

import org.junit.Assert;
import org.junit.Test;

public class LengthTest {

  @Test
  public void should_return_negative_1_when_compare_two_length_give_length_1cm_and_length_4cm() {
    Length srcLength = new Length(1, UnitEnum.CM);
    Length targetLength = new Length(4, UnitEnum.CM);

    int actual = srcLength.compareTo(targetLength);

    Assert.assertEquals(-1, actual);
  }

  @Test
  public void should_return_1_when_compare_two_length_give_length_1m_and_length_4cm() {
    Length srcLength = new Length(1, UnitEnum.M);
    Length targetLength = new Length(4, UnitEnum.CM);

    int actual = srcLength.compareTo(targetLength);

    Assert.assertEquals(1, actual);
  }

  @Test
  public void should_return_0_when_compare_two_length_give_length_4cm_and_length_4cm() {
    Length srcLength = new Length(4, UnitEnum.CM);
    Length targetLength = new Length(4, UnitEnum.CM);

    int actual = srcLength.compareTo(targetLength);

    Assert.assertEquals(0, actual);
  }

}
