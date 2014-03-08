package backend;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import commands.Command;
import commands.CommandFactory;
import commands.CommandInvoker;
import commands.CommandTranslator;
import commands.UserCommand;
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
	 * TODO: Make documentation for all public methods and vars (all classes)
	 * TODO: AdvancedCommands such as If and Repeat must return appropriate values
	 */



	private CommandFactory commandFactory;
	private CommandInvoker commandInvoker;
	private Map<String, Double> variables = new HashMap<String, Double>();
	private Map<String, UserCommand> userCommands = new HashMap<String, UserCommand>();
	private ArrayList<String> listOfWords;
	CommandTranslator commandTranslator;





	public Interpreter() throws IOException, InstantiationException,
	IllegalAccessException, ClassNotFoundException {
		commandInvoker = new CommandInvoker(this);
		commandFactory = new CommandFactory();
		commandTranslator = new CommandTranslator();
	}

	private Double evaluateCommand(ArrayList<String> wordList) throws Exception {

		String firstWord = wordList.remove(0);
		if (isConstantValue(firstWord)) {
			return Double.parseDouble(firstWord);
		} else if (isCommand(firstWord)) {
			firstWord = firstWord.toLowerCase();
			ArrayList<Double> parameters = new ArrayList<Double>();
			Command newCommand = commandFactory.createCommand(commandTranslator.translateCommand(firstWord));
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

	public ArrayList<Double> interpret(String text) throws Exception {
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

	private double getAndExecuteUserCommand(String commandName) throws Exception {
		/**
		 * TODO: Correctly implement return value
		 */
		UserCommand command;
		Map<String, UserCommand> userCommands = WorldsCollection.getInstance().getCurrentWorld().getUserCommands();
		Map<String, Double> variables = WorldsCollection.getInstance().getCurrentWorld().getVariables();
		try {
			command = userCommands.get(commandName);
		} catch (Exception e) {
			throw new InvalidCommandException();
		}
		try { // Set parameters to appropriate variables
			ArrayList<Double> userCommandParameters = new ArrayList<Double>();
			for(int i = 0; i < command.parameters.size(); i++) {
				if (listOfWords.size() > 0) {
					double temp = evaluateCommand(listOfWords);
					userCommandParameters.add(temp);
				}
				else {
					throw new NotEnoughParametersException();
				}
			}
			for (int i = 0; i < command.parameters.size(); i++) {
				String temp1 = command.parameters.get(i).substring(1);
				double temp2 = userCommandParameters.remove(0);
				System.out.println(temp1 + " \n" + temp2);
				variables.put(temp1, temp2);
			}
		} catch (Exception e) {
			throw new InvalidSyntaxException();
		}
		addCommandToQueue(command.commands);
		return 1;
	}

	private boolean isCommand(String word) {
		//check if it is in our language resource bundle
		try {
			String translatedWord = commandTranslator.translateCommand(word);

			return true;
		}
		catch (MissingResourceException c){
			return false;
		}
	}
	
	public WorldModel getCurrentWorld() {
		return WorldsCollection.getInstance().getCurrentWorld();
	}

	private boolean isUserCommand(String word) {
		Map<String, UserCommand> userCommands = WorldsCollection.getInstance().getCurrentWorld().getUserCommands();
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
		Map<String, Double> variables = WorldsCollection.getInstance().getCurrentWorld().getVariables();

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

	public ArrayList<String> readBrackets() throws InvalidSyntaxException {
		/**
		 * TODO: Fix glitch with close bracket not being separated by a space
		 */
		if (!listOfWords.remove(0).equals("[")) {
			throw new InvalidSyntaxException();
		}
		int bracketCounter = 1;
		ArrayList<String> ret = new ArrayList<String>();

		while (bracketCounter != 0) {
			String nextWord = listOfWords.remove(0);
			if (nextWord.startsWith("[")) {
				bracketCounter++;
			}
			if (nextWord.endsWith("]")) {
				bracketCounter--;
			}
			ret.add(nextWord);
		}

		ret.remove(ret.size()-1);
		return ret;
	}

	public String readNextCommand() {
		return listOfWords.remove(0);
	}

	public void addCommandToQueue(ArrayList<String> commands) {
		listOfWords.addAll(0, commands);
	}

	public double addVariable(String name) throws Exception {
		Map<String, Double> variables = WorldsCollection.getInstance().getCurrentWorld().getVariables();
		double value = evaluateCommand(listOfWords);
		variables.put(name, value);
		return value;
	}

	public double addVariable(String name, double value) {
		Map<String, Double> variables = WorldsCollection.getInstance().getCurrentWorld().getVariables();
		variables.put(name, value);
		return value;
	}

	public double getVariable(String s) {
		Map<String, Double> variables = WorldsCollection.getInstance().getCurrentWorld().getVariables();
		if (variables.containsKey(s)) {
			return variables.get(s);
		} else {
			return 0;
		}
	}

	public double addUserCommand(String commandName, UserCommand command) {
		Map<String, UserCommand> userCommands = WorldsCollection.getInstance().getCurrentWorld().getUserCommands();
		userCommands.put(commandName, command);
		return 1;
	}
}
