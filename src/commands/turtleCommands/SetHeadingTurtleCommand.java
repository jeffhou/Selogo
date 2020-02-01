package commands.turtleCommands;

import backend.WorldModel; import backend.WorldsCollection;

import commands.TurtleCommand;

public class SetHeadingTurtleCommand extends TurtleCommand {

  public SetHeadingTurtleCommand() {
    super(1);
  }

  @Override
  public double execute(Object o) {
    WorldModel t = WorldsCollection.getCurrentWorld();
    return t.setHeadingTo(parameters.get(0));
  }

}
