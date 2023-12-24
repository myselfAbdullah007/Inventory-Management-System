package PL;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import java.awt.Color;

public class Login extends JFrame {

	private static final long serialVersionUID = -1715101882915748261L;
	//private Customer obj1;
	//private Admin obj2;
	private JTextField name;
	private JPasswordField passwordField;

	public Login() {
		setTitle("Inventory Management System");
		setSize(470, 390);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);

		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());

		JPanel inputPanel = new JPanel();

		mainPanel.add(inputPanel, BorderLayout.CENTER);
						inputPanel.setLayout(null);
				
						JLabel headingLabel = new JLabel("Welcome to Shopping APP");
						headingLabel.setBounds(65, 43, 320, 91);
						headingLabel.setBackground(Color.GRAY);
						inputPanel.add(headingLabel);
						headingLabel.setFont(new Font("Arial", Font.BOLD, 20));
						headingLabel.setHorizontalAlignment(JLabel.CENTER);
				
				JLabel label = new JLabel("");
				label.setBounds(178, 0, 93, 38);
				inputPanel.add(label);
				
				JLabel label_1 = new JLabel("");
				label_1.setBounds(276, 0, 93, 38);
				inputPanel.add(label_1);
				
				JLabel label_2 = new JLabel("");
				label_2.setBounds(374, 0, 93, 38);
				inputPanel.add(label_2);
				
				JLabel label_3 = new JLabel("");
				label_3.setBounds(472, 0, 93, 38);
				inputPanel.add(label_3);
				
				JLabel label_4 = new JLabel("");
				label_4.setBounds(570, 0, 93, 38);
				inputPanel.add(label_4);
				
				JLabel label_5 = new JLabel("");
				label_5.setBounds(668, 0, 93, 38);
				inputPanel.add(label_5);
				
				JLabel label_6 = new JLabel("");
				label_6.setBounds(766, 0, 98, 38);
				inputPanel.add(label_6);
				
				JLabel label_7 = new JLabel("");
				label_7.setBounds(0, 43, 173, 38);
				inputPanel.add(label_7);
				
				JLabel label_8 = new JLabel("");
				label_8.setBounds(178, 43, 93, 38);
				inputPanel.add(label_8);
				
				JLabel label_9 = new JLabel("");
				label_9.setBounds(276, 43, 93, 38);
				inputPanel.add(label_9);
				
				JLabel label_10 = new JLabel("");
				label_10.setBounds(374, 43, 93, 38);
				inputPanel.add(label_10);
				
				JLabel label_11 = new JLabel("");
				label_11.setBounds(472, 43, 93, 38);
				inputPanel.add(label_11);
				
				JLabel label_12 = new JLabel("");
				label_12.setBounds(570, 43, 93, 38);
				inputPanel.add(label_12);
				
				JLabel label_13 = new JLabel("");
				label_13.setBounds(668, 43, 93, 38);
				inputPanel.add(label_13);
				
				JLabel label_14 = new JLabel("");
				label_14.setBounds(766, 43, 98, 38);
				inputPanel.add(label_14);
				
				JLabel label_15 = new JLabel("");
				label_15.setBounds(0, 86, 173, 38);
				inputPanel.add(label_15);
				
				JLabel label_16 = new JLabel("");
				label_16.setBounds(178, 86, 93, 38);
				inputPanel.add(label_16);
				
				JLabel label_17 = new JLabel("");
				label_17.setBounds(276, 86, 93, 38);
				inputPanel.add(label_17);
				
				JLabel label_18 = new JLabel("");
				label_18.setBounds(374, 86, 93, 38);
				inputPanel.add(label_18);
				
				JLabel label_19 = new JLabel("");
				label_19.setBounds(472, 86, 93, 38);
				inputPanel.add(label_19);
				
				JLabel label_20 = new JLabel("");
				label_20.setBounds(570, 86, 93, 38);
				inputPanel.add(label_20);
				
				JLabel label_21 = new JLabel("");
				label_21.setBounds(668, 86, 93, 38);
				inputPanel.add(label_21);
				
				JLabel label_22 = new JLabel("");
				label_22.setBounds(766, 86, 98, 38);
				inputPanel.add(label_22);
				
				JLabel label_23 = new JLabel("");
				label_23.setBounds(0, 129, 173, 38);
				inputPanel.add(label_23);
				
				JLabel label_24 = new JLabel("");
				label_24.setBounds(178, 129, 93, 38);
				inputPanel.add(label_24);
				
				JLabel label_25 = new JLabel("");
				label_25.setBounds(276, 129, 93, 38);
				inputPanel.add(label_25);
				
				JLabel label_26 = new JLabel("");
				label_26.setBounds(374, 129, 93, 38);
				inputPanel.add(label_26);
				
				JLabel label_27 = new JLabel("");
				label_27.setBounds(472, 129, 93, 38);
				inputPanel.add(label_27);
				
				JLabel label_28 = new JLabel("");
				label_28.setBounds(570, 129, 93, 38);
				inputPanel.add(label_28);
				
				JLabel label_29 = new JLabel("");
				label_29.setBounds(668, 129, 93, 38);
				inputPanel.add(label_29);
				
				JLabel label_30 = new JLabel("");
				label_30.setBounds(766, 129, 98, 38);
				inputPanel.add(label_30);
				
				JLabel label_31 = new JLabel("");
				label_31.setBounds(0, 172, 173, 38);
				inputPanel.add(label_31);
				
				JLabel label_32 = new JLabel("");
				label_32.setBounds(178, 172, 93, 38);
				inputPanel.add(label_32);
				
				JLabel label_33 = new JLabel("");
				label_33.setBounds(276, 172, 93, 38);
				inputPanel.add(label_33);
				
				JLabel label_34 = new JLabel("");
				label_34.setBounds(374, 172, 93, 38);
				inputPanel.add(label_34);
				
				JLabel label_35 = new JLabel("");
				label_35.setBounds(472, 172, 93, 38);
				inputPanel.add(label_35);
				
				JLabel label_36 = new JLabel("");
				label_36.setBounds(570, 172, 93, 38);
				inputPanel.add(label_36);
				
				JLabel label_37 = new JLabel("");
				label_37.setBounds(668, 172, 93, 38);
				inputPanel.add(label_37);
				
				JLabel label_38 = new JLabel("");
				label_38.setBounds(766, 172, 98, 38);
				inputPanel.add(label_38);
				
				JLabel label_39 = new JLabel("");
				label_39.setBounds(0, 215, 173, 38);
				inputPanel.add(label_39);
				
				JLabel label_40 = new JLabel("");
				label_40.setBounds(225, 252, 93, 38);
				inputPanel.add(label_40);
				
				JLabel label_41 = new JLabel("");
				label_41.setBounds(255, 252, 93, 38);
				inputPanel.add(label_41);
				
				JLabel label_42 = new JLabel("");
				label_42.setBounds(374, 215, 93, 38);
				inputPanel.add(label_42);
				
				JLabel label_43 = new JLabel("");
				label_43.setBounds(472, 215, 93, 38);
				inputPanel.add(label_43);
				
				JLabel label_44 = new JLabel("");
				label_44.setBounds(570, 215, 93, 38);
				inputPanel.add(label_44);
				
				JLabel label_45 = new JLabel("");
				label_45.setBounds(668, 215, 93, 38);
				inputPanel.add(label_45);
				
				JLabel label_46 = new JLabel("");
				label_46.setBounds(766, 215, 98, 38);
				inputPanel.add(label_46);
				
				JLabel label_47 = new JLabel("");
				label_47.setBounds(0, 258, 173, 38);
				inputPanel.add(label_47);
				
				JLabel label_48 = new JLabel("");
				label_48.setBounds(104, 172, 88, 38);
				inputPanel.add(label_48);
				
				JLabel label_49 = new JLabel("");
				label_49.setBounds(225, 190, 93, 38);
				inputPanel.add(label_49);
				
				JLabel label_50 = new JLabel("");
				label_50.setBounds(374, 258, 93, 38);
				inputPanel.add(label_50);
				
				JLabel label_51 = new JLabel("");
				label_51.setBounds(472, 258, 93, 38);
				inputPanel.add(label_51);
				
				JLabel label_52 = new JLabel("");
				label_52.setBounds(570, 258, 93, 38);
				inputPanel.add(label_52);
				
				JLabel label_53 = new JLabel("");
				label_53.setBounds(668, 258, 93, 38);
				inputPanel.add(label_53);
				
				JLabel label_54 = new JLabel("");
				label_54.setBounds(766, 258, 98, 38);
				inputPanel.add(label_54);
				
				JLabel label_55 = new JLabel("");
				label_55.setBounds(0, 301, 173, 38);
				inputPanel.add(label_55);
				
				JLabel label_56 = new JLabel("");
				label_56.setBounds(65, 195, 71, 33);
				inputPanel.add(label_56);
				
				JLabel label_57 = new JLabel("");
				label_57.setBounds(276, 301, 93, 38);
				inputPanel.add(label_57);
				
				JLabel label_58 = new JLabel("");
				label_58.setBounds(157, 190, 191, 38);
				inputPanel.add(label_58);
				
				JLabel label_59 = new JLabel("");
				label_59.setBounds(472, 301, 93, 38);
				inputPanel.add(label_59);
				
				JLabel label_60 = new JLabel("");
				label_60.setBounds(570, 301, 93, 38);
				inputPanel.add(label_60);
				
				JLabel label_61 = new JLabel("");
				label_61.setBounds(668, 301, 93, 38);
				inputPanel.add(label_61);
				
				JLabel label_62 = new JLabel("");
				label_62.setBounds(766, 301, 98, 38);
				inputPanel.add(label_62);
				
				JLabel label_63 = new JLabel("");
				label_63.setBounds(0, 344, 173, 38);
				inputPanel.add(label_63);
				
				JLabel label_64 = new JLabel("");
				label_64.setBounds(178, 344, 93, 38);
				inputPanel.add(label_64);
				
				JLabel label_65 = new JLabel("");
				label_65.setBounds(276, 344, 93, 38);
				inputPanel.add(label_65);
				
				JLabel label_66 = new JLabel("");
				label_66.setBounds(374, 344, 93, 38);
				inputPanel.add(label_66);
				
				JLabel label_67 = new JLabel("");
				label_67.setBounds(472, 344, 93, 38);
				inputPanel.add(label_67);
				
				JLabel label_68 = new JLabel("");
				label_68.setBounds(570, 344, 93, 38);
				inputPanel.add(label_68);
				
				JLabel label_69 = new JLabel("");
				label_69.setBounds(668, 344, 93, 38);
				inputPanel.add(label_69);
				
				JLabel label_70 = new JLabel("");
				label_70.setBounds(766, 344, 98, 38);
				inputPanel.add(label_70);
						
								JLabel lname = new JLabel("Name: ");
								lname.setBounds(98, 129, 49, 75);
								lname.setFont(UIManager.getFont("Button.font"));
								inputPanel.add(lname);
				
						name = new JTextField(20);
						name.setBounds(157, 145, 191, 38);
						inputPanel.add(name);
				
				JLabel label_71 = new JLabel("");
				label_71.setBounds(276, 387, 93, 38);
				inputPanel.add(label_71);
				
				JLabel label_72 = new JLabel("");
				label_72.setBounds(374, 344, 93, 38);
				inputPanel.add(label_72);
				
				JLabel label_73 = new JLabel("");
				label_73.setBounds(472, 387, 93, 38);
				inputPanel.add(label_73);
				
				JLabel label_74 = new JLabel("");
				label_74.setBounds(570, 387, 93, 38);
				inputPanel.add(label_74);
				
				JLabel label_75 = new JLabel("");
				label_75.setBounds(668, 387, 93, 38);
				inputPanel.add(label_75);
				
				JLabel label_76 = new JLabel("");
				label_76.setBounds(766, 387, 98, 38);
				inputPanel.add(label_76);
				JLabel lpassword = new JLabel("Password: ");
				lpassword.setBounds(98, 190, 75, 51);
				lpassword.setFont(UIManager.getFont("Button.font"));
				inputPanel.add(lpassword);
				passwordField = new JPasswordField(20);
				passwordField.setBounds(157, 194, 191, 38);
				inputPanel.add(passwordField);
				
				JLabel label_77 = new JLabel("");
				label_77.setBounds(276, 430, 93, 38);
				inputPanel.add(label_77);
				
				JLabel label_78 = new JLabel("");
				label_78.setBounds(374, 430, 93, 38);
				inputPanel.add(label_78);
				
				JLabel label_79 = new JLabel("");
				label_79.setBounds(472, 430, 93, 38);
				inputPanel.add(label_79);
				
				JLabel label_80 = new JLabel("");
				label_80.setBounds(570, 430, 93, 38);
				inputPanel.add(label_80);
				
				JLabel label_81 = new JLabel("");
				label_81.setBounds(668, 430, 93, 38);
				inputPanel.add(label_81);
				
				JLabel label_82 = new JLabel("");
				label_82.setBounds(766, 430, 98, 38);
				inputPanel.add(label_82);
				
				JLabel label_83 = new JLabel("");
				label_83.setBounds(0, 473, 173, 38);
				inputPanel.add(label_83);
				
				JLabel label_84 = new JLabel("");
				label_84.setBounds(178, 473, 93, 38);
				inputPanel.add(label_84);
				
				JLabel label_85 = new JLabel("");
				label_85.setBounds(276, 473, 93, 38);
				inputPanel.add(label_85);
				
				JLabel label_86 = new JLabel("");
				label_86.setBounds(374, 473, 93, 38);
				inputPanel.add(label_86);
				JButton button = new JButton("Login");
				button.setBounds(267, 252, 81, 38);
				button.setFont(UIManager.getFont("Button.font"));
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
					}
				});
				
				JLabel label_87 = new JLabel("");
				label_87.setBounds(472, 473, 93, 38);
				inputPanel.add(label_87);
				
				JLabel label_88 = new JLabel("");
				label_88.setBounds(570, 473, 93, 38);
				inputPanel.add(label_88);
				
				JLabel label_89 = new JLabel("");
				label_89.setBounds(668, 473, 93, 38);
				inputPanel.add(label_89);
				
				JLabel label_90 = new JLabel("");
				label_90.setBounds(766, 473, 98, 38);
				inputPanel.add(label_90);
				inputPanel.add(button);
				
				JLabel label_91 = new JLabel("");
				label_91.setBounds(178, 516, 93, 43);
				inputPanel.add(label_91);
				
				JLabel label_92 = new JLabel("");
				label_92.setBounds(276, 516, 93, 43);
				inputPanel.add(label_92);
				
				JLabel label_93 = new JLabel("");
				label_93.setBounds(374, 516, 93, 43);
				inputPanel.add(label_93);
				
				JLabel label_94 = new JLabel("");
				label_94.setBounds(472, 516, 93, 43);
				inputPanel.add(label_94);
		
		JLabel label_95 = new JLabel("");
		label_95.setBounds(570, 516, 93, 43);
		inputPanel.add(label_95);
		
		JLabel label_96 = new JLabel("");
		label_96.setBounds(668, 516, 93, 43);
		inputPanel.add(label_96);
		
		JLabel label_97 = new JLabel("");
		label_97.setBounds(766, 516, 98, 43);
		inputPanel.add(label_97);

		getContentPane().add(mainPanel);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			Login login = new Login();
			login.setVisible(true);
		});
	}
}
