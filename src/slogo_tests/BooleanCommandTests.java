package slogo_tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;

import backend.Interpreter;
import exceptions.InvalidCommandException;
import exceptions.InvalidCommandStringException;
import exceptions.InvalidSyntaxException;
import exceptions.InvalidWordException;
import exceptions.NotEnoughParametersException;
import exceptions.PluralityOfValuesException;
import exceptions.SlogoException;
import exceptions.VariableNotFoundException;

public class BooleanCommandTests {

	Interpreter interpreter;

	@Before
	public void setUp() throws Exception {
		interpreter = new Interpreter();
	}

	@org.junit.Test
	public void testAnd() throws InstantiationException,
			IllegalAccessException, ClassNotFoundException,
			InvalidSyntaxException, SlogoException {
		assertEquals(Double.valueOf(1), interpreter.interpret("and 9 2").get(0));
		assertEquals(Double.valueOf(0), interpreter.interpret("and -5 0")
				.get(0));
		assertEquals(Double.valueOf(1), interpreter.interpret("and -9 2")
				.get(0));
		assertEquals(Double.valueOf(1), interpreter.interpret("and 9 -2")
				.get(0));
	}

	@org.junit.Test
	public void testOr() throws InstantiationException, IllegalAccessException,
			ClassNotFoundException, InvalidSyntaxException, SlogoException {
		assertEquals(Double.valueOf(1), interpreter.interpret("or 9 2").get(0));
		assertEquals(Double.valueOf(1), interpreter.interpret("or -5 -2")
				.get(0));
		assertEquals(Double.valueOf(0), interpreter.interpret("or 0 0").get(0));
		assertEquals(Double.valueOf(1), interpreter.interpret("or 9 -2").get(0));
	}

	@org.junit.Test
	public void testEqual() throws InstantiationException,
			IllegalAccessException, ClassNotFoundException,
			InvalidSyntaxException, SlogoException {
		assertEquals(Double.valueOf(1), interpreter.interpret("equal? 1 1.0")
				.get(0));
		assertEquals(Double.valueOf(1), interpreter.interpret("equal? 0 0")
				.get(0));
		assertEquals(Double.valueOf(0), interpreter.interpret("equal? 3 -3")
				.get(0));
		assertEquals(Double.valueOf(0), interpreter.interpret("equal? 6 3")
				.get(0));
	}

	@org.junit.Test
	public void testNotEqual() throws InstantiationException,
			IllegalAccessException, ClassNotFoundException,
			InvalidSyntaxException, SlogoException {
		assertEquals(Double.valueOf(0), interpreter
				.interpret("notequal? 1 1.0").get(0));
		assertEquals(Double.valueOf(0), interpreter.interpret("notequal? 0 0")
				.get(0));
		assertEquals(Double.valueOf(1), interpreter.interpret("notequal? 3 -3")
				.get(0));
		assertEquals(Double.valueOf(1), interpreter.interpret("notequal? 6 3")
				.get(0));
	}

	@org.junit.Test
	public void testGreater() throws InstantiationException,
			IllegalAccessException, ClassNotFoundException,
			InvalidSyntaxException, SlogoException {
		assertEquals(Double.valueOf(0), interpreter.interpret("greater? 1 1.0")
				.get(0));
		assertEquals(Double.valueOf(1), interpreter.interpret("greater? 5 0")
				.get(0));
		assertEquals(Double.valueOf(1), interpreter.interpret("greater? 3 -3")
				.get(0));
		assertEquals(Double.valueOf(0),
				interpreter.interpret("greater? 0.4 0.45").get(0));
	}

	@org.junit.Test
	public void testLess() throws InstantiationException,
			IllegalAccessException, ClassNotFoundException,
			InvalidSyntaxException, SlogoException {
		assertEquals(Double.valueOf(0), interpreter.interpret("less? 1 1.0")
				.get(0));
		assertEquals(Double.valueOf(0),
				interpreter.interpret("less? 5 0").get(0));
		assertEquals(Double.valueOf(0), interpreter.interpret("less? 3 -3")
				.get(0));
		assertEquals(Double.valueOf(1), interpreter.interpret("less? 0.4 0.45")
				.get(0));
	}

	@org.junit.Test
	public void testNot() throws InstantiationException,
			IllegalAccessException, ClassNotFoundException,
			InvalidSyntaxException, SlogoException {
		assertEquals(Double.valueOf(0), interpreter.interpret("not 1").get(0));
		assertEquals(Double.valueOf(0), interpreter.interpret("not -5").get(0));
		assertEquals(Double.valueOf(1), interpreter.interpret("not 0").get(0));
		assertEquals(Double.valueOf(0), interpreter.interpret("not -0.4")
				.get(0));
	}

}
