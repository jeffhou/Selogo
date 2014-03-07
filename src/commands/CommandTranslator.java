package commands;

import java.util.ResourceBundle;

import backend.WorldsCollection;

public class CommandTranslator {
	private String language;
	private static final String DEFAULT_RESOURCE_PACKAGE = "util/";
	ResourceBundle myTranslations;
	
	public CommandTranslator(){
		
		updateLanguage();
		
	}
	
	private void updateLanguage() {
		language = WorldsCollection.getInstance().getLanguage();
		myTranslations = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + language);
	}
	
	
	public String translateCommand(String firstWord) {
		language = WorldsCollection.getInstance().getLanguage();
		myTranslations=ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + language);
		return myTranslations.getString(firstWord);
	}
}
