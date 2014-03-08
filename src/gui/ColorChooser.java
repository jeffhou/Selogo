package gui;

import java.awt.*;
import java.io.IOException;

import javax.swing.*;
import javax.swing.event.*;

import backend.WorldsCollection;

/**
 * @author Cody Lieu
 * ColorChooser menu where the user can select a color by clicking on the palette
 */
public class ColorChooser extends JPanel implements ChangeListener {

	protected JColorChooser tcc;

	/**
	 * Creates the Color Chooser Menu and adds a Change Listener
	 * to change the pen color when a user clicks on a new color
	 */
	public ColorChooser() {
		super(new BorderLayout());

		tcc = new JColorChooser(Color.black);
		tcc.getSelectionModel().addChangeListener(this);
		tcc.setBorder(BorderFactory.createTitledBorder("Choose Text Color"));
		
		add(tcc, BorderLayout.PAGE_END);
	}

	
	/* (non-Javadoc)
	 * @see javax.swing.event.ChangeListener#stateChanged(javax.swing.event.ChangeEvent)
	 */
	public void stateChanged(ChangeEvent e) {
		Color newColor = tcc.getColor();
		WorldsCollection.getInstance().getCurrentWorld().setPenColor(newColor);
	}
}