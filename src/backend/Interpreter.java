package backend;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import commands.Command;
import commands.CommandFactory;
import commands.CommandInvoker;
import exceptions.EndOfStackException;
import exceptions.InvalidCommandException;
import exceptions.InvalidCommandStringException;
import exceptions.InvalidSyntaxException;
import exceptions.InvalidWordException;
import exceptions.NotEnoughParametersException;
import exceptions.PluralityOfValuesException;
import exceptions.SlogoException;
import exceptions.VariableNotFoundException;


public class Interpreter {
	/**
	 * TODO: change the methods so that this looks like a real API
	 */
	/**
	 * TODO: Make documentation for all public methods and vars (all classes)
	 */
	/**
	 * TODO: AdvancedCommands such as If and Repeat must return appropriate values
	 */
	CommandFactory commandFactory;
	public CommandInvoker commandInvoker;
	private HashMap<String, Double> variables = new HashMap<String, Double>();
	public ArrayList<String> listOfWords;

	public Interpreter() throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		commandInvoker = new CommandInvoker(this);
		commandFactory = new CommandFactory();
	}

	public Double evaluateCommand(ArrayList<String> wordList)
			throws InvalidCommandStringException, InvalidWordException,
			NotEnoughParametersException, InvalidCommandException,
			InstantiationException, IllegalAccessException,
			ClassNotFoundException, InvalidSyntaxException, SlogoException, EndOfStackException {

		String firstWord = wordList.remove(0);
		if (isConstantValue(firstWord)) {
			return Double.parseDouble(firstWord);
		} else if (isCommand(firstWord)) {
			firstWord = firstWord.toLowerCase();
			ArrayList<Double> parameters = new ArrayList<Double>();
			Command newCommand = commandFactory.createCommand(firstWord);
			for (int i = 0; i < newCommand.NUM_OF_PARAMETERS; i++) {
				if (wordList.size() > 0) {
					parameters.add(evaluateCommand(wordList));
				} else {
					throw new NotEnoughParametersException();
				}
			}
			newCommand.loadParameters(parameters);
			return commandInvoker.obey(newCommand);
		} else if (isVariable(firstWord)) {
			return getVariable(firstWord.substring(1));
		} else {
			throw new InvalidWordException();
		}
	}

	public ArrayList<Double> interpret(String text)
			throws InstantiationException,
			IllegalAccessException, ClassNotFoundException,
			InvalidSyntaxException, SlogoException {
		text = text.trim();
		listOutCommands(text);
		ArrayList<Double> evaluatedValues = new ArrayList<Double>();
		while (listOfWords.size() > 0) {
			try {
				evaluatedValues.add(evaluateCommand(listOfWords));
			} catch (EndOfStackException e) {
				System.out.println("caught");
			}
		}
		return evaluatedValues;
	}

	private boolean isCommand(String word) {
		return commandFactory.commands.containsKey(word.toLowerCase());
	}

	private boolean isConstantValue(String word) {
		try {
			Double.parseDouble(word);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	private boolean isVariable(String word) throws SlogoException {
		if (word.startsWith(":")) {
			if (!variables.containsKey(word.substring(1))) {
				throw new VariableNotFoundException();
			} else {
				return true;
			}
		}
		return false;
	}

	public void listOutCommands(String commands) {
		listOfWords = new ArrayList<String>();
		String[] words = commands.split("[\\s\\n]+");
		for (String word : words) {
			listOfWords.add(word);
		}

	}

	public String readBrackets() throws InvalidSyntaxException {
		if (!listOfWords.remove(0).equals("[")) {
			throw new InvalidSyntaxException();
		}
		int bracketCounter = 1;
		String ret = "";
		while (bracketCounter != 0) {
			String nextWord = listOfWords.remove(0);
			if (nextWord.startsWith("[")) {
				bracketCounter++;
			}
			if (nextWord.endsWith("]")) {
				bracketCounter--;
			}
			ret += nextWord + " ";
		}
		ret = ret.substring(0, ret.length()-3); //3 for space, end bracket, and another space
		return ret;
	}

	public double addVariable() throws InvalidSyntaxException {
		double value;
		if (listOfWords.get(0).charAt(0) != ':') {
			throw new InvalidSyntaxException();
		}
		try {
			value = Double.valueOf(listOfWords.remove(1));
		} catch (Exception e) {
			throw new InvalidSyntaxException();
		}
		variables.put(listOfWords.remove(0).substring(1), value);
		return value;
	}
	
	public double getVariable(String s) {
		if(variables.containsKey(s)) {
			return variables.get(s);
		}
		else {
			return 0;
		}
	}
}
