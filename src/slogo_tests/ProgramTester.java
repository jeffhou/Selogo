package slogo_tests;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.junit.Before;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import commands.Command;
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

		//testFiles.add("examples/loops/circle.logo");
		testFiles.add("examples/sums.txt");
	}
	
	@org.junit.Test
	public void testFiles() throws Exception {
		XMLReaderTest testFileReader = new XMLReaderTest();
		String resultsXML = "examples/testXML.xml";
		
		for (String file: testFiles) {
			
			Double corrPosition = Double.parseDouble(testFileReader.getCorrPosition(resultsXML, file));
			Double consoleReading = Double.parseDouble(testFileReader.getConsoleReading(resultsXML, file));
			assertEquals(interpreter.interpret(readFile(testFiles.get(0))).get(0), consoleReading, 0.1);

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
