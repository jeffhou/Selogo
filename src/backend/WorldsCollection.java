package backend;

import java.util.ArrayList;

public class WorldsCollection {
	private ArrayList<WorldModel> allWorlds;
	private WorldModel currentWorld;
	private String language;
	private static WorldsCollection instance;
	private WorldsCollection(){
		allWorlds = new ArrayList<WorldModel>();
		language ="English";
	}
	public void newWorld(){
		WorldModel newWorld = new WorldModel();
		allWorlds.add(newWorld);
		currentWorld = newWorld;
	}
	public static WorldsCollection getInstance(){
		if(instance == null) {
			instance = new WorldsCollection();
		}
		return instance;
	}
	public WorldModel getCurrentWorld(){
		return currentWorld;
	}
	public void switchCurrentWorld(int index){
		currentWorld = allWorlds.get(index);
		
	}
	public void deleteWorldAt(int index){
		allWorlds.remove(index);
	}
	public String getLanguage() {
		return language;
	}
	public void updateLanguage(String userSelectedLanguage) {
		language = userSelectedLanguage;
	}

}
