package backend;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import util.Tuple;

public class TurtleModel {
	private double heading; // angle, 0 is north, rotates clockwise
	private Tuple position; // position
	private boolean showing; // is turtle showing?
	private BufferedImage image;
	private static int id;
	
	public TurtleModel(int name) {
		position = new Tuple();
		heading = 0;
		showing = true;
		id = name;
	}
	
	/**
	 * @return
	 * Returns heading of the turtle
	 */
	public double getHeading() {
		return heading;
	}

	/**
	 * @param heading
	 * Sets heading of the turtle
	 */
	public void setHeading(double heading) {
		this.heading = heading;
	}

	/**
	 * @return
	 * Gets position of the turtle
	 */
	public Tuple getPosition() {
		return position;
	}

	/**
	 * @param position
	 * Sets position of the turtle
	 */
	public void setPosition(Tuple position) {
		this.position = position;
	}

	/**
	 * @return
	 * Returns true if the turtle is showing
	 */
	public boolean isShowing() {
		return showing;
	}

	/**
	 * @param showing
	 * Sets whether or not the turtle is showing
	 */
	public void setShowing(boolean showing) {
		this.showing = showing;
	}

	/**
	 * @param imagePath
	 * Sets the image used for the turtle
	 */
	public void setImagePath(String imagePath) {
		try {
			image = ImageIO.read(new File(imagePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @return
	 * Returns unique id of each turtle
	 */
	public int getID() {
		return id;
	}

	/**
	 * @return
	 * Gets the image currently used by the turtle
	 */
	public BufferedImage getImage() {
		return image;
	}
}
