package gui.menubar;

import javax.swing.JMenu;

public class TurtleMenu extends JMenu{
	public TurtleMenu(){
		super("Turtle");
		add(new HelpMenuItem());
		add(new PenColorMenuItem());
		add(new StatsMenuItem());
	}
}
