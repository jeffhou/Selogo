package slogo_tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;

import backend.Interpreter;
import exceptions.InvalidSyntaxException;
import exceptions.SlogoException;

public class MathCommandTests {

  Interpreter interpreter;

  @Before
  public void setUp() throws Exception {
    interpreter = new Interpreter();
  }

  @org.junit.Test
  public void testATan() throws Exception {
    assertEquals(Double.valueOf(Math.toDegrees(Math.atan(10))), interpreter.interpret("atan 10").get(0));
  }

  @org.junit.Test
  public void testCos() throws Exception {
    assertEquals(Double.valueOf(Math.cos(Math.toRadians(10))), interpreter.interpret("cos 10").get(0));
  }

  @org.junit.Test
  public void testDifference() throws Exception {
    assertEquals(Double.valueOf(5), interpreter.interpret("difference 10 5").get(0));
    assertEquals(Double.valueOf(-15),
        interpreter.interpret("difference -10 5").get(0));
  }

  @org.junit.Test
  public void testLog() throws Exception{
    assertEquals(Double.valueOf(1), interpreter.interpret("log " + Math.E)
        .get(0));
  }

  @org.junit.Test
  public void testMinus() throws Exception{
    assertEquals(Double.valueOf(5), interpreter.interpret("minus -5")
        .get(0));
    assertEquals(Double.valueOf(-5), interpreter.interpret("minus 5")
        .get(0));
  }

  @org.junit.Test
  public void testPow() throws Exception{
    assertEquals(Double.valueOf(-8),
        interpreter.interpret("pow -2 3").get(0));
    assertEquals(Double.valueOf(8), interpreter.interpret("pow 2 3").get(0));
    assertEquals(Double.valueOf(-.125), interpreter.interpret("pow -2 -3")
        .get(0));
  }

  @org.junit.Test
  public void testProduct() throws Exception{
    assertEquals(Double.valueOf(-3), interpreter
        .interpret("product -1.5 2").get(0));
  }

  @org.junit.Test
  public void testQuotient() throws Exception{
    assertEquals(Double.valueOf(3), interpreter.interpret("quotient 9 3")
        .get(0));
    assertEquals(Double.valueOf(2.5), interpreter.interpret("quotient 5 2")
        .get(0));
    assertEquals(Double.valueOf(0), interpreter.interpret("quotient 5 0")
        .get(0));
  }

  @org.junit.Test
  public void testRandom() throws Exception{
    double number = interpreter.interpret("random 1").get(0);
    assertTrue(number >= 0 && number < 1);
    number = interpreter.interpret("random 25").get(0);
    assertTrue(number >= 0 && number < 25);
    number = interpreter.interpret("random -25").get(0);
    assertTrue(number == 0); // Must return non-negative number, probably
    // should throw exception if max is < 0
  }

  @org.junit.Test
  public void testRemainder() throws Exception{
    assertEquals(Double.valueOf(1), interpreter.interpret("remainder 5 2")
        .get(0));
    assertEquals(Double.valueOf(-1), interpreter
        .interpret("remainder -5 2").get(0));
    assertEquals(Double.valueOf(0), interpreter.interpret("remainder 4 2")
        .get(0));
  }

  @org.junit.Test
  public void testSin() throws Exception{
    assertEquals(Double.valueOf(Math.sin(Math.toRadians(10))), interpreter
        .interpret("sin 10").get(0));
  }

  @org.junit.Test
  public void testSum() throws Exception{
    assertEquals(Double.valueOf(15),
        interpreter.interpret("sum 10 5").get(0));
    assertEquals(Double.valueOf(-5), interpreter.interpret("sum -10 5")
        .get(0));
  }

  @org.junit.Test
  public void testTan() throws Exception{
    assertEquals(Double.valueOf(0),
        interpreter.interpret("tan " + Math.PI / 2).get(0)); // tan(pi/2)
    // is
    // undefined
    // and
    // should
    // return
    // 0
    // (see
    // specs)
  }

}
