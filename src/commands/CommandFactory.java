package commands;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class CommandFactory {
	public ResourceBundle myTranslations;
	public ResourceBundle myCommands;
	public Map<String, Command> commands;
	private static CommandFactory instance = new CommandFactory(); 
	
	
	private static final String DEFAULT_RESOURCE_PACKAGE = "util/";
	
	
	private CommandFactory() {	
		commands = new HashMap<String, Command>();
		String language = "English";
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
		Command newCommand;
		
		if (commands.keySet().contains(translatedCommand) ) {
			newCommand = commands.get(translatedCommand);
			return newCommand; 
			
		} else {
			
			newCommand = (Command) Class.forName(myCommands.getString(translatedCommand))
					.newInstance();
			commands.put(translatedCommand, newCommand);
			return newCommand;
			
		}
		 
		
		
	}

	
}
