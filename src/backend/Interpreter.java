package backend;

import java.io.IOException;
import java.util.ArrayList;

import commands.Command;
import commands.CommandFactory;
import exceptions.*;

public class Interpreter {
	/**
	 * TODO: change the methods so that this looks like a real API TODO: Make
	 * documentation for all public methods and vars (all classes)
	 */
	CommandFactory commandFactory;
	public Engine engine;
	public Interpreter() throws IOException {
		engine = new Engine(this);
		commandFactory = new CommandFactory(this, engine);
	}

	public ArrayList<Double> interpret(String text)
			throws PluralityOfValuesException, InvalidCommandStringException,
			InvalidWordException, NotEnoughParametersException,
			InvalidCommandException, InstantiationException,
			IllegalAccessException, ClassNotFoundException,
			InvalidSyntaxException {
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
	
	public double readBrackets() throws InvalidSyntaxException, InstantiationException, IllegalAccessException, ClassNotFoundException, InvalidCommandStringException, InvalidWordException, NotEnoughParametersException, InvalidCommandException{
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
	
	public ArrayList<String> listOfWords;

	public void listOutCommands(String commands) {
		listOfWords = new ArrayList<String>();
		String[] words = commands.split("\\s+");
		for (String word : words) {
			listOfWords.add(word);
		}

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
}
