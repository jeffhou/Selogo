package slogo_tests;

import static org.junit.Assert.*;

import org.junit.Before;

import backend.Interpreter;
import exceptions.InvalidCommandException;
import exceptions.InvalidCommandStringException;
import exceptions.InvalidSyntaxException;
import exceptions.InvalidWordException;
import exceptions.NotEnoughParametersException;
import exceptions.PluralityOfValuesException;

public class MathCommandTests {

	Interpreter interpreter;

	@Before
	public void setUp() throws Exception {
		interpreter = new Interpreter();
	}

	@org.junit.Test
	public void testATan() throws InstantiationException,
			IllegalAccessException, ClassNotFoundException,
			PluralityOfValuesException, InvalidCommandStringException,
			InvalidWordException, NotEnoughParametersException,
			InvalidCommandException, InvalidSyntaxException {
		assertEquals(Double.valueOf(Math.toDegrees(Math.atan(10))), interpreter
				.interpret("atan 10").get(0));
	}

	@org.junit.Test
	public void testCos() throws InstantiationException,
			IllegalAccessException, ClassNotFoundException,
			PluralityOfValuesException, InvalidCommandStringException,
			InvalidWordException, NotEnoughParametersException,
			InvalidCommandException, InvalidSyntaxException {
		assertEquals(Double.valueOf(Math.cos(Math.toRadians(10))), interpreter
				.interpret("cos 10").get(0));
	}
	
	@org.junit.Test
	public void testDifference() throws InstantiationException,
			IllegalAccessException, ClassNotFoundException,
			PluralityOfValuesException, InvalidCommandStringException,
			InvalidWordException, NotEnoughParametersException,
			InvalidCommandException, InvalidSyntaxException {
		assertEquals(Double.valueOf(5), interpreter.interpret("difference 10 5").get(0));
		assertEquals(Double.valueOf(-15), interpreter.interpret("difference -10 5").get(0));
	}
	
	@org.junit.Test
	public void testLog() throws InstantiationException,
			IllegalAccessException, ClassNotFoundException,
			PluralityOfValuesException, InvalidCommandStringException,
			InvalidWordException, NotEnoughParametersException,
			InvalidCommandException, InvalidSyntaxException {
		assertEquals(Double.valueOf(1), interpreter.interpret("log " + Math.E).get(0));
	}
	
	@org.junit.Test
	public void testMinus() throws InstantiationException,
			IllegalAccessException, ClassNotFoundException,
			PluralityOfValuesException, InvalidCommandStringException,
			InvalidWordException, NotEnoughParametersException,
			InvalidCommandException, InvalidSyntaxException {
		assertEquals(Double.valueOf(5), interpreter.interpret("minus -5").get(0));
		assertEquals(Double.valueOf(-5), interpreter.interpret("minus 5").get(0));
	}
	
	@org.junit.Test
	public void testPow() throws InstantiationException,
			IllegalAccessException, ClassNotFoundException,
			PluralityOfValuesException, InvalidCommandStringException,
			InvalidWordException, NotEnoughParametersException,
			InvalidCommandException, InvalidSyntaxException {
		assertEquals(Double.valueOf(-8), interpreter.interpret("pow -2 3").get(0));
		assertEquals(Double.valueOf(8), interpreter.interpret("pow 2 3").get(0));
		assertEquals(Double.valueOf(-.125), interpreter.interpret("pow -2 -3").get(0));
	}
	
	@org.junit.Test
	public void testProduct() throws InstantiationException,
			IllegalAccessException, ClassNotFoundException,
			PluralityOfValuesException, InvalidCommandStringException,
			InvalidWordException, NotEnoughParametersException,
			InvalidCommandException, InvalidSyntaxException {
	}
	
	@org.junit.Test
	public void testQuotient() throws InstantiationException,
			IllegalAccessException, ClassNotFoundException,
			PluralityOfValuesException, InvalidCommandStringException,
			InvalidWordException, NotEnoughParametersException,
			InvalidCommandException, InvalidSyntaxException {
	}
	
	@org.junit.Test
	public void testRandom() throws InstantiationException,
			IllegalAccessException, ClassNotFoundException,
			PluralityOfValuesException, InvalidCommandStringException,
			InvalidWordException, NotEnoughParametersException,
			InvalidCommandException, InvalidSyntaxException {
	}
	
	@org.junit.Test
	public void testRemainder() throws InstantiationException,
			IllegalAccessException, ClassNotFoundException,
			PluralityOfValuesException, InvalidCommandStringException,
			InvalidWordException, NotEnoughParametersException,
			InvalidCommandException, InvalidSyntaxException {
	}
	
	@org.junit.Test
	public void testSin() throws InstantiationException,
			IllegalAccessException, ClassNotFoundException,
			PluralityOfValuesException, InvalidCommandStringException,
			InvalidWordException, NotEnoughParametersException,
			InvalidCommandException, InvalidSyntaxException {
	}
	
	@org.junit.Test
	public void testSum() throws InstantiationException,
			IllegalAccessException, ClassNotFoundException,
			PluralityOfValuesException, InvalidCommandStringException,
			InvalidWordException, NotEnoughParametersException,
			InvalidCommandException, InvalidSyntaxException {
	}
	

	@org.junit.Test
	public void testTan() throws InstantiationException,
			IllegalAccessException, ClassNotFoundException,
			PluralityOfValuesException, InvalidCommandStringException,
			InvalidWordException, NotEnoughParametersException,
			InvalidCommandException, InvalidSyntaxException {
		assertEquals(Double.valueOf(0),
				interpreter.interpret("tan " + Math.PI / 2).get(0));
	}

}
