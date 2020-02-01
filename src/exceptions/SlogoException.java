package exceptions;

public abstract class SlogoException extends Exception {
  public SlogoException(String Alertstring) {
    super(Alertstring);
  }
}
