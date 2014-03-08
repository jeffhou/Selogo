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
	private static String id;
	
	public TurtleModel(String name) {
		position = new Tuple();
		heading = 0;
		showing = true;
		id = name;
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

	public void setImagePath(String imagePath) {
		try {
			image = ImageIO.read(new File(imagePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public BufferedImage getImage() {
		return image;
	}
}
