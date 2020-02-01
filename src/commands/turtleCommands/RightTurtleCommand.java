package commands.turtleCommands;

import backend.WorldModel; import backend.WorldsCollection;

import commands.TurtleCommand;

public class RightTurtleCommand extends TurtleCommand {

  public RightTurtleCommand() {
    super(1);
  }

  @Override
  public double execute(Object o) {
    WorldModel t = WorldsCollection.getCurrentWorld();
    return t.turnClockwise(parameters.get(0));
  }

}
