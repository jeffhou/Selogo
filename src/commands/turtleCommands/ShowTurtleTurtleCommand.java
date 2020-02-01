package commands.turtleCommands;

import java.util.ArrayList;

import backend.TurtleModel;
import backend.WorldModel; import backend.WorldsCollection;
import commands.TurtleCommand;

public class ShowTurtleTurtleCommand extends TurtleCommand {

  public ShowTurtleTurtleCommand() {
    super(0);
  }

  @Override
  public double execute(Object o) {
    WorldModel t = WorldsCollection.getCurrentWorld();
    ArrayList<TurtleModel> turtleList = t.getActiveTurtles();
    for(TurtleModel turtle : turtleList) {
      turtle.show();
    }
    return 0;
  }
}
