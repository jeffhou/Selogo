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


	public WorldModel(){
		activeTurtles.add(new TurtleModel(0));
		trails = new ArrayList<ArrayList<Tuple>>();
		setPen(true);
		setPenColor(Color.black);
		updateTurtleImage("img/turtle.png");
	}
	public void updateTurtleImage(String imagePath){
		for(TurtleModel turtle : activeTurtles) {
			turtle.setImagePath(imagePath);
		}
	}
	void clearTrails() {
		trails.clear();
		setPen(penDown);
	}
	
	public int getTurtleID() {
		return activeTurtles.get(0).getID();
	}

	public double clear() {
		clearTrails();
		double distanceTraveled = home();
		return distanceTraveled;
	}

	public Map<String, Double> getVariables() {	
		return variables;
	}

	public Map<String, UserCommand> getUserCommands() {
		return userCommands;	
	}

	public ArrayList<ArrayList<Tuple>> getPaths() {
		return trails;
	}
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
	public double home() {
		setHeadingTo(0);
		return moveTo(new Tuple());
	}
	public void setPen(boolean down) {
		penDown = down;
		if (penDown) {
			newTrail();
		}
	}
	/**
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
	public double turnClockwise(double newHeadingChange) {
		for(TurtleModel turtle : activeTurtles) {
			setHeadingTo(turtle.getHeading() + newHeadingChange);
		}
		return newHeadingChange;
	}

	void updateTrail() {
		for(TurtleModel turtle : activeTurtles) {
			if (penDown) {
				trails.get(trails.size() - 1).add(turtle.getPosition());
			}
		}
	}
	public ArrayList<TurtleModel> getActiveTurtles() {
		return activeTurtles;
	}
	public ArrayList<TurtleModel> getAllTurtles() {
		ArrayList<TurtleModel> allTurtles = new ArrayList<TurtleModel>();
		allTurtles.addAll(inactiveTurtles);
		allTurtles.addAll(activeTurtles);
		return allTurtles;
	}
	public void setPenColor(Color newColor) {
		penColor = newColor;
	}
	public Color getPenColor() {
		return penColor;
	}


	@SuppressWarnings("unchecked")
	public void setUserCommands(Object o) {
		userCommands = (Map<String, UserCommand>) o; 
	}
	@SuppressWarnings("unchecked")
	public void setVariables(Object o) {
		variables = (Map<String, Double>) o; 
	}
}
