/**
 * 
 */
package slogo_tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import backend.Interpreter;
import exceptions.InvalidCommandException;
import exceptions.InvalidCommandStringException;
import exceptions.InvalidWordException;
import exceptions.NotEnoughParametersException;
import exceptions.PluralityOfValuesException;

/**
 * @author jeffhou
 * 
 */
public class InterpreterTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	Interpreter interpreter;

	@Before
	public void setUp() throws Exception {
		interpreter = new Interpreter();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for forward.logo
	 * 
	 * @throws PluralityOfValuesException
	 * @throws InvalidCommandException
	 * @throws NotEnoughParametersException
	 * @throws InvalidWordException
	 * @throws InvalidCommandStringException
	 * @throws ClassNotFoundException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	@Test
	public void testForward() throws PluralityOfValuesException,
			InvalidCommandStringException, InvalidWordException,
			NotEnoughParametersException, InvalidCommandException,
			InstantiationException, IllegalAccessException,
			ClassNotFoundException {
		assertEquals(interpreter.interpret("fd 50").get(0), 50.0, 0.1);
	}

	@Test
	public void testForwardForward() throws PluralityOfValuesException,
			InvalidCommandStringException, InvalidWordException,
			NotEnoughParametersException, InvalidCommandException,
			InstantiationException, IllegalAccessException,
			ClassNotFoundException {
		assertEquals(interpreter.interpret("fd fd 50").get(0), 50.0, 0.1);
	}

}
