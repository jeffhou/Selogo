package slogo_team12;

import java.util.ArrayList;
import java.util.HashMap;

import exceptions.*;
public class Interpreter{
	final static String[] MATH_COMMANDS = {
		"sum",
		"+",
		"difference",
		"-",
		"product",
		"*",
		"quotient",
		"/",
		"remainder",
		"%",
		"minus",
		"~",
		"random",
		"sin",
		"cos",
		"tan",
		"atan",
		"log",
		"pow",
		"less?",
		"lessp",
		"greater?",
		"greaterp",
		"equal?",
		"equalp",
		"notequal?",
		"notequalp",
		"and",
		"or",
		"not?"
	};
	/**
	 * TODO: add in advanced commands
	 */
	CommandFactory commandFactory;
	Engine engine;
	public Interpreter(){
		engine = new Engine();
		commandFactory = new CommandFactory(this, engine);
	}
	public ArrayList<Double> interpret(String text)
			throws PluralityOfValuesException, InvalidCommandStringException, InvalidWordException, NotEnoughParametersException, InvalidCommandException {
		ArrayList<String> wordList =  listOutCommands(text);
		ArrayList<Double> evaluatedValues = new ArrayList<Double>();
		while(wordList.size() > 0){
			evaluatedValues.add(evaluateCommand(wordList));
		}
		return evaluatedValues;
	}
	public ArrayList<String> listOutCommands(String commands){
		ArrayList<String> listOfWords = new ArrayList<String>();
		/**
		 * TODO: Implement multiline feature
		 */
		String[] words = commands.split(" ");
		for(String word: words){
			listOfWords.add(word);
		}
		return listOfWords;

	}

	private Double evaluateCommand(ArrayList<String> wordList) 
			throws InvalidCommandStringException, InvalidWordException, NotEnoughParametersException, InvalidCommandException{
		String firstWord = wordList.remove(0);
		if(isConstantValue(firstWord)){
			return Double.parseDouble(firstWord);
		}else if(isCommand(firstWord)){
			ArrayList<Double> parameters = new ArrayList<Double>();
			Command newCommand = commandFactory.createCommand(firstWord);
			for(int i = 0; i < newCommand.NUM_OF_PARAMETERS; i++){
				if(wordList.size() > 0){
					parameters.add(evaluateCommand(wordList));
				}else{
					throw new NotEnoughParametersException();
				}
			}
			newCommand.loadParameters(parameters);
			return engine.obey(newCommand);
		}else{
			throw new InvalidWordException();
		}
	}

	private boolean isCommand(String word){
		return commandFactory.commandParameters.containsKey(word);
	}

	private boolean isConstantValue(String word){
		try{
			Double.parseDouble(word);
			return true;
		}catch(Exception e){
			return false;
		}
	}
}
