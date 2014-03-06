package commands.commandFactories;

import java.util.HashMap;

import commands.AdvancedCommand;
import commands.Command;

public class MathCommandFactory implements CommandFactoryInterface {
	
	
	private static MathCommandFactory instance = new MathCommandFactory();
	private HashMap m_CommandMapping = new HashMap();
	
	
	private MathCommandFactory(){};
	
	public static MathCommandFactory getInstance() {
		return instance;	
	}
	


	public void assignCommand(String firstWord, Class commandClass) {
		m_CommandMapping.put(firstWord, commandClass);
	}
	
	
	
	@Override
	public Command createCommand(String firstWord) {
		 
		return new MathCommand("whatkindofmathcommand..");
	}

}
