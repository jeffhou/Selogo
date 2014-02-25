package commands;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;




import backend.Engine;
import backend.Interpreter;
import exceptions.InvalidCommandStringException;

public class CommandFactory {

	final static String[] TURTLE_COMMANDS = { "forward", "fd", "back", "bk",
			"left", "lt", "right", "rt", "setheading", "seth", "towards",
			"setxy", "goto", "pendown", "pd", "penup", "pu", "showturtle",
			"st", "hideturtle", "ht", "home", "clearscreen", "cs", "xcor",
			"ycor", "heading", "pendown?", "pendownp", "showing?", "showingp" };
	Interpreter interpreter;
	Engine engine;
	public Map<String, String> commands = new HashMap<String, String>();
	private static final String DEFAULT_RESOURCE_PACKAGE = "res.";
	private ResourceBundle myResources;
	

	
	public void populateCommandMap() throws IOException{
		myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + "Command");
		
		
		//delete implementedCommands and replace implementedCommands with TURTLE_COMMANDS in forloop once all commands are implemented.
		String [] implementedCommands = {"forward", "fd", "bk", "back", "lt", "left", "rt","right", 
				"seth", "setheading", "goto","setxy", "pd", "pendown", "pu", "penup", "st", 
				"showturtle", "ht", "hideturtle","home", "cs","clearscreen"};
		for (String command: implementedCommands) {
			commands.put(command, myResources.getString(command));
		}
		
	}

	public CommandFactory(Interpreter interpreter, Engine engine){
		this.interpreter = interpreter;
		this.engine = engine;
		/**
		 * TODO: this is duplicate code. Create a properties file or an XML file
		 * and make the factory read it instead.
		 */
		
		try {
			populateCommandMap();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public Command createCommand(String firstWord)
			throws InvalidCommandStringException, InstantiationException,
			IllegalAccessException, ClassNotFoundException {
		if (commands.containsKey(firstWord)) {
			return (Command) Class.forName(commands.get(firstWord))
					.newInstance();
		}
		throw new InvalidCommandStringException();
	}

}
