package gui;

import java.awt.GridBagConstraints;

public class SlogoDefaultConstraints extends GridBagConstraints {
	private static SlogoDefaultConstraints instance;
	/**
	 * Sets the defaults for the SlogoFrame painting
	 */
	private SlogoDefaultConstraints(){
		super();
		gridwidth = GridBagConstraints.REMAINDER;
		fill = GridBagConstraints.BOTH;
		weightx = 1.0;
		weighty = 1.0;
	}
	/**
	 * @return
	 * Returns the instance of the SlogoDefaultConstraints
	 */
	public static SlogoDefaultConstraints getInstance(){
		if(instance == null){
			instance = new SlogoDefaultConstraints();
		}
		return instance;
	}
}
