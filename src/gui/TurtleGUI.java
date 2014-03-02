package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JTextArea;

import backend.Engine;
import backend.Tuple;
import backend.Turtle;

public class TurtleGUI extends Component {

	public static final Dimension SCREEN_DIMENSION = new Dimension(533, 533);
	private Engine engine;
	Graphics2D graphicsEngine;
	protected JTextArea historyTextArea;
	protected JTextArea inputTextArea, consoleOutputTextArea;
	private BufferedImage turtleImage;
	private Color penColor = Color.black;

	/**
	 * TODO: Should read image path and path color from file
	 */

	public TurtleGUI(Engine engine) {
		super();
		this.engine = engine;
		updateTurtleImage("img/turtle.png");

	}

	public void updateTurtleImage(String path){
		try {
			turtleImage = ImageIO.read(new File(path));
			repaint();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void updatePenColor(Color color){
		penColor = color;
	}

	public void paint(Graphics g) {
		graphicsEngine = (Graphics2D) g;
		graphicsEngine.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		//dimension = getSize();

		drawBorder();
		graphicsEngine.setColor(penColor);
		drawTrails();
		drawTurtle();
	}

	void drawTurtle() {
		Turtle turtle = engine.turtle;
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
		return new Dimension(533, 533);
	}

	void drawBorder() {
		graphicsEngine.draw3DRect(0, 0, SCREEN_DIMENSION.width - 1,
				SCREEN_DIMENSION.height - 10, true);
		graphicsEngine.draw3DRect(3, 3, SCREEN_DIMENSION.width - 7,
				SCREEN_DIMENSION.height - 16, false);
	}

	void drawTrails() {
		Turtle turtle = engine.turtle;
		Tuple center = getCenter();
		for (ArrayList<Tuple> path : turtle.trails) {
			for (int i = 0; i < (path.size() - 1); i++) {
				graphicsEngine.draw(new Line2D.Double(path.get(i).x + center.x,
						-path.get(i).y + center.y,
						path.get(i + 1).x + center.x, -path.get(i + 1).y
						+ center.y));
			}
		}
	}

	Tuple getCenter() {
		double centerX = SCREEN_DIMENSION.width / 2;
		double centerY = SCREEN_DIMENSION.height / 2;
		return new Tuple(centerX, centerY);
	}
}