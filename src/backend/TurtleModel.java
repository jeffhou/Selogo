package backend;

import gui.WorldGraphicsPanel;

import java.util.ArrayList;

public class TurtleModel {
	private double heading; // angle, 0 is north, rotates clockwise
	private Tuple position; // position
	private boolean showing; // is turtle showing?
	
	public TurtleModel() {
		position = new Tuple();
		heading = 0;
		showing = true;
	}
	
	public double getHeading() {
		return heading;
	}

	public void setHeading(double heading) {
		this.heading = heading;
	}

	public Tuple getPosition() {
		return position;
	}

	public void setPosition(Tuple position) {
		this.position = position;
	}

	public boolean isShowing() {
		return showing;
	}

	public void setShowing(boolean showing) {
		this.showing = showing;
	}
}
