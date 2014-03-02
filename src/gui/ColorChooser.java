package gui;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.colorchooser.*;

/* ColorChooserDemo.java requires no other files. */
public class ColorChooser extends JPanel implements ChangeListener {

	protected JColorChooser tcc;
	protected JLabel banner;

	public ColorChooser() {
		super(new BorderLayout());
		//Set up the banner at the top of the window
		banner = new JLabel("Pick Pen Color!", JLabel.CENTER);
		banner.setForeground(Color.black);
		banner.setBackground(Color.white);
		banner.setOpaque(true);
		banner.setFont(new Font("SansSerif", Font.BOLD, 24));
		banner.setPreferredSize(new Dimension(100, 65));

		JPanel bannerPanel = new JPanel(new BorderLayout());
		bannerPanel.add(banner, BorderLayout.CENTER);
		bannerPanel.setBorder(BorderFactory.createTitledBorder("Banner"));

		//Set up color chooser for setting text color
		tcc = new JColorChooser(banner.getForeground());
		tcc.getSelectionModel().addChangeListener(this);
		tcc.setBorder(BorderFactory.createTitledBorder("Choose Text Color"));

		add(bannerPanel, BorderLayout.CENTER);
		add(tcc, BorderLayout.PAGE_END);
	}

	public void stateChanged(ChangeEvent e) {
		Color newColor = tcc.getColor();
		banner.setForeground(newColor);
		SlogoFrame.updatePenColor(newColor);
	}
}