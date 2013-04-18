package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class MyFrame extends JFrame {
	
	private FirstPanel fp;
	
	public MyFrame() {
		super("Wordfeud");
		
		setGuiLooks();
		
		//zorg dat alle swing interactie met edt(event dispatch thread) gebeurd
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {	
				fp = new FirstPanel();
				SwingUtilities.updateComponentTreeUI(fp);
				
				changeContentPane(fp);
				setUpFrame();
			}
		});
	}

	private void setGuiLooks() {
		try {
			boolean hasNewLook = false;
			
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		    	System.out.println(info);
		      	 if ("Nimbus".equals(info.getName())) {
		      		
		            UIManager.setLookAndFeel(info.getClassName());
		            hasNewLook = true;
		            break;
		        }
		    }
		    if (!hasNewLook){
		    	UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		    }
		} catch (Exception e) {
		    e.printStackTrace();
		    System.err.println("Error in setGuiLooks: " + e);
		}
	}

	public void changeContentPane(JPanel panel) {
		this.setContentPane(panel);
		this.revalidate();
	}

	private void setUpFrame() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.pack();
		this.setLocationRelativeTo(null);
	}
}