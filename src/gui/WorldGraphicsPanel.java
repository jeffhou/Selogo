package gui;

import backend.TurtleModel;
import backend.WorldModel;
import backend.WorldsCollection;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.util.List;
import javax.swing.JTextArea;

import util.Tuple;

/**
 * Handles the GUI aspects related to the animation of the turtle
 */
public class WorldGraphicsPanel extends Component {

  public static final Dimension SCREEN_DIMENSION = new Dimension(533, 533);
  private static final Tuple CENTER = new Tuple(
      SCREEN_DIMENSION.width / 2,
      SCREEN_DIMENSION.height / 2);

  Graphics2D graphicsEngine;
  protected JTextArea historyTextArea;
  protected JTextArea inputTextArea, consoleOutputTextArea;

  public WorldGraphicsPanel() {
    super();
  }

  @Override
  public Dimension getPreferredSize() {
    return SCREEN_DIMENSION;
  }

  public void paint(Graphics g) {
    graphicsEngine = (Graphics2D) g;
    graphicsEngine.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON);

    drawBorder();
    drawTrails();
    drawTurtles();
  }

  /**
   * Draws the turtle on the SlogoFrame
   * Keeps a list of turtles to have multiple turtles on the same tab
   */
  void drawTurtles() {
    List<TurtleModel> turtleModels = getWorld().getAllTurtles();
    for (TurtleModel turtleModel : turtleModels) {
      drawTurtle(turtleModel);
    }
  }

  private void drawTurtle(TurtleModel turtleModel) {
    if (turtleModel.isVisible) {
      BufferedImage rotatedTurtleImage = getRotatedImage(
          turtleModel.getImage(),
          turtleModel.getRotationOffset());

      Tuple offsetPosition = calculateOffset(turtleModel.getPosition());
      graphicsEngine.drawImage(
          rotatedTurtleImage,
          (int) (offsetPosition.x - rotatedTurtleImage.getWidth(this) / 2),
          (int) (offsetPosition.y - rotatedTurtleImage.getHeight(this) / 2),
          null);
    }
  }

  private BufferedImage getRotatedImage(BufferedImage image, double angle) {
    double rotationAngle = Math.toRadians(angle);
    AffineTransform rotationalTransform = AffineTransform.getRotateInstance(
        rotationAngle,
        image.getWidth(this) / 2,
        image.getHeight(this) / 2);
    AffineTransformOp transformOperator = new AffineTransformOp(
        rotationalTransform, AffineTransformOp.TYPE_BILINEAR);

    return transformOperator.filter(image, null);
  }

  /**
   * Draws the square border to separate the SlogoFrame
   * from the other menus
   */
  private void drawBorder() {
    graphicsEngine.draw3DRect(
        0, 0,
        SCREEN_DIMENSION.width - 1, SCREEN_DIMENSION.height - 1,
        true);
  }

  /**
   * Draws the trails of the Turtle when the turtle's
   * pen is set to `down`. graphicsEngine changes the color
   * when user selects color either using the ColorChooser
   * menu or the SetPenColor command
   */
  private void drawTrails() {
    graphicsEngine.setColor(getWorld().getPenColor());
    for (List<Tuple> path : getWorld().getPaths()) {
      drawTrail(path);
    }
  }

  private void drawTrail(List<Tuple> path) {
    for (int i = 0; i < path.size() - 1; i++) {
      graphicsEngine.draw(getLine(path.get(i), path.get(i + 1)));
    }
  }

  private static Tuple calculateOffset(Tuple point) {
    // multiply y by -1 to flip direction since y-axis is flipped
    // during render
    return new Tuple(point.x + CENTER.x, -1 * point.y + CENTER.y);
  }

  private static Line2D.Double getLine(Tuple start, Tuple end) {
    start = calculateOffset(start);
    end = calculateOffset(end);

    return new Line2D.Double(
        start.x, start.y,
        end.x, end.y);
  }

  private static WorldModel getWorld() {
    return WorldsCollection.getCurrentWorld();
  }
}
