package gui;

import java.awt.GridBagConstraints;

public class SlogoDefaultConstraints extends GridBagConstraints {
	private static SlogoDefaultConstraints instance;
	private SlogoDefaultConstraints(){
		super();
		gridwidth = GridBagConstraints.REMAINDER;
		fill = GridBagConstraints.BOTH;
		weightx = 1.0;
		weighty = 1.0;
	}
	public static SlogoDefaultConstraints getInstance(){
		if(instance == null){
			instance = new SlogoDefaultConstraints();
		}
		return instance;
	}
}
