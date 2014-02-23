package slogo_team12;

import java.util.ArrayList;
import java.util.HashMap;

import slogo_team12.CommandFactory.InvalidCommandStringException;

public class Interpreter{
	final static String[] TURTLE_COMMANDS = {
		"forward",
		"fd",
		"back",
		"bk",
		"left",
		"lf",
		"right",
		"rt",
		"setheading",
		"seth",
		"towards",
		"setxy",
		"goto",
		"pendown",
		"pd",
		"penup",
		"pu",
		"showturtle",
		"st",
		"hideturtle",
		"ht",
		"home",
		"clearscreen",
		"cs",
		"xcor",
		"ycor",
		"heading",
		"pendown?",
		"pendownp",
		"showing?",
		"showingp"
	};
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
		CommandFactory commandFactory = new CommandFactory(this);
	}
	
	
	
	public ArrayList<String> listOutCommands(String commands){
		ArrayList<String> listOfWords = new ArrayList<String>();
		/**
		 * TODO: Implement multiline feature
		 */
		String[] words = commands.split("^[ \t]+");
		for(String word: words){
			listOfWords.add(word);
		}
		return listOfWords;
		
	}
	public ArrayList<Double> interpret(String text) throws PluralityOfValuesException {
		ArrayList<String> wordList =  listOutCommands(text);
		ArrayList<Double> evaluatedValues = evaluateValue(wordList);
		while(wordList.size() > 0){
			evaluatedValues.add(evaluateCommand(wordList));
		}
		return evaluatedValues;
	}
	
	private Double evaluateCommand(ArrayList<String> wordList) 
			throws InvalidCommandStringException, InvalidWordException, NotEnoughParametersException{
		String firstWord = wordList.remove(0);
		if(isConstantValue(firstWord)){
			return Double.parseDouble(firstWord);
		}else if(isCommand(firstWord)){
			Command newCommand = commandFactory.createCommand(firstWord);
			ArrayList<Double> parameters = new ArrayList<Double>();
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

	public class PluralityOfValuesException extends Exception{}
	public class NotEnoughParametersException extends Exception{}
	public class InvalidWordException extends Exception{}
	
	public ArrayList<Double> evaluateValue(ArrayList<String> words){
		ArrayList<Double> values = new ArrayList<Double>();
		while(words.size() > 0){
			String firstWord = words.remove(0);
			if(isConstantValue(firstWord)){
				values.add(Double.parseDouble(firstWord));
			}else if(isCommand(firstWord)){
				values.add(commandFactory.createCommand(firstWord));
			}
		}
		return values;
		
	}
	private boolean isCommand(String word){
		return commandParameters.containsKey(word);
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
