package commands.commandFactories;

import commands.AdvancedCommand;
import commands.Command;

public class MathCommandFactory implements CommandFactoryInterface {
	
	
	private static MathCommandFactory instance = new MathCommandFactory();
	private MathCommandFactory(){};
	
	public static MathCommandFactory getInstance() {
		return instance;	
	}
	

	@Override
	public Command createCommand(String firstWord) {
		 
		return new MathCommand("whatkindofmathcommand..");
	}

}
