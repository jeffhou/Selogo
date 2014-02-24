package slogo_team12;
import java.lang.Math;
import java.util.ArrayList;
public class Turtle {
	Tuple position;	//position
	private double heading;		//angle, 0 is north, rotates clockwise
	private boolean penDown;	//is trail recording?
	private boolean showing;	//is turtle showing?
	ArrayList<ArrayList<Tuple>> trails;
	public Turtle(){
		position = new Tuple();
		trails = new ArrayList<ArrayList<Tuple>>();
		heading = 0;
		penDown = true;
		showing = true;
	}
	
	/**
	 * Absolute move to position.
	 */
	double moveTo(Tuple newPos){
		double distanceTraveled = position.distanceTo(newPos);
		position = Tuple.subtract(Tuple.mod(Tuple.sum(newPos, new Tuple(553.0 / 2, 553.0 / 2)), new Tuple(TurtleGUI.dimension.width, TurtleGUI.dimension.height)), new Tuple(553.0 / 2, 553.0 / 2));
		return distanceTraveled;
	}
	
	/**
	 * Relative move in both directions based on heading.
	 */
	public double move(Tuple posChange){
		Tuple actualPosChange = new Tuple(
				(posChange.y - posChange.x) * Math.sin(heading),
				(posChange.y + posChange.x) * Math.cos(heading)
				);
		return moveTo(Tuple.sum(actualPosChange, position));
	}
	
	/**
	 * Sets turtle heading to newHeading.
	 */
	public double setHeading(double newHeading){
		heading = (heading + newHeading)%360;
		return newHeading;
	}
	/**
	 * Points turtle at point (x,y).
	 */
	void setHeading(Tuple point){
		Tuple diff = Tuple.subtract(point, position);
		if(diff.y == 0){  //prevent division by zero
			if(diff.x > 0){
				heading = 90;
			}else if(diff.x < 0){
				heading = 270;
			}else{
				/*
				 * TODO: What should be the behavior when we say point at yourself?
				 */
			}
		}else{
			double newHeading = 180 + Math.atan(diff.x / diff.y) * 360 / Math.PI;
			if(diff.y > 0){
				if(diff.x >= 0){
					newHeading -= 180;
				}else{
					newHeading += 180;
				}
			}
			heading = newHeading;
		}
	}
	
	/**
	 * Sets pen state
	 */
	void setTrail(boolean down){
		penDown = down;
	}
	void setVisibility(boolean show){
		showing = show;
	}
	void home(){
		moveTo(new Tuple());
	}
	void clear(){
		clearTrails();
		home();
	}
	void clearTrails(){
		trails.clear();
	}
	
	public Tuple getPosition(){
		return position;
	}

	public double getHeading() {
		return heading;
	}
	public boolean getPenState(){
		return penDown;
	}

	public boolean getVisibility() {
		return showing;
	}

	public ArrayList<ArrayList<Tuple>> getPaths() {
		return trails;
	}
}
