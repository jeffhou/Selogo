package gui;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import exceptions.SlogoException;
import backend.Interpreter;

/**
 * @author Cody Lieu
 * Adds the GUI related aspects related to user input
 */
public class ConsolePanel extends JPanel {
  public Interpreter interpreter;
  private final static String newline = "\n";
  protected JTextArea inputTextArea, consoleOutputTextArea, userHistoryTextArea;

  private JButton runButton;

  /**
   * @throws InstantiationException
   * @throws IllegalAccessException
   * @throws ClassNotFoundException
   * @throws IOException
   * Method to add all sub aspects of the user input aspects of the GUI
   */
  public ConsolePanel() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
    super(new GridBagLayout());
    interpreter = new Interpreter();
    addUserInputHistoryTextArea();
    addUserInputTextArea();
    addRunButton();
    addConsoleOutputTextArea();
    //setPreferredSize(new Dimension(259, 521));

  }

  /**
   * Adds a run button which, when pressed, sends everything
   * in the text box to the parser
   */
  private void addRunButton() {
    runButton = new JButton("Run");
    runButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        try {
          consoleOutputTextArea.setText(""
              + interpreter.interpret(inputTextArea.getText()));
        } catch (SlogoException e1) {
          consoleOutputTextArea.setText("" + e1.getMessage());
        } catch (Exception e1) {
          e1.printStackTrace();
        }

        String userInput = inputTextArea.getText();
        userHistoryTextArea.append(userInput + newline);
        inputTextArea.selectAll();

        // Make sure the new text is visible, even if there
        // was a selection in the text area.
        userHistoryTextArea.setCaretPosition(userHistoryTextArea.getDocument()
            .getLength());

        inputTextArea.requestFocus();

        try {
          SlogoFrame.getInstance().repaint();
        } catch (Exception e1) {
          e1.printStackTrace();
        }
      }
    });

    // Add Components to this panel.

    add(runButton, SlogoDefaultConstraints.getInstance());
  }
  /**
   * Outputs feedback for the results of the command entered by the user
   */
  private void addConsoleOutputTextArea() {
    consoleOutputTextArea = new JTextArea(5, 18);
    consoleOutputTextArea.setEditable(false);

    JScrollPane consoleScrollPane = new JScrollPane(consoleOutputTextArea);
    add(consoleScrollPane, SlogoDefaultConstraints.getInstance());
  }
  /**
   * This is where the user types in his commands.
   * Everything in this textbox is sent to the parser
   * when the run button is pressed
   */
  private void addUserInputTextArea() {
    inputTextArea = new JTextArea(5, 18);
    inputTextArea.setText("Enter code here...");
    ;
    JScrollPane inputScrollPane = new JScrollPane(inputTextArea);
    add(inputScrollPane, SlogoDefaultConstraints.getInstance());
  }
  /**
   * Shows the full history of all the commands the user entered
   */
  private void addUserInputHistoryTextArea(){
    userHistoryTextArea = new JTextArea(20, 20);
    userHistoryTextArea.setEditable(false);
    JScrollPane userHistoryScrollPane = new JScrollPane(userHistoryTextArea);
    add(userHistoryScrollPane, SlogoDefaultConstraints.getInstance());
  }
}
