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
	public void testthatArcTanReturnsCorrectly() throws InstantiationException, IllegalAccessException, ClassNotFoundException, PluralityOfValuesException, InvalidCommandStringException, InvalidWordException, NotEnoughParametersException, InvalidCommandException, InvalidSyntaxException {
		assertEquals(interpreter.interpret("atan 10").get(0), Double.valueOf(Math.toDegrees(Math.atan(10))));
	}

}
