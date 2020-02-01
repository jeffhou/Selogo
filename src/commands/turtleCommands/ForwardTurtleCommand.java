package commands.turtleCommands;

import util.Tuple;
import backend.WorldModel; import backend.WorldsCollection;
import commands.TurtleCommand;

public class ForwardTurtleCommand extends TurtleCommand {

  public ForwardTurtleCommand() {
    super(1);
  }

  @Override
  public double execute(Object o) {
    WorldModel t = WorldsCollection.getCurrentWorld();
    return t.move(new Tuple(0, parameters.get(0)));
  }

}
