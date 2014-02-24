package backend;

import java.util.ArrayList;

import commands.Command;
import commands.CommandFactory;
import exceptions.*;

public class Interpreter {
	/**
	 * TODO: change the methods so that this looks like a real API TODO: Make
	 * documentation for all public methods and vars (all classes)
	 */
	final static String[] MATH_COMMANDS = { "sum", "+", "difference", "-",
			"product", "*", "quotient", "/", "remainder", "%", "minus", "~",
			"random", "sin", "cos", "tan", "atan", "log", "pow", "less?",
			"lessp", "greater?", "greaterp", "equal?", "equalp", "notequal?",
			"notequalp", "and", "or", "not?" };
	/**
	 * TODO: add in advanced commands
	 */
	CommandFactory commandFactory;
	public Engine engine;

	public Interpreter() {
		engine = new Engine();
		commandFactory = new CommandFactory(this, engine);
	}

	public ArrayList<Double> interpret(String text)
			throws PluralityOfValuesException, InvalidCommandStringException,
			InvalidWordException, NotEnoughParametersException,
			InvalidCommandException, InstantiationException,
			IllegalAccessException, ClassNotFoundException {
		ArrayList<String> wordList = listOutCommands(text);
		ArrayList<Double> evaluatedValues = new ArrayList<Double>();
		while (wordList.size() > 0) {
			evaluatedValues.add(evaluateCommand(wordList));
		}
		return evaluatedValues;
	}

	public ArrayList<String> listOutCommands(String commands) {
		ArrayList<String> listOfWords = new ArrayList<String>();
		String[] words = commands.split("\\s+");
		for (String word : words) {
			listOfWords.add(word);
		}
		return listOfWords;

	}

	private Double evaluateCommand(ArrayList<String> wordList)
			throws InvalidCommandStringException, InvalidWordException,
			NotEnoughParametersException, InvalidCommandException,
			InstantiationException, IllegalAccessException,
			ClassNotFoundException {
		String firstWord = wordList.remove(0);
		if (isConstantValue(firstWord)) {
			return Double.parseDouble(firstWord);
		} else if (isCommand(firstWord)) {
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
			return engine.obey(newCommand);
		} else {
			throw new InvalidWordException();
		}
	}

	private boolean isCommand(String word) {
		return commandFactory.commandClasses.containsKey(word);
	}

	private boolean isConstantValue(String word) {
		try {
			Double.parseDouble(word);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
