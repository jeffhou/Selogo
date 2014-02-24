package gui;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Random;
import java.awt.Graphics;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import backend.Tuple;
import backend.Turtle;

public class TurtleGUI extends Component {
	protected JTextArea inputTextArea, consoleOutputTextArea;
	protected JTextArea historyTextArea;
	private Turtle turtle;
	private BufferedImage turtleImage;
	Graphics2D graphicsEngine;
	public static Dimension dimension;

	/**
	 * TODO: Should read image path and path color from file
	 */
	TurtleGUI() { // a way to test
		/**
		 * TODO: CREATE TURTLEGUI TESTS create actual tests for the TurtleGUI
		 * (currently non-existent)
		 */
		super();
		turtle = new Turtle();
		try {
			turtleImage = ImageIO.read(new File("img/turtle.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		// turtle.setVisibility(false);
		ArrayList<Tuple> firstPath = new ArrayList<Tuple>();
		firstPath.add(new Tuple());
		Random rand = new Random();
		for (int i = 0; i < 30; i++) {
			firstPath.add(new Tuple(rand.nextDouble() * 553 - 553 / 2, rand
					.nextDouble() * 553 - 553 / 2));
		}
		turtle.trails.add(firstPath);
		turtle.turnClockwise(305);
		turtle.position = new Tuple(50, 29);
	}

	TurtleGUI(Turtle t) {
		super();
		turtle = t;
		try {
			turtleImage = ImageIO.read(new File("img/turtle.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void paint(Graphics g) {
		graphicsEngine = (Graphics2D) g;
		graphicsEngine.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		dimension = getSize();
		drawBorder();
		drawTrails();
		drawTurtle();
	}

	void drawTurtle() {
		if (turtle.getVisibility()) {
			Tuple center = getCenter();
			double rotationAngle = Math.toRadians(turtle.getHeading());
			AffineTransform tx = AffineTransform.getRotateInstance(
					rotationAngle, turtleImage.getWidth(this) / 2,
					turtleImage.getHeight(this) / 2);
			AffineTransformOp op = new AffineTransformOp(tx,
					AffineTransformOp.TYPE_BILINEAR);
			graphicsEngine.drawImage(op.filter(turtleImage, null),
					(int) (center.x + turtle.getPosition().x - turtleImage
							.getWidth(this) / 2),
					(int) (center.y - turtle.getPosition().y - turtleImage
							.getHeight(this) / 2), null);
		}
	}

	public Dimension getPreferredSize() {
		/**
		 * TODO: REMOVE MAGIC NUMBERS I put the TODO here but this applies to
		 * everything.
		 */
		return new Dimension(553, 553);
	}

	void drawBorder() {
		graphicsEngine.draw3DRect(0, 0, dimension.width - 1,
				dimension.height - 1, true);
		graphicsEngine.draw3DRect(3, 3, dimension.width - 7,
				dimension.height - 7, false);
	}

	void drawTrails() {
		Tuple center = getCenter();
		for (ArrayList<Tuple> path : turtle.trails) {
			for (int i = 0; i < path.size() - 1; i++) {
				graphicsEngine.draw(new Line2D.Double(path.get(i).x + center.x,
						-path.get(i).y + center.y,
						path.get(i + 1).x + center.x, -path.get(i + 1).y
								+ center.y));
			}
		}
	}

	Tuple getCenter() {
		double centerX = dimension.width / 2;
		double centerY = dimension.height / 2;
		return new Tuple(centerX, centerY);
	}
}