package gui;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.colorchooser.*;

/* ColorChooserDemo.java requires no other files. */
public class ColorChooser extends JPanel implements ChangeListener {

	protected JColorChooser tcc;

	public ColorChooser() {
		super(new BorderLayout());

		//Set up color chooser for setting text color
		tcc = new JColorChooser(Color.black);
		tcc.getSelectionModel().addChangeListener(this);
		tcc.setBorder(BorderFactory.createTitledBorder("Choose Text Color"));

		add(tcc, BorderLayout.PAGE_END);
	}

	public void stateChanged(ChangeEvent e) {
		Color newColor = tcc.getColor();
		try {
			SlogoFrame.getInstance().updatePenColor(newColor);
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}