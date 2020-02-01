package gui;

import gui.menubar.MenuBar;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import backend.WorldsCollection;

public class SlogoFrame extends JFrame {
  // Singleton

  private static SlogoFrame instance;
  private WorldGraphicsPanel worldGraphicsPanel;
  private JTabbedPane tabbedPane;

  private static final String WINDOW_TITLE = "Slogo!";

  /**
   * @throws InstantiationException
   * @throws IllegalAccessException
   * @throws ClassNotFoundException
   * @throws IOException
   * The main SlogoFrame which populates the displays and adds the menu bar
   */
  private SlogoFrame()
      throws InstantiationException,
      IllegalAccessException,
      ClassNotFoundException,
      IOException {
    super(WINDOW_TITLE);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    populateDisplays();
    setJMenuBar(new MenuBar());
    setVisible(true);
    pack();
  }

  /**
   * @return
   * @throws InstantiationException
   * @throws IllegalAccessException
   * @throws ClassNotFoundException
   * @throws IOException
   * Returns the instance of the SlogoFrame
   */
  public static SlogoFrame getInstance()
      throws InstantiationException,
      IllegalAccessException,
      ClassNotFoundException,
      IOException {
    if (instance == null) {
      instance = new SlogoFrame();
    }
    return instance;
  }

  /**
   * @throws InstantiationException
   * @throws IllegalAccessException
   * @throws ClassNotFoundException
   * @throws IOException
   * Adds a tabbed pane for the initiation of the program
   *
   * Uses a change listener to detect when the user changes tabs and change the
   * pane content accordingly.
   */
  private void populateDisplays()
      throws InstantiationException,
      IllegalAccessException,
      ClassNotFoundException,
      IOException {

    tabbedPane = new JTabbedPane();
    addNewTab();
    add(tabbedPane);
    tabbedPane.addChangeListener(new ChangeListener() {
      public void stateChanged(ChangeEvent e) {
        WorldsCollection.getInstance().switchCurrentWorld(tabbedPane.getSelectedIndex());
      }
    });
  }

  /**
   * @throws InstantiationException
   * @throws IllegalAccessException
   * @throws ClassNotFoundException
   * @throws IOException
   * Adds new tab every time a user adds a new tab from the file menu
   * Populates each of these tabs with a `StatsPanel`, WorldGraphicsPanel, and ConsolePanel
   */
  public void addNewTab() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
    worldGraphicsPanel = new WorldGraphicsPanel();
    WorldsCollection.getInstance().newWorld();
    JPanel newTab = new JPanel();
    newTab.add(new StatsPanel());
    newTab.add(worldGraphicsPanel);
    newTab.add(new ConsolePanel());
    tabbedPane.addTab("New Tab", newTab);
    tabbedPane.setSelectedIndex(tabbedPane.getTabCount() - 1);
  }

  /**
   * When this method is called from the FileMenu,
   * the current tab is removed and the current world is also removed
   * The switchCurrentWorld method is called
   */
  public void closeCurrentTab() {
    if (tabbedPane.getTabCount() > 1) {
      WorldsCollection worldsCollection = WorldsCollection.getInstance();
      worldsCollection.deleteWorldAt(tabbedPane.getSelectedIndex());
      tabbedPane.remove(tabbedPane.getSelectedComponent());
      worldsCollection.switchCurrentWorld(tabbedPane.getSelectedIndex());
    }
  }
}
