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

import exceptions.SlogoException;
import main.Runner;
import gui.WorldGraphicsPanel;
import gui.menubar.MenuBar;
import backend.Interpreter;

public class ConsolePanel extends JPanel {
	public Interpreter interpreter;
	private final static String newline = "\n";
	protected  JPopupMenu popUp;

	protected JTextArea userHistoryTextArea;

	/**
	 * TODO: Add locale-specific data and move all the strings to a resBundle
	 * http://docs.oracle.com/javase/tutorial/i18n/resbundle/ for sake of
	 * practice we can implement pirate or canadian english.
	 */

	protected JTextArea inputTextArea, consoleOutputTextArea;

	private JButton runButton;
	GridBagConstraints c;
	public ConsolePanel() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		super(new GridBagLayout());
		
		setUpConstraints();
		
		interpreter = new Interpreter();
		addUserInputHistoryTextArea();
		addUserInputTextArea();
		addRunButton();
		addConsoleOutputTextArea();
	}
	
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
					SlogoFrame.getInstance().updateTurtleGUI();
					SlogoFrame.getInstance().turtleStatsGUI.repaint();
				} catch (InstantiationException | IllegalAccessException
						| ClassNotFoundException | IOException e1) {
					e1.printStackTrace();
				}
			}
		});

		// Add Components to this panel.
		
		add(runButton, c);
	}
	private void addConsoleOutputTextArea() {
		consoleOutputTextArea = new JTextArea(5, 20);
		consoleOutputTextArea.setEditable(false);
		JScrollPane consoleScrollPane = new JScrollPane(consoleOutputTextArea);
		add(consoleScrollPane, c);
	}
	private void addUserInputTextArea() {
		inputTextArea = new JTextArea(5, 20);
		inputTextArea.setText("Enter code here...");
		JScrollPane inputScrollPane = new JScrollPane(inputTextArea);
		add(inputScrollPane, c);
	}
	private void setUpConstraints() {
		c = new GridBagConstraints();
		c.gridwidth = GridBagConstraints.REMAINDER;

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1.0;
		c.weighty = 1.0;
	}
	private void addUserInputHistoryTextArea(){
		userHistoryTextArea = new JTextArea(20, 20);
		userHistoryTextArea.setEditable(false);
		JScrollPane userHistoryScrollPane = new JScrollPane(userHistoryTextArea);
		add(userHistoryScrollPane, c);
	}
}