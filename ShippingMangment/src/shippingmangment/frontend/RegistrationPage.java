package shippingmangment.frontend;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import shippingmangment.classesmodel.Utente;
import shippingmangment.utility.ClientManagement;

public class RegistrationPage extends JPanel implements ActionListener, Serializable {

	private static JTextField textField;
	private static JTextField textField_1;
	private static JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JLabel lblNewLabel_5;
	private Utente user;

	public RegistrationPage() {
		setBackground(Color.DARK_GRAY);
		setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 153, 51));
		panel.setBounds(0, 0, 333, 475);
		add(panel);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(RegistrationPage.class.getResource("/packagingImage/user-group-icon.png")));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("USERNAME :");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_1.setBounds(352, 32, 99, 29);
		add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBackground(SystemColor.menu);
		textField.setBounds(372, 72, 241, 29);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("PASSWORD :");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(352, 112, 99, 29);
		add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBackground(SystemColor.menu);
		textField_1.setBounds(372, 311, 241, 29);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\r\nCONFERMA PASSWORD :");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(351, 192, 201, 29);
		add(lblNewLabel_3);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(SystemColor.menu);
		passwordField.setBounds(372, 232, 241, 29);
		add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBackground(SystemColor.menu);
		passwordField_1.setBounds(372, 152, 241, 29);
		add(passwordField_1);
		
		JLabel lblNewLabel_4 = new JLabel("INDIRIZZO :");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(352, 272, 99, 28);
		add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("PROCEDI");
		btnNewButton.setForeground(SystemColor.textHighlight);
		btnNewButton.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		btnNewButton.setBounds(372, 370, 99, 42);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.setForeground(SystemColor.textHighlight);
		btnNewButton_1.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		btnNewButton_1.setBounds(514, 370, 99, 42);
		add(btnNewButton_1);
		
		btnNewButton.addActionListener(this);
		btnNewButton_1.addActionListener(this);
		
		lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_5.setForeground(new Color(220, 20, 60));
		lblNewLabel_5.setBounds(382, 11, 241, 31);
		add(lblNewLabel_5);

	}

	public void actionPerformed(ActionEvent e) {

		String scelta_1 = e.getActionCommand();
		String passwordText = passwordField.getText();
		String passwordText_1 = passwordField_1.getText();
		String userText_1 = textField.getText();

		if (scelta_1.equals("BACK")) {
			Home home = new Home();
			SwingUtilities.windowForComponent(this).setVisible(false);

		}

		if (scelta_1.equals("PROCEDI")) {
			if (!passwordText.equals(passwordText_1)) {
				lblNewLabel_5.setText("Password non coincidono, Riprova !!");
			}

			ClientManagement clientMangment = new ClientManagement();

			// Controllo se l'utente non esiste
			if (clientMangment.isUser(userText_1))
				lblNewLabel_5.setText("l'Utente già esiste !!");
			else {
				Utente utente = new Utente(userText_1, passwordText, "");
				clientMangment.saveUser(utente);
				lblNewLabel_5.setText("utente aggiunto corretamente!!");
				Home home = new Home ();
			}

		}
	}
}
