package backend;

import java.util.ArrayList;

public class WorldsCollection {
  private ArrayList<WorldModel> allWorlds;
  private WorldModel currentWorld;
  private String language;
  private static WorldsCollection instance;
  /**
   * Holds all the worlds in an ArrayList and sets default language
   */
  private WorldsCollection(){
    allWorlds = new ArrayList<WorldModel>();
    language ="English";
  }
  /**
   * Initiates the new world
   */
  public void newWorld(){
    WorldModel newWorld = new WorldModel();
    allWorlds.add(newWorld);
    currentWorld = newWorld;
  }
  /**
   * @return
   * Returns the instance of the WorldsCollection
   */
  public static WorldsCollection getInstance(){
    if (instance == null) {
      instance = new WorldsCollection();
    }
    return instance;
  }

  public static WorldModel getCurrentWorld() {
    return getInstance().currentWorld;
  }

  /**
   * @param index
   * Switches the current world to index
   * Used to switch between tabs
   */
  public void switchCurrentWorld(int index){
    currentWorld = allWorlds.get(index);

  }
  /**
   * @param index
   * Deletes the World at the index
   * Used when closing tabs
   */
  public void deleteWorldAt(int index){
    allWorlds.remove(index);
  }
  /**
   * @return
   * Returns the current language
   */
  public String getLanguage() {
    return language;
  }
  /**
   * @param userSelectedLanguage
   * Updates the language to the userSelectedLanguage
   */
  public void updateLanguage(String userSelectedLanguage) {
    language = userSelectedLanguage;
  }
}
