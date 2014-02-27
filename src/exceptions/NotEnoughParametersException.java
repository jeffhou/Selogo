package exceptions;

public class NotEnoughParametersException extends SlogoException {
	public NotEnoughParametersException() {
		super("Not enough parameters!");
	}
}
