package backend;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import util.Tuple;

public class TurtleModel {
  private double heading; // angle, 0 is north, rotates clockwise
  private Tuple position; // position
  public boolean isVisible;
  private BufferedImage image;
  private static int id;

  public TurtleModel(int name) {
    position = new Tuple();
    heading = 0;
    isVisible = true;
    id = name;
  }

  /**
   * @return
   * Returns heading of the turtle
   */
  public double getRotationOffset() {
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

  public void hide() {
    this.isVisible = false;
  }

  public void show() {
    this.isVisible = true;
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
