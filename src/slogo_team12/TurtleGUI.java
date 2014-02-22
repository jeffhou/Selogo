package slogo_team12;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Line2D;

import javax.swing.*;

public class TurtleGUI extends Component{
	protected JTextArea inputTextArea, consoleOutputTextArea;
    protected JTextArea historyTextArea;
    private JButton runButton;
    private final static String newline = "\n";
    public void paint(Graphics g){
    	Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Dimension d = getSize();
        int gridWidth = d.width / 6;
        int gridHeight = d.height / 2;

        Color fg3D = Color.lightGray;

        g2.setPaint(fg3D);
        g2.draw3DRect(0, 0, d.width - 1, d.height - 1, true);
        g2.draw3DRect(3, 3, d.width - 7, d.height - 7, false);
        g2.setPaint(Color.black);

        int x = 5;
        int y = 7;
        int rectWidth = gridWidth - 2*x;

        // draw Line2D.Double
        g2.draw(new Line2D.Double(x, y, x + rectWidth, y + 143));
        x += gridWidth;
    }

    public Dimension getPreferredSize(){
        return new Dimension(553, 553);
    }
}