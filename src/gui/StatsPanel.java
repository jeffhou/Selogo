package gui;

import backend.WorldsCollection;
import commands.UserCommand;
import java.awt.*;
import java.util.Map;
import javax.swing.*;

/**
 * This menu constantly updates with information about the turtle
 * and shows all user defined variables and commands
 */
public class StatsPanel extends JPanel {

  private JTextArea turtleStatsTextArea;
  private JTextArea variablesTextArea;
  private JTextArea userCommandsTextArea;

  /**
   * Creates the text area that holds all of the turtle statistics
   */
  public StatsPanel() {
    super(new GridBagLayout());
    //this.setBorder(new LineBorder(Color.blue));
    turtleStatsTextArea = new JTextArea(10, 15);
    turtleStatsTextArea.setEditable(false);

    JScrollPane turtleStatsScrollPane = new JScrollPane(turtleStatsTextArea);
    add(turtleStatsScrollPane, SlogoDefaultConstraints.getInstance());

    variablesTextArea = new JTextArea(10, 15);
    variablesTextArea.setEditable(false);
    variablesTextArea.setMaximumSize(getMaximumSize());
    JScrollPane variablesScrollPane = new JScrollPane(variablesTextArea);

    add(variablesScrollPane, SlogoDefaultConstraints.getInstance());

    userCommandsTextArea = new JTextArea(10, 15);
    userCommandsTextArea.setEditable(false);
    userCommandsTextArea.setMaximumSize(getMaximumSize());
    JScrollPane userCommandsScrollPane = new JScrollPane(userCommandsTextArea);
    add(userCommandsScrollPane, SlogoDefaultConstraints.getInstance());
  }

  public void paint(Graphics g) {
    updateTurtleStatsTextArea();
    updateVariablesTextArea();
    updateUserCommandsTextArea();
  }

  private void updateTurtleStatsTextArea() {
    turtleStatsTextArea.setText(
        String.format("Turtle Stats:\n\n%s",
            WorldsCollection.getCurrentWorld().toString()));
  }

  private void updateVariablesTextArea() {
    variablesTextArea.setText(
        String.format("Variables:\n\n%s",
            getVariablesText(
                WorldsCollection.getCurrentWorld().getVariables())));
  }

  private void updateUserCommandsTextArea() {
    userCommandsTextArea.setText(
        String.format("User Commands:\n\n%s",
            getUserCommandsText(
                WorldsCollection.getCurrentWorld().getUserCommands())));
  }

  /**
   * @param variables
   * @return
   * Creates the strings that are printed to display user defined variables
   */
  private String getVariablesText(Map<String, Double> variables) {
    StringBuilder variablesTextBuilder = new StringBuilder();
    for (String variableName : variables.keySet()){
      variablesTextBuilder.append(
          String.format("%s : %f\n",
              variableName,
              variables.get(variableName)));
    }
    return variablesTextBuilder.toString();
  }

  /**
   * @param userCommands
   * @return
   * Creates the strings that are printed to display the user defined commands
   */
  private String getUserCommandsText(
      Map<String, UserCommand> userCommands) {

    StringBuilder userCommandsTextBuilder = new StringBuilder();
    for (String commandString : userCommands.keySet()){
      userCommandsTextBuilder.append(
          String.format("%s : %s\n",
              commandString,
              userCommands.get(commandString).commands));
    }
    return userCommandsTextBuilder.toString();
  }
}

