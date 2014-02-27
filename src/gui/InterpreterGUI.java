package gui;

import java.awt.Desktop;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import backend.Interpreter;

public class InterpreterGUI extends JPanel {
	protected static Interpreter interpreter;
	protected static JMenuBar menuBar = new JMenuBar();
	private final static String newline = "\n";
	static TurtleGUI newTurtleGUI;
	protected static JPopupMenu popUp;

	protected JTextArea historyTextArea;

	/**
	 * TODO: Add locale-specific data and move all the strings to a resBundle
	 * http://docs.oracle.com/javase/tutorial/i18n/resbundle/ for sake of
	 * practice we can implement pirate or canadian english.
	 */

	protected JTextArea inputTextArea, consoleOutputTextArea;

	private JButton runButton;

	public InterpreterGUI(Interpreter new_interpreter) {
		super(new GridBagLayout());
		/**
		 * TODO: make each entered set of commands as a clickable link.
		 */
		interpreter = new_interpreter;
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

	private static void helpMenu() {

		// Build the first menu.
		JMenu help = new JMenu("Help");

		// Submenu
		JMenuItem helpSubMenu = new JMenuItem("Help Menu");
		help.add(helpSubMenu);
		menuBar.add(help);

		helpSubMenu.addMouseListener(new MouseAdapter() {

			public void mousePressed(MouseEvent e) {
				File file = new File("src/help.html");
				Desktop desktop = Desktop.getDesktop();
				try {
					desktop.open(file);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}

		});

	}

	private static void turtleMenu() {
		JMenu turtle = new JMenu("Turtle");

		JMenuItem turtlePreferences = new JMenuItem("Preferences");
		turtlePreferences.addMouseListener(new MouseAdapter() {

			public void mousePressed(MouseEvent e) {
				File file = new File("src/help.html");
				Desktop desktop = Desktop.getDesktop();
				try {
					desktop.open(file);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}

		});
		JMenuItem turtleStats = new JMenuItem("Stats");
		turtle.add(turtlePreferences);
		turtle.add(turtleStats);
		menuBar.add(turtle);
	}

	/**
	 * Create the GUI and show it. For thread safety, this method should be
	 * invoked from the event dispatch thread.
	 * 
	 * @throws IOException
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	private static void createAndShowGUI() throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		// Create and set up the window.
		JFrame frame = new JFrame("Slogo!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel newPanel = new JPanel();

		InterpreterGUI newIntrepreter = new InterpreterGUI(new Interpreter());
		newTurtleGUI = new TurtleGUI(interpreter.engine);
		newPanel.add(newTurtleGUI);
		// Add contents to the window.
		newPanel.add(newIntrepreter);
		frame.add(newPanel);
		// Display the window.
		frame.pack();
		frame.setSize(800, 580);

		helpMenu();
		turtleMenu();

		frame.setJMenuBar(menuBar);

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
				try {
					createAndShowGUI();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

	}
}