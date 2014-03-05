package backend;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import commands.Command;
import commands.CommandFactory;
import commands.CommandInvoker;
import exceptions.EndOfStackException;
import exceptions.InvalidCommandException;
import exceptions.InvalidCommandStringException;
import exceptions.InvalidSyntaxException;
import exceptions.InvalidWordException;
import exceptions.NotEnoughParametersException;
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
	 * TODO: AdvancedCommands such as If and Repeat must return appropriate
	 * values
	 */
	CommandFactory commandFactory;
	public CommandInvoker commandInvoker;
	private Map<String, Double> variables = new HashMap<String, Double>();
	private Map<String, UserCommand> userCommands = new HashMap<String, UserCommand>();
	public ArrayList<String> listOfWords;

	public Interpreter() throws IOException, InstantiationException,
			IllegalAccessException, ClassNotFoundException {
		commandInvoker = new CommandInvoker(this);
		commandFactory = new CommandFactory();
	}

	public Double evaluateCommand(ArrayList<String> wordList)
			throws InvalidCommandStringException, InvalidWordException,
			NotEnoughParametersException, InvalidCommandException,
			InstantiationException, IllegalAccessException,
			ClassNotFoundException, InvalidSyntaxException, SlogoException,
			EndOfStackException {

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
		} else if (isUserCommand(firstWord)) {
			return getAndExecuteUserCommand(firstWord);
		} else {
			throw new InvalidWordException();
		}
	}

	public ArrayList<Double> interpret(String text)
			throws InstantiationException, IllegalAccessException,
			ClassNotFoundException, InvalidSyntaxException, SlogoException {
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

	private double getAndExecuteUserCommand(String commandName)
			throws InvalidSyntaxException, InstantiationException,
			IllegalAccessException, ClassNotFoundException, SlogoException {
		/**
		 * TODO: Correctly implement return value
		 */
		UserCommand command;
		try {
			command = userCommands.get(commandName);
		} catch (Exception e) {
			throw new InvalidCommandException();
		}
		try { // Set parameters to appropriate variables
			for (int i = 0; i < command.parameters.length; i++) {
				variables.put(command.parameters[i].substring(1),
						Double.valueOf(listOfWords.remove(0)));
			}
		} catch (Exception e) {
			throw new InvalidSyntaxException();
		}
		interpret(command.commands);
		return 1;
	}

	private boolean isCommand(String word) {
		return commandFactory.commands.containsKey(word.toLowerCase());
	}

	private boolean isUserCommand(String word) {
		return userCommands.containsKey(word);
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
		/**
		 * TODO: Fix glitch with close bracket not being separated by a space
		 */
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
		ret = ret.substring(0, ret.length() - 3); // 3 for space, end bracket,
		// and another space
		return ret;
	}

	public String readNextCommand() {
		return listOfWords.remove(0);
	}

	public double addVariable(String name, String expression)
			throws InstantiationException, IllegalAccessException,
			ClassNotFoundException, InvalidSyntaxException, SlogoException {
		double value = interpret(expression).get(0);
		variables.put(name, value);
		return value;
	}

	public double getVariable(String s) {
		if (variables.containsKey(s)) {
			return variables.get(s);
		} else {
			return 0;
		}
	}

	public double addUserCommand(String commandName, UserCommand command) {
		userCommands.put(commandName, command);
		return 1;
	}
}
