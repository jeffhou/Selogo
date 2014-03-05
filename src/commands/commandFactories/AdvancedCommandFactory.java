package commands.commandFactories;

import java.util.HashMap;

import commands.*;

public class AdvancedCommandFactory implements CommandFactoryInterface {

	private static AdvancedCommandFactory instance = new AdvancedCommandFactory();
	private HashMap m_CommandMapping = new HashMap();
	
	private AdvancedCommandFactory(){};
	
	
	
	public static AdvancedCommandFactory getInstance() {
		return instance;	
	}
	 

	public void assignCommand(String firstWord, Class commandClass) {
		m_CommandMapping.put(firstWord, commandClass);
	}
	
	
	
	@Override
	public Command createCommand(String firstWord) {
		return ((Command)m_CommandMapping.get(firstWord)).createCommand();
		
	}

}
