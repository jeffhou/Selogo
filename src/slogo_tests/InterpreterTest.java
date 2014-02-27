/**
 * 
 */
package slogo_tests;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import backend.Interpreter;
import exceptions.EndOfStackException;
import exceptions.InvalidCommandException;
import exceptions.InvalidCommandStringException;
import exceptions.InvalidSyntaxException;
import exceptions.InvalidWordException;
import exceptions.NotEnoughParametersException;
import exceptions.PluralityOfValuesException;
import exceptions.SlogoException;
import exceptions.VariableNotFoundException;

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
	 * @throws ClassNotFoundException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws InvalidSyntaxException
	 * @throws EndOfStackException
	 * @throws SlogoException 
	 */
	@Test
	public void testForward() throws InstantiationException, IllegalAccessException,
			ClassNotFoundException, InvalidSyntaxException, EndOfStackException, SlogoException {
		assertEquals(interpreter.interpret("fd 50").get(0), 50.0, 0.1);
	}

	@Test
	public void testForwardForward() throws InstantiationException, IllegalAccessException,
			ClassNotFoundException, InvalidSyntaxException, EndOfStackException, SlogoException {
		assertEquals(interpreter.interpret("fd fd 50").get(0), 50.0, 0.1);
	}

}
