package commands.commandFactories;

import java.util.HashMap;

import commands.AdvancedCommand;
import commands.Command;

public class BooleanCommandFactory implements CommandFactoryInterface{
	
	private static BooleanCommandFactory instance = new BooleanCommandFactory();
	private HashMap m_CommandMapping = new HashMap();
	
	private BooleanCommandFactory(){};
	
	public static BooleanCommandFactory getInstance() {
		return instance;	
	}
	


	public void assignCommand(String firstWord, Class commandClass) {
		m_CommandMapping.put(firstWord, commandClass);
	}
	
	
	
	
	@Override
	public Command createCommand(String firstWord) {
		return new BooleanCommand("whatkindofbooleancommand..");
		
	}

	
	
}
