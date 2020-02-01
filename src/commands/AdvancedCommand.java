package commands;

public abstract class AdvancedCommand extends Command {
  /**
   * @param numberOfParameters
   * Used to create Advanced Commands
   */
  public AdvancedCommand(int numberOfParameters) {
    super(numberOfParameters, "advanced");
  }

}
