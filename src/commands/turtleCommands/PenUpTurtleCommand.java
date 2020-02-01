package commands.turtleCommands;

import backend.WorldModel; import backend.WorldsCollection;

import commands.TurtleCommand;

public class PenUpTurtleCommand extends TurtleCommand {

  public PenUpTurtleCommand() {
    super(0);
  }

  @Override
  public double execute(Object o) {
    WorldModel t = WorldsCollection.getCurrentWorld();
    t.setPen(false);
    return 0;
  }

}
