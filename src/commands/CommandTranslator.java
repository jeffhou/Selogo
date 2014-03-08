package commands;

import java.util.ResourceBundle;

import backend.WorldsCollection;

public class CommandTranslator {
	private String language;
	private static final String DEFAULT_RESOURCE_PACKAGE = "util/";
	ResourceBundle myTranslations;
	
	/**
	 * Calls the updateLanguage() method
	 */
	public CommandTranslator(){
		updateLanguage();
	}
	
	/**
	 * Updates the language with the one selected
	 */
	private void updateLanguage() {
		language = WorldsCollection.getInstance().getLanguage();
		myTranslations = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + language);
	}
	
	/**
	 * @param firstWord
	 * @return
	 * Translates the command into the current language
	 */
	public String translateCommand(String firstWord) {
		language = WorldsCollection.getInstance().getLanguage();
		myTranslations = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + language);
		return myTranslations.getString(firstWord);
	}
}
