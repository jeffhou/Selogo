package exceptions;

public class InvalidCommandException extends SlogoException {
	public InvalidCommandException() {
		super("Invalid command!");
	}
}
