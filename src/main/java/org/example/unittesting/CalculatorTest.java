package org.example.unittesting;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

public class CalculatorTest {
  @Test
  public void testAdd(){
    Calculator calculator = new Calculator();
    assertEquals(5, calculator.add(2,3));
  }

  @Test
  public void devide(){
    Calculator calculator = new Calculator();
    assertEquals(1,calculator.devide(2,2));
  }

  @Test
  public void testDeviceByZero(){
    Calculator calculator = new Calculator();
    assertThrows(IllegalArgumentException.class, ()-> calculator.devide(2,0));
  }


}
