package main;

import gui.SlogoFrame;
import java.io.IOException;

public class Runner {

  /**
   * Main method, creates a slogoFrame, which creates the GUI
   * @param args
   * @throws IOException
   * @throws InstantiationException
   * @throws IllegalAccessException
   * @throws ClassNotFoundException
   */
  public static void main(String[] args)
      throws IOException,
      InstantiationException,
      IllegalAccessException,
      ClassNotFoundException {
    SlogoFrame.getInstance();
  }
}
