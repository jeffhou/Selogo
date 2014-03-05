package commands.commandFactories;

import java.util.HashMap;

import commands.AdvancedCommand;
import commands.Command;

public class TurtleCommandFactory implements CommandFactoryInterface {
	
	private static TurtleCommandFactory instance = new TurtleCommandFactory();
	private HashMap m_CommandMapping = new HashMap();
	
	
	private TurtleCommandFactory(){};
	
	public static TurtleCommandFactory getInstance() {
		return instance;	
	}
	
	

	public void assignCommand(String firstWord, Class commandClass) {
		m_CommandMapping.put(firstWord, commandClass);
	}
	
	
	
	
	@Override
	public Command createCommand(String firstWord) {
		return new TurtleCommand("whatkindofturtlecommand..");
		
	}

}
