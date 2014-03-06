package commands;

import java.util.HashMap;
import java.util.Locale;
import java.util.ResourceBundle;

import parser.XMLReader;
import backend.Interpreter;
import exceptions.InvalidCommandStringException;

public class CommandFactory {
	public ResourceBundle myTranslations;
	public ResourceBundle myCommands;
	private static CommandFactory instance = new CommandFactory(); 
	
	
	private static final String DEFAULT_RESOURCE_PACKAGE = "util/";
	
	private CommandFactory() {	
		String language = "French";
		myTranslations = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + language);
		myCommands= ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE+"Command");
	}
	
	private String getTranslatedCommand(String firstWord) {
		return myTranslations.getString(firstWord);
	}
	
	
	public static CommandFactory getInstance() 
	{
		return instance;
	}
	

	public Command createCommand(String firstWord) throws InstantiationException, IllegalAccessException, ClassNotFoundException
		{
		
		String translatedCommand = getTranslatedCommand(firstWord); 
		return (Command) Class.forName(myCommands.getString(translatedCommand))
		.newInstance();
		
	}

	
}
