package exceptions;

public class InvalidWordException extends SlogoException {
  public InvalidWordException() {
    super("Invalid word!");
  }
}
