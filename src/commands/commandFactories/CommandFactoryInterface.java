package commands.commandFactories;

import commands.Command;

public interface CommandFactoryInterface {
	Command createCommand(String string);

}
