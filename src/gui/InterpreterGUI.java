package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import gui.TurtleGUI;
import gui.menubar.MenuBar;
import Main.Main;
import backend.Interpreter;

public class InterpreterGUI extends JPanel {
	public  Interpreter interpreter;
	private final static String newline = "\n";
	protected  JPopupMenu popUp;
	public static  TurtleStatsGUI turtleStatsGUI;

	protected JTextArea historyTextArea;

	/**
	 * TODO: Add locale-specific data and move all the strings to a resBundle
	 * http://docs.oracle.com/javase/tutorial/i18n/resbundle/ for sake of
	 * practice we can implement pirate or canadian english.
	 */

	protected JTextArea inputTextArea, consoleOutputTextArea;

	private JButton runButton;

	public InterpreterGUI() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		super(new GridBagLayout());
		
		/**
		 * TODO: make each entered set of commands as a clickable link.
		 */
		interpreter = new Interpreter();
		historyTextArea = new JTextArea(20, 20);
		historyTextArea.setEditable(false);
		JScrollPane historyScrollPane = new JScrollPane(historyTextArea);

		inputTextArea = new JTextArea(5, 20);
		inputTextArea.setText("Enter code here...");
		JScrollPane inputScrollPane = new JScrollPane(inputTextArea);

		consoleOutputTextArea = new JTextArea(5, 20);
		consoleOutputTextArea.setEditable(false);
		JScrollPane consoleScrollPane = new JScrollPane(consoleOutputTextArea);

		runButton = new JButton("Run");
		turtleStatsGUI = new TurtleStatsGUI(interpreter.engine.turtle.stringify());
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
					consoleOutputTextArea.setText(""
							+ interpreter.interpret(inputTextArea.getText()));
				} catch (Exception e1) {
					consoleOutputTextArea.setText("" + e1.getMessage());
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
				Main.updateTurtleGUI();
				turtleStatsGUI.removeAll();
				turtleStatsGUI.updateTurtle(interpreter.engine.turtle.stringify());
				turtleStatsGUI.repaint();
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
}