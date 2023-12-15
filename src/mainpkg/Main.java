package mainpkg;

//Import Libraries
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import com.formdev.flatlaf.FlatDarkLaf;

//Import class in Package PL for accessing it BookPresenter
import PL.Login;

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
				new Login().setVisible(true);
			}
		});
	}
}

