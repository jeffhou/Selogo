package gui.menubar;

import javax.swing.JMenu;

public class TurtleMenu extends JMenu{
	/**
	 * Menu that contains turtle related aspects
	 */
	public TurtleMenu(){
		super("Turtle");
		add(new ImageMenuItem());
		add(new PenColorMenuItem());
	}
}
