package gui;

import java.awt.Color;

import javax.swing.JPanel;

public abstract class WordFeudComponent extends JPanel {

	public WordFeudComponent() {
		this.setBackground(Color.BLACK);
	
	}
	
	public abstract void createButtons();
	public abstract void createGui();
	public abstract void showDialog(String key);

	
}
