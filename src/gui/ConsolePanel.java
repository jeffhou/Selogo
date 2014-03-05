package gui;

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

public class ConsolePanel extends JPanel {
	public Interpreter interpreter;
	private final static String newline = "\n";
	protected  JPopupMenu popUp;

	protected JTextArea userHistoryTextArea;
	protected JTextArea inputTextArea, consoleOutputTextArea;

	private JButton runButton;
	public ConsolePanel() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		super(new GridBagLayout());
		
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
					SlogoFrame.getInstance().repaint();
				} catch (InstantiationException | IllegalAccessException
						| ClassNotFoundException | IOException e1) {
					e1.printStackTrace();
				}
			}
		});

		// Add Components to this panel.
		
		add(runButton, SlogoDefaultConstraints.getInstance());
	}
	private void addConsoleOutputTextArea() {
		consoleOutputTextArea = new JTextArea(5, 20);
		consoleOutputTextArea.setEditable(false);
		JScrollPane consoleScrollPane = new JScrollPane(consoleOutputTextArea);
		add(consoleScrollPane, SlogoDefaultConstraints.getInstance());
	}
	private void addUserInputTextArea() {
		inputTextArea = new JTextArea(5, 20);
		inputTextArea.setText("Enter code here...");
		JScrollPane inputScrollPane = new JScrollPane(inputTextArea);
		add(inputScrollPane, SlogoDefaultConstraints.getInstance());
	}
	private void addUserInputHistoryTextArea(){
		userHistoryTextArea = new JTextArea(20, 20);
		userHistoryTextArea.setEditable(false);
		JScrollPane userHistoryScrollPane = new JScrollPane(userHistoryTextArea);
		add(userHistoryScrollPane, SlogoDefaultConstraints.getInstance());
	}
}