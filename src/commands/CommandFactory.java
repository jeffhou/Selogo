package commands;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class CommandFactory {
	public ResourceBundle myTranslations;
	public ResourceBundle myCommands;

	public Map<String, Command> commandsUsed;

	
	
	private static final String DEFAULT_RESOURCE_PACKAGE = "util/";
	
	

	
	public CommandFactory() {	
		String language = "English";
		myTranslations = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + language);
		commandsUsed = new HashMap<String, Command>();
		myCommands= ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE+"Command");
	}
	
	private String getTranslatedCommand(String firstWord) {
		return myTranslations.getString(firstWord);
	}
	
	public Command createCommand(String firstWord) throws InstantiationException, IllegalAccessException, ClassNotFoundException
		{
		String translatedCommand = getTranslatedCommand(firstWord);
		Command newCommand;
		
		if (commandsUsed.keySet().contains(translatedCommand) ) {
			newCommand = commandsUsed.get(translatedCommand);
			return newCommand; 
			
		} else {
			
			newCommand = (Command) Class.forName(myCommands.getString(translatedCommand))
					.newInstance();
			commandsUsed.put(translatedCommand, newCommand);
			return newCommand;
			
		}
		 
		
		
	}

	
}
