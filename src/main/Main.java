package main;

//Import Libraries
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import com.formdev.flatlaf.FlatDarkLaf;

import pl.InventoryManagementSystemGUI;

public class Main {
	public static void main(String[] args) {
		try {
		    UIManager.setLookAndFeel(new FlatDarkLaf());
		} catch (UnsupportedLookAndFeelException ex) {
		    ex.printStackTrace();
		}
		// pops up the Main BookPresenter Window
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
                new InventoryManagementSystemGUI().setVisible(true);

			}
		});
	}
}

