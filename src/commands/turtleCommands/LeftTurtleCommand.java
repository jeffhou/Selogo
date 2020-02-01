package commands.turtleCommands;

import backend.WorldModel; import backend.WorldsCollection;

import commands.TurtleCommand;

public class LeftTurtleCommand extends TurtleCommand {

  public LeftTurtleCommand() {
    super(1);
  }

  @Override
  public double execute(Object o) {
    WorldModel t = WorldsCollection.getCurrentWorld();
    return -t.turnClockwise(-parameters.get(0));
  }

}
