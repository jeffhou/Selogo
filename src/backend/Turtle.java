package backend;

import gui.TurtleGUI;

import java.util.ArrayList;

public class Turtle {
	private double heading; // angle, 0 is north, rotates clockwise
	private boolean penDown; // is trail recording?
	public Tuple position; // position
	private boolean showing; // is turtle showing?
	public ArrayList<ArrayList<Tuple>> trails;

	public Turtle() {
		position = new Tuple();
		trails = new ArrayList<ArrayList<Tuple>>();
		heading = 0;
		setPen(true);
		showing = true;
	}

	public double clear() {
		double distanceTraveled = home();
		clearTrails();
		return distanceTraveled;
	}

	void clearTrails() {
		trails.clear();
		setPen(penDown);
	}

	@Override
	public Turtle clone() {
		Turtle newTurtle = new Turtle();
		newTurtle.moveTo(getPosition());
		newTurtle.setHeadingTo(getHeading());
		newTurtle.setPen(getPenState());
		newTurtle.setVisibility(getVisibility());
		ArrayList<ArrayList<Tuple>> newTrails = new ArrayList<ArrayList<Tuple>>();
		for (ArrayList<Tuple> trail : getPaths()) {
			newTrails.add(new ArrayList<Tuple>());
			for (Tuple t : trail) {
				newTrails.get(newTrails.size() - 1).add(t.copy());
			}
		}
		newTurtle.setTrails(newTrails);
		return newTurtle;
	}

	public double getHeading() {
		return heading;
	}

	public ArrayList<ArrayList<Tuple>> getPaths() {
		return trails;
	}

	public boolean getPenState() {
		return penDown;
	}

	public Tuple getPosition() {
		return position;
	}

	public boolean getVisibility() {
		return showing;
	}

	public double home() {
		setHeadingTo(0);
		return moveTo(new Tuple());
	}

	/**
	 * Relative move in both directions based on heading.
	 */
	public double move(Tuple posChange) {
		Tuple actualPosChange = new Tuple((posChange.y - posChange.x)
				* Math.sin(Math.toRadians(heading)),
				(posChange.y + posChange.x) * Math.cos(Math.toRadians(heading)));
		return moveTo(Tuple.sum(actualPosChange, position));
	}

	/**
	 * Absolute move to position.
	 */
	public double moveTo(Tuple newPos) {
		double distanceTraveled = position.distanceTo(newPos);
		position = Tuple.subtract(Tuple.mod(Tuple.sum(newPos, new Tuple(
				553.0 / 2, 553.0 / 2)), new Tuple(TurtleGUI.dimension.width,
				TurtleGUI.dimension.height)), new Tuple(553.0 / 2, 553.0 / 2));
		/**
		 * TODO: When the turtle goes off screen, we should display turtle going
		 * to edge and then coming out from the other edge. Instead, right now
		 * the trail simply connects the old point and the new point. Wrap
		 * around also needs to be implemented with correct math.
		 */
		if (penDown) {
			updateTrail();
		}
		return distanceTraveled;
	}

	void newTrail() {
		trails.add(new ArrayList<Tuple>());
		updateTrail();
	}

	/**
	 * Points turtle at point (x,y).
	 */
	public double setHeadingTo(double newHeading) {
		double headingChange = (newHeading - heading) % 360;
		heading = newHeading % 360;
		return headingChange;
	}

	/**
	 * Sets pen state
	 */
	public void setPen(boolean down) {
		penDown = down;
		if (penDown) {
			newTrail();
		}
	}

	private void setTrails(ArrayList<ArrayList<Tuple>> newTrails) {
		trails = newTrails;
	}

	public void setVisibility(boolean show) {
		showing = show;
	}

	/**
	 * Sets turtle heading to newHeading.
	 */
	public double turnClockwise(double newHeadingChange) {
		setHeadingTo(heading + newHeadingChange);
		return newHeadingChange;
	}

	void updateTrail() {
		trails.get(trails.size() - 1).add(getPosition());
	}
}
