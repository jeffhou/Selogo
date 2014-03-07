package commands;

import java.util.ResourceBundle;

public class CommandFactory {
	public ResourceBundle myTranslations;
	public ResourceBundle myCommands;
	private static final String DEFAULT_RESOURCE_PACKAGE = "util/";
	
	public CommandFactory() {	
		String language = "English";
		myTranslations = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + language);
		myCommands= ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE+"Command");
	}
	
	private String getTranslatedCommand(String firstWord) {
		return myTranslations.getString(firstWord);
	}
	
	public Command createCommand(String firstWord) throws InstantiationException, IllegalAccessException, ClassNotFoundException
		{
		
		String translatedCommand = getTranslatedCommand(firstWord); 
		return (Command) Class.forName(myCommands.getString(translatedCommand))
		.newInstance();
		
	}

	
}
