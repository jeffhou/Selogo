package backend;

import gui.WorldGraphicsPanel;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import commands.UserCommand;
import util.Tuple;

public class WorldModel {

	private ArrayList<ArrayList<Tuple>> trails;
	private boolean penDown; // is trail recording?
	private Color penColor;
	private Map<String, Double> variables = new HashMap<String, Double>();
	private Map<String, UserCommand> userCommands = new HashMap<String, UserCommand>();
	private ArrayList<TurtleModel> activeTurtles = new ArrayList<TurtleModel>();
	private ArrayList<TurtleModel> inactiveTurtles = new ArrayList<TurtleModel>();


	/**
	 * Sets initial state of the world
	 */
	public WorldModel(){
		activeTurtles.add(new TurtleModel(0));
		trails = new ArrayList<ArrayList<Tuple>>();
		setPen(true);
		setPenColor(Color.black);
		updateTurtleImage("img/turtle.png");
	}
	/**
	 * @param imagePath
	 * Updates turtle image to the image indicated by the path parameter
	 */
	public void updateTurtleImage(String imagePath){
		for(TurtleModel turtle : activeTurtles) {
			turtle.setImagePath(imagePath);
		}
	}
	/**
	 * Clears previously drawn trails
	 */
	void clearTrails() {
		trails.clear();
		setPen(penDown);
	}
	
	/**
	 * @return
	 * Returns turtle id
	 */
	public int getTurtleID() {
		return activeTurtles.get(0).getID();
	}

	/**
	 * @return
	 * Clears trails and returns turtle to original position
	 */
	public double clear() {
		clearTrails();
		double distanceTraveled = home();
		return distanceTraveled;
	}

	/**
	 * @return
	 * Returns all variables created by the user
	 */
	public Map<String, Double> getVariables() {	
		return variables;
	}

	/**
	 * @return
	 * Returns all commands created by the user
	 */
	public Map<String, UserCommand> getUserCommands() {
		return userCommands;	
	}

	/**
	 * @return
	 * Gets all of the paths drawn
	 */
	public ArrayList<ArrayList<Tuple>> getPaths() {
		return trails;
	}
	/**
	 * @return
	 * Returns the pen state (up or down)
	 */
	public boolean getPenState() {
		return penDown;
	}
	@Override
	public String toString() {
		String myDetails = "";
		myDetails += "Position: " + activeTurtles.get(0).getPosition().toString() +'\n';
		myDetails += "Heading: " + activeTurtles.get(0).getHeading() + '\n';
		myDetails += "Pen Status: " + penDown + '\n';
		myDetails += "Visibility: " + activeTurtles.get(0).isShowing() + '\n';
		return myDetails;
	}
	/**
	 * @return
	 * Returns turtle to original position and direction
	 */
	public double home() {
		setHeadingTo(0);
		return moveTo(new Tuple());
	}
	/**
	 * @param down
	 * Sets the pen to up or down
	 */
	public void setPen(boolean down) {
		penDown = down;
		if (penDown) {
			newTrail();
		}
	}
	/**
	 * @param posChange
	 * @return
	 * Relative move in both directions based on turtle.getHeading().
	 */
	public double move(Tuple posChange) {
		double ret = 0;
		for(TurtleModel turtle : activeTurtles) {
			Tuple actualPosChange = new Tuple((posChange.y - posChange.x)
					* Math.sin(Math.toRadians(turtle.getHeading())),
					(posChange.y + posChange.x) * Math.cos(Math.toRadians(turtle.getHeading())));
			ret = moveTo(Tuple.sum(actualPosChange, turtle.getPosition()));
		}
		return ret;
	}

	/**
	 * @param newPos
	 * @return
	 * Absolute move to turtle.getPosition().
	 */
	public double moveTo(Tuple newPos) {
		double distanceTraveled = 0;
		for(TurtleModel turtle : activeTurtles) {
			distanceTraveled = turtle.getPosition().distanceTo(newPos);
			Tuple newRawPosition = Tuple.sum(newPos,
					new Tuple(553.0 / 2, 553.0 / 2));
			Tuple displacement = Tuple.subtract(newPos, turtle.getPosition());
			Tuple onScreenPosition = Tuple.subtract(Tuple
					.mod(newRawPosition, new Tuple(WorldGraphicsPanel.SCREEN_DIMENSION.width,
							WorldGraphicsPanel.SCREEN_DIMENSION.height)), new Tuple(553.0 / 2,
									553.0 / 2));
			turtle.setPosition(newPos);
			updateTrail();

			turtle.setPosition(Tuple.subtract(onScreenPosition, displacement));


			turtle.setPosition(onScreenPosition);
			updateTrail();
		}
		return distanceTraveled;
	}

	/**
	 * Creates a new trail and adds that to ArrayList
	 */
	void newTrail() {
		trails.add(new ArrayList<Tuple>());
		updateTrail();
	}

	/**
	 * Points turtle at point (x,y).
	 */
	public double setHeadingTo(double newHeading) {
		double headingChange = 0;
		for(TurtleModel turtle : activeTurtles) {
			headingChange = (newHeading - turtle.getHeading()) % 360;
			turtle.setHeading(newHeading % 360);
		}
		return headingChange;
	}
	/**
	 * @param newHeadingChange
	 * @return
	 * Rotates the turtle
	 */
	public double turnClockwise(double newHeadingChange) {
		for(TurtleModel turtle : activeTurtles) {
			setHeadingTo(turtle.getHeading() + newHeadingChange);
		}
		return newHeadingChange;
	}

	/**
	 * Updates the trail of the turtle
	 */
	void updateTrail() {
		for(TurtleModel turtle : activeTurtles) {
			if (penDown) {
				trails.get(trails.size() - 1).add(turtle.getPosition());
			}
		}
	}
	/**
	 * @return
	 * Returns a list of all active turtles
	 */
	public ArrayList<TurtleModel> getActiveTurtles() {
		return activeTurtles;
	}
	/**
	 * @return
	 * Returns all turtles
	 */
	public ArrayList<TurtleModel> getAllTurtles() {
		ArrayList<TurtleModel> allTurtles = new ArrayList<TurtleModel>();
		allTurtles.addAll(inactiveTurtles);
		allTurtles.addAll(activeTurtles);
		return allTurtles;
	}
	/**
	 * @param newColor
	 * Sets the pen color to the color indicated by the parameter
	 */
	public void setPenColor(Color newColor) {
		penColor = newColor;
	}
	/**
	 * @return
	 * Returns the current pen color
	 */
	public Color getPenColor() {
		return penColor;
	}


	/**
	 * @param o
	 * Sets the UserCommands
	 */
	@SuppressWarnings("unchecked")
	public void setUserCommands(Object o) {
		userCommands = (Map<String, UserCommand>) o; 
	}
	/**
	 * @param o
	 * Sets the Variables
	 */
	@SuppressWarnings("unchecked")
	public void setVariables(Object o) {
		variables = (Map<String, Double>) o; 
	}
}
