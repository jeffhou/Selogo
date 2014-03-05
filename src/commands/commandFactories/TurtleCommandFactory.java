package commands.commandFactories;

import commands.AdvancedCommand;
import commands.Command;

public class TurtleCommandFactory implements CommandFactoryInterface {
	
	private static TurtleCommandFactory instance = new TurtleCommandFactory();
	private TurtleCommandFactory(){};
	
	public static TurtleCommandFactory getInstance() {
		return instance;	
	}
	
	
	@Override
	public Command createCommand(String firstWord) {
		return new TurtleCommand("whatkindofturtlecommand..");
		
	}

}
