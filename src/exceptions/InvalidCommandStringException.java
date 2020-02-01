package exceptions;

public class InvalidCommandStringException extends SlogoException {
  public InvalidCommandStringException() {
    super("Invalid command string!");
  }
}
