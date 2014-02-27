package backend;

import java.io.IOException;
import java.util.ArrayList;

import commands.Command;
import commands.CommandFactory;

import exceptions.EndOfStackException;
import exceptions.InvalidCommandException;
import exceptions.InvalidCommandStringException;
import exceptions.InvalidSyntaxException;
import exceptions.InvalidWordException;
import exceptions.NotEnoughParametersException;
import exceptions.PluralityOfValuesException;

public class Interpreter {
	/**
	 * TODO: change the methods so that this looks like a real API
	 */
	/**
	 * TODO: Make documentation for all public methods and vars (all classes)
	 */
	CommandFactory commandFactory;
	public Engine engine;

	public ArrayList<String> listOfWords;

	public Interpreter() throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		engine = new Engine(this);
		commandFactory = new CommandFactory(this, engine);
	}

	public Double evaluateCommand(ArrayList<String> wordList)
			throws InvalidCommandStringException, InvalidWordException,
			NotEnoughParametersException, InvalidCommandException,
			InstantiationException, IllegalAccessException,
			ClassNotFoundException, InvalidSyntaxException, EndOfStackException {

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
			return engine.obey(newCommand);
		} else {
			throw new InvalidWordException();
		}
	}

	public ArrayList<Double> interpret(String text)
			throws PluralityOfValuesException, InvalidCommandStringException,
			InvalidWordException, NotEnoughParametersException,
			InvalidCommandException, InstantiationException,
			IllegalAccessException, ClassNotFoundException,
			InvalidSyntaxException {
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

	public void listOutCommands(String commands) {
		listOfWords = new ArrayList<String>();
		String[] words = commands.split("[\\s\\n]+");
		for (String word : words) {
			listOfWords.add(word);
		}

	}

	public double readBrackets() throws InvalidSyntaxException,
			InstantiationException, IllegalAccessException,
			ClassNotFoundException, InvalidCommandStringException,
			InvalidWordException, NotEnoughParametersException,
			InvalidCommandException {
		Double ret = 0.0;
		if (!listOfWords.remove(0).equals("[")) {
			throw new InvalidSyntaxException();
		}
		while (listOfWords.size() > 0) {
			try {
				ret = evaluateCommand(listOfWords);
			} catch (EndOfStackException e) {
				break;
			}
		}
		return ret;
	}
}
