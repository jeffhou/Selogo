package slogo_team12;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class InterpreterGUI extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1112755039756351859L;
	protected JTextArea inputTextArea, consoleOutputTextArea;
    protected JTextArea historyTextArea;
    private JButton runButton;
    private final static String newline = "\n";
    protected static Interpreter interpreter;
    static TurtleGUI newTurtleGUI;
    public InterpreterGUI(Interpreter new_interpreter) {
        super(new GridBagLayout());
        
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
        runButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					consoleOutputTextArea.setText("" + interpreter.interpret(inputTextArea.getText()));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				String text = inputTextArea.getText();
		        historyTextArea.append(text + newline);
		        inputTextArea.selectAll();
		 
		        //Make sure the new text is visible, even if there
		        //was a selection in the text area.
		        historyTextArea.setCaretPosition(historyTextArea.getDocument().getLength());
		        inputTextArea.requestFocus();
		        newTurtleGUI.repaint();
			}
        });
        
        //Add Components to this panel.
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
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("TextDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel newPanel = new JPanel();
        
        InterpreterGUI newIntrepreter = new InterpreterGUI(new Interpreter());
        newTurtleGUI = new TurtleGUI(interpreter.engine.turtle);
        newPanel.add(newTurtleGUI);
        //Add contents to the window.
        newPanel.add(newIntrepreter);
        frame.add(newPanel);
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}