package backend;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import commands.Command;
import commands.CommandFactory;
import commands.CommandInvoker;
import commands.CommandTranslator;
import commands.UserCommand;
import exceptions.EndOfStackException;
import exceptions.InvalidCommandException;
import exceptions.InvalidCommandStringException;
import exceptions.InvalidSyntaxException;
import exceptions.InvalidWordException;
import exceptions.NotEnoughParametersException;
import exceptions.SlogoException;
import exceptions.VariableNotFoundException;

public class Interpreter {
  /**
   * TODO: change the methods so that this looks like a real API
   * TODO: Make documentation for all public methods and vars (all classes)
   * TODO: AdvancedCommands such as If and Repeat must return appropriate values
   */
  private CommandFactory commandFactory;
  private CommandInvoker commandInvoker;
  private Map<String, Double> variables = new HashMap<String, Double>();
  private Map<String, UserCommand> userCommands = new HashMap<String, UserCommand>();
  private ArrayList<String> listOfWords;
  CommandTranslator commandTranslator;

  public Interpreter() throws IOException, InstantiationException,
  IllegalAccessException, ClassNotFoundException {
    commandInvoker = new CommandInvoker(this);
    commandFactory = new CommandFactory();
    commandTranslator = new CommandTranslator();
  }

  /**
   * @param wordList
   * @return
   * @throws Exception
   * Parses the list of words that the user enters in the input text box
   */
  private Double evaluateCommand(ArrayList<String> wordList) throws Exception {

    String firstWord = wordList.remove(0);
    if (isConstantValue(firstWord)) {
      return Double.parseDouble(firstWord);
    } else if (isCommand(firstWord)) {
      firstWord = firstWord.toLowerCase();
      ArrayList<Double> parameters = new ArrayList<Double>();
      Command newCommand = commandFactory.createCommand(commandTranslator.translateCommand(firstWord));
      for (int i = 0; i < newCommand.NUM_OF_PARAMETERS; i++) {
        if (wordList.size() > 0) {
          parameters.add(evaluateCommand(wordList));
        } else {
          throw new NotEnoughParametersException();
        }
      }
      newCommand.loadParameters(parameters);
      return commandInvoker.obey(newCommand);
    } else if (isVariable(firstWord)) {
      return getVariable(firstWord.substring(1));
    } else if (isUserCommand(firstWord)) {
      return getAndExecuteUserCommand(firstWord);
    } else {
      throw new InvalidWordException();
    }
  }

  /**
   * @param text
   * @return
   * @throws Exception
   * Creates ArrayList of all evaluated commands
   */
  public ArrayList<Double> interpret(String text) throws Exception {
    text = text.trim();
    listOutCommands(text);
    ArrayList<Double> evaluatedValues = new ArrayList<Double>();
    while (listOfWords.size() > 0) {
      try {
        evaluatedValues.add(evaluateCommand(listOfWords));
      } catch (EndOfStackException e) {
        System.out.println("caught");
      }
    }
    return evaluatedValues;
  }

  /**
   * @param commandName
   * @return
   * @throws Exception
   * Executes command inputed by the user
   * Creates two maps of strings to their respective commands
   * and strings to their respective variables
   */
  private double getAndExecuteUserCommand(String commandName) throws Exception {
    /**
     * TODO: Correctly implement return value
     */
    UserCommand command;
    Map<String, UserCommand> userCommands = WorldsCollection.getCurrentWorld().getUserCommands();
    Map<String, Double> variables = WorldsCollection.getCurrentWorld().getVariables();
    try {
      command = userCommands.get(commandName);
    } catch (Exception e) {
      throw new InvalidCommandException();
    }
    try { // Set parameters to appropriate variables
      ArrayList<Double> userCommandParameters = new ArrayList<Double>();
      for(int i = 0; i < command.parameters.size(); i++) {
        if (listOfWords.size() > 0) {
          double temp = evaluateCommand(listOfWords);
          userCommandParameters.add(temp);
        }
        else {
          throw new NotEnoughParametersException();
        }
      }
      for (int i = 0; i < command.parameters.size(); i++) {
        String temp1 = command.parameters.get(i).substring(1);
        double temp2 = userCommandParameters.remove(0);
        System.out.println(temp1 + " \n" + temp2);
        variables.put(temp1, temp2);
      }
    } catch (Exception e) {
      throw new InvalidSyntaxException();
    }
    addCommandToQueue(command.commands);
    return 1;
  }

  /**
   * @param word
   * @return
   * Checks if the string entered is a valid command
   */
  private boolean isCommand(String word) {
    //check if it is in our language resource bundle
    try {
      commandTranslator.translateCommand(word);
      return true;
    }
    catch (MissingResourceException c){
      return false;
    }
  }

  /**
   * @return
   * Returns the current world used by the tab
   */
  public WorldModel getCurrentWorld() {
    return WorldsCollection.getCurrentWorld();
  }

  /**
   * @param word
   * @return
   * Checks if string is user defined command
   */
  private boolean isUserCommand(String word) {
    Map<String, UserCommand> userCommands = WorldsCollection.getCurrentWorld().getUserCommands();
    return userCommands.containsKey(word);
  }

  /**
   * @param word
   * @return
   * Checks if parameter is a constant value
   */
  private boolean isConstantValue(String word) {
    try {
      Double.parseDouble(word);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  /**
   * @param word
   * @return
   * @throws SlogoException
   * Checks if entered paramter is a user created variable
   */
  private boolean isVariable(String word) throws SlogoException {
    Map<String, Double> variables = WorldsCollection.getCurrentWorld().getVariables();

    if (word.startsWith(":")) {
      if (!variables.containsKey(word.substring(1))) {
        throw new VariableNotFoundException();
      } else {
        return true;
      }
    }
    return false;
  }

  /**
   * @param commands
   * Adds all commands to a list
   */
  public void listOutCommands(String commands) {
    listOfWords = new ArrayList<String>();
    String[] words = commands.split("[\\s\\n]+");
    for (String word : words) {
      listOfWords.add(word);
    }

  }

  /**
   * @return
   * @throws InvalidSyntaxException
   * Parses and evaluates the input between brackets
   */
  public ArrayList<String> readBrackets() throws InvalidSyntaxException {
    /**
     * TODO: Fix glitch with close bracket not being separated by a space
     */
    if (!listOfWords.remove(0).equals("[")) {
      throw new InvalidSyntaxException();
    }
    int bracketCounter = 1;
    ArrayList<String> ret = new ArrayList<String>();

    while (bracketCounter != 0) {
      String nextWord = listOfWords.remove(0);
      if (nextWord.startsWith("[")) {
        bracketCounter++;
      }
      if (nextWord.endsWith("]")) {
        bracketCounter--;
      }
      ret.add(nextWord);
    }

    ret.remove(ret.size()-1);
    return ret;
  }

  /**
   * @return
   * Removes the first index in the list of commands
   * so the next command is evaluated
   */
  public String readNextCommand() {
    return listOfWords.remove(0);
  }

  /**
   * @param commands
   * Adds commands to execute in a queue
   */
  public void addCommandToQueue(ArrayList<String> commands) {
    listOfWords.addAll(0, commands);
  }

  /**
   * @param name
   * @return
   * @throws Exception
   * Creates a variable that the user defines in the map
   */
  public double addVariable(String name) throws Exception {
    Map<String, Double> variables = WorldsCollection.getCurrentWorld().getVariables();
    double value = evaluateCommand(listOfWords);
    variables.put(name, value);
    return value;
  }

  /**
   * @param name
   * @param value
   * @return
   * Creates variable given the name of the variable and the value
   */
  public double addVariable(String name, double value) {
    Map<String, Double> variables = WorldsCollection.getCurrentWorld().getVariables();
    variables.put(name, value);
    return value;
  }

  /**
   * @param s
   * @return
   * Returns the value of the variable if it
   * has been previously created by the user
   */
  public double getVariable(String s) {
    Map<String, Double> variables = WorldsCollection.getCurrentWorld().getVariables();
    if (variables.containsKey(s)) {
      return variables.get(s);
    } else {
      return 0;
    }
  }

  /**
   * @param commandName
   * @param command
   * @return
   * Adds new user defined command
   */
  public double addUserCommand(String commandName, UserCommand command) {
    Map<String, UserCommand> userCommands = WorldsCollection.getCurrentWorld().getUserCommands();
    userCommands.put(commandName, command);
    return 1;
  }
}
