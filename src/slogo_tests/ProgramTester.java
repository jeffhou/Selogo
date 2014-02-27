package slogo_tests;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import org.junit.Before;

import exceptions.InvalidCommandException;
import exceptions.InvalidCommandStringException;
import exceptions.InvalidSyntaxException;
import exceptions.InvalidWordException;
import exceptions.NotEnoughParametersException;
import exceptions.PluralityOfValuesException;
import exceptions.SlogoException;

import backend.Interpreter;

public class ProgramTester {
	
	ArrayList<String> testFiles;
	Interpreter interpreter;

	@Before
	public void setUp() throws Exception {
		
		interpreter = new Interpreter();
		
		testFiles = new ArrayList<String>();
	
		
		testFiles.add("examples/loops/circle.logo");
		
		//testFiles.add("sum 5 6");
	}
	
	@org.junit.Test
	public void testFiles() throws InstantiationException, IllegalAccessException, ClassNotFoundException, InvalidSyntaxException, IOException, SlogoException {
		for (String file: testFiles) {
			assertEquals(interpreter.interpret(readFile(file)), 11.0);
		}
	}
	
	

	
	
	
	private String readFile( String file ) throws IOException {
	    BufferedReader reader = new BufferedReader( new FileReader (file));
	    String         line = null;
	    StringBuilder  stringBuilder = new StringBuilder();
	    String         ls = System.getProperty("line.separator");
	   
	    while( ( line = reader.readLine() ) != null ) {
	        stringBuilder.append( line );
	        stringBuilder.append( ls );
	    }

	    return stringBuilder.toString();
	}
	
	
	
	
	

}
