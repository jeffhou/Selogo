package commands.commandFactories;

import commands.AdvancedCommand;
import commands.Command;

public class BooleanCommandFactory implements CommandFactoryInterface{
	
	private static BooleanCommandFactory instance = new BooleanCommandFactory();
	private BooleanCommandFactory(){};
	
	public static BooleanCommandFactory getInstance() {
		return instance;	
	}
	

	@Override
	public Command createCommand(String firstWord) {
		return new BooleanCommand("whatkindofbooleancommand..");
		
	}

	
	
}
