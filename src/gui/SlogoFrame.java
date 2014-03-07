package gui;

import gui.menubar.MenuBar;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import backend.WorldsCollection;

public class SlogoFrame extends JFrame{
	// Singleton

	private static SlogoFrame instance;
	private WorldGraphicsPanel worldGraphicsPanel;
	private JTabbedPane tabbedPane;
	

	private SlogoFrame() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		super("Slogo!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		populateDisplays();
		setJMenuBar(new MenuBar());
		setVisible(true);
		pack();
	}

	public static SlogoFrame getInstance() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException{
		if(instance == null){
			instance = new SlogoFrame();
		}
		return instance;
	}
	private void populateDisplays() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {

		tabbedPane = new JTabbedPane();
		addNewTab();
		add(tabbedPane);
		tabbedPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				WorldsCollection.getInstance().switchCurrentWorld(tabbedPane.getSelectedIndex());
			}
		});
	}

	public void addNewTab() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		WorldsCollection.getInstance().newWorld();
		JPanel newTab = new JPanel();
		newTab.add(new StatsPanel());
		worldGraphicsPanel = new WorldGraphicsPanel();
		newTab.add(worldGraphicsPanel);
		newTab.add(new ConsolePanel());
		tabbedPane.addTab("New Tab", newTab);
		tabbedPane.setSelectedIndex(tabbedPane.getTabCount() - 1);
	}

	public void closeCurrentTab() {
		if(tabbedPane.getTabCount() > 1){
			WorldsCollection.getInstance().deleteWorldAt(tabbedPane.getSelectedIndex());
			tabbedPane.remove(tabbedPane.getSelectedComponent());
			WorldsCollection.getInstance().switchCurrentWorld(tabbedPane.getSelectedIndex());
		}
	}
}
