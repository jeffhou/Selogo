package gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import backend.Interpreter;

public class InterpreterGUI extends JPanel {
	/**
	 * TODO: Add locale-specific data and move all the strings to a resBundle
	 * http://docs.oracle.com/javase/tutorial/i18n/resbundle/ for sake of
	 * practice we can implement pirate or canadian english.
	 */
	protected JTextArea inputTextArea, consoleOutputTextArea;
	protected JTextArea historyTextArea;
	private JButton runButton;
	private final static String newline = "\n";
	protected static Interpreter interpreter;
	static TurtleGUI newTurtleGUI;

	public InterpreterGUI(Interpreter new_interpreter) {
		super(new GridBagLayout());
		/**
		 * TODO: Remove unnecessary whitespace from history, make each entered
		 * set of commands as a clickable link.
		 */
		interpreter = new_interpreter;
		historyTextArea = new JTextArea(25, 20);
		historyTextArea.setEditable(false);
		JScrollPane historyScrollPane = new JScrollPane(historyTextArea);

		inputTextArea = new JTextArea(3, 20);
		inputTextArea.setText("Enter code here...");
		JScrollPane inputScrollPane = new JScrollPane(inputTextArea);

		consoleOutputTextArea = new JTextArea(4, 20);
		consoleOutputTextArea.setEditable(false);
		JScrollPane consoleScrollPane = new JScrollPane(consoleOutputTextArea);

		runButton = new JButton("Run");
		runButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				/**
				 * TODO: make each part of this actionPerformed into a separate
				 * method
				 */
				try {
					/**
					 * TODO: set the console text so that it says what the
					 * engine actually did after each command. A few ways to do
					 * this, this is what I imagined: "sum fd fd 54 rt 15"
					 * yields: """moved forward by 54 moved forward by 54 turned
					 * right by 15 sum of 54 and 15 is 69"""
					 */
					/**
					 * TODO: similarly implement errors in the same way. Of
					 * course error messages should go into the error class and
					 * command messages should go into the command class.
					 */
					consoleOutputTextArea.setText(""
							+ interpreter.interpret(inputTextArea.getText()));
				} catch (Exception e1) {
					e1.printStackTrace();
				}

				String text = inputTextArea.getText();
				historyTextArea.append(text + newline);
				inputTextArea.selectAll();

				// Make sure the new text is visible, even if there
				// was a selection in the text area.
				historyTextArea.setCaretPosition(historyTextArea.getDocument()
						.getLength());
				inputTextArea.requestFocus();
				newTurtleGUI.repaint();
			}
		});

		// Add Components to this panel.
		GridBagConstraints c = new GridBagConstraints();
		c.gridwidth = GridBagConstraints.REMAINDER;

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1.0;
		c.weighty = 1.0;

		add(historyScrollPane, c);
		add(inputScrollPane, c);
		add(runButton, c);
		add(consoleScrollPane, c);
	}

	/**
	 * Create the GUI and show it. For thread safety, this method should be
	 * invoked from the event dispatch thread.
	 */
	private static void createAndShowGUI() {
		// Create and set up the window.
		JFrame frame = new JFrame("TextDemo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel newPanel = new JPanel();

		InterpreterGUI newIntrepreter = new InterpreterGUI(new Interpreter());
		newTurtleGUI = new TurtleGUI(interpreter.engine.turtle);
		newPanel.add(newTurtleGUI);
		// Add contents to the window.
		newPanel.add(newIntrepreter);
		frame.add(newPanel);
		// Display the window.
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		/**
		 * TODO: PULL OUT INTO A MAIN METHOD
		 */
		// Schedule a job for the event dispatch thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
}