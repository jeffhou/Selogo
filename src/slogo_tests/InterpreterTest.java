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

import slogo_team12.Interpreter;
import slogo_team12.Interpreter.PluralityOfValuesException;

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
	 * @throws PluralityOfValuesException 
	 */
	@Test
	public void testForward() throws PluralityOfValuesException{
		assertEquals(interpreter.interpret("fd 50"), 50, 0.1);
	}
	
	/**
	 * Test method for {@link slogo_team12.Interpreter#Interpreter()}.
	 */
	@Test
	public void testInterpreter() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link slogo_team12.Interpreter#parseInput(java.lang.String)}.
	 */
	@Test
	public void testParseInput() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link slogo_team12.Interpreter#interpret(java.lang.String)}.
	 */
	@Test
	public void testInterpret() {
		fail("Not yet implemented"); // TODO
	}

}
