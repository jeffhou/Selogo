package slogo_team12;

import commands.Command;

import exceptions.InvalidCommandException;

public class Engine {
	Turtle turtle;
	Engine(){
		turtle = new Turtle();
	}
	public double obey(Command newCommand) throws InvalidCommandException {
		if(newCommand.COMMAND_TYPE.equals("turtle")){
			return newCommand.execute(turtle);
		}
		throw new InvalidCommandException();
	}

	public Turtle getTurtle() {
		return turtle;
	}

}
