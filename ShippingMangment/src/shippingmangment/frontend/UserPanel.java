package shippingmangment.frontend;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import shippingmangment.classesmodel.Spedizione;
import shippingmangment.classesmodel.TableModel;
import shippingmangment.utility.CaricaSpedizioni;
import shippingmangment.utility.TablesModelUtil;

public class UserPanel extends JPanel implements ActionListener {

	private JTextField textField;
	private JTextField textField_1;
	private JComboBox comboBox;
	private JTextField textField_2;
	private JTextField textField_3;
	private JLabel lblNewLabel_6;
	private Date date;
	private String strDate;
	private String cliente;
	private TableModel tbm;
	private String dataDiInserimento;

	/**
	 * Create the panel.
	 */

	public UserPanel() {

		setBackground(Color.DARK_GRAY);
		setLayout(null);
		date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		strDate = formatter.format(date);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 153, 51));
		panel.setBounds(0, 0, 314, 425);
		add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(
				new ImageIcon(UserPanel.class.getResource("/packagingImage/shipping_removed_copyrights.png")));
		lblNewLabel.setBounds(10, 11, 277, 403);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("NUOVA SPEDIZIONE");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_1.setBounds(382, 11, 155, 29);
		add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("DESTINAZIONE :");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(324, 111, 115, 29);
		add(lblNewLabel_2);

		textField = new JTextField();
		textField.setBackground(SystemColor.menu);
		textField.setBounds(334, 143, 264, 29);
		add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("PESO :");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_3.setBounds(324, 172, 115, 25);
		add(lblNewLabel_3);

		textField_1 = new JTextField();
		textField_1.setBackground(SystemColor.menu);
		textField_1.setBounds(334, 196, 264, 29);
		add(textField_1);
		textField_1.setColumns(10);

		comboBox = new JComboBox();
		comboBox.addItem("Normale");
		comboBox.addItem("Assicurata");
		comboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String sceltaCombo = (String) comboBox.getSelectedItem();

				if (sceltaCombo.equals("Assicurata")) {
					textField_2.setEditable(true);
				}
				if (sceltaCombo.equals("Normale")) {
					textField_2.setEditable(false);
				}

			}
		});
		comboBox.setBounds(407, 82, 102, 29);
		add(comboBox);

		JLabel lblNewLabel_4 = new JLabel("GARANZIA ASSICURATIVA :");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(324, 233, 185, 25);
		add(lblNewLabel_4);

		textField_2 = new JTextField();
		textField_2.setBackground(SystemColor.menu);
		textField_2.setBounds(334, 255, 264, 29);
		textField_2.setEditable(false);
		add(textField_2);
		textField_2.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("DATA :");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_5.setBounds(344, 389, 115, 25);
		add(lblNewLabel_5);

		textField_3 = new JTextField();
		textField_3.setFont(new Font("Sitka Text", Font.PLAIN, 13));
		textField_3.setEditable(false);
		textField_3.setText(strDate);
		textField_3.setBounds(428, 389, 75, 25);
		add(textField_3);
		textField_3.setColumns(10);

		JButton btnNewButton = new JButton("CARICA SPEDIZIONE");
		btnNewButton.setFont(new Font("Font Awesome 5 Free Regular", Font.PLAIN, 12));
		btnNewButton.setBounds(361, 309, 202, 29);
		btnNewButton.addActionListener(this);
		add(btnNewButton);

		JButton btnNewButton_1 = new JButton("LOGOUT");
		btnNewButton_1.setFont(new Font("Font Awesome 5 Free Regular", Font.PLAIN, 13));
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setBounds(483, 349, 115, 29);
		btnNewButton_1.addActionListener(this);
		add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("I MIEI ORDINI");
		btnNewButton_2.addActionListener(this);
		btnNewButton_2.setFont(new Font("Font Awesome 5 Free Regular", Font.PLAIN, 12));
		btnNewButton_2.setForeground(new Color(0, 0, 0));
		btnNewButton_2.setBounds(334, 349, 125, 29);
		add(btnNewButton_2);

		lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setForeground(new Color(102, 204, 0));
		lblNewLabel_6.setFont(new Font("Franklin Gothic Medium", Font.ITALIC, 13));
		lblNewLabel_6.setBounds(344, 42, 243, 29);
		add(lblNewLabel_6);
		LocalDateTime now = LocalDateTime.now();  
        
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");  
        this.dataDiInserimento = now.format(format);  

	}

	/**
	 * @param cliente
	 */
	public UserPanel(String cliente) {
		this();
		this.cliente = cliente;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String sceltaButtone = e.getActionCommand();
		String combo = (String) comboBox.getSelectedItem();

		if (sceltaButtone.equals("LOGOUT")) {
			Home home = new Home ();
			SwingUtilities.windowForComponent(this).setVisible(false);
		}
		if (sceltaButtone.equals("CARICA SPEDIZIONE")) {
			CaricaSpedizioni data = new CaricaSpedizioni();
					Spedizione spedizione = new Spedizione(cliente, textField.getText(), textField_1.getText(), this.dataDiInserimento,
					textField_2.getText(), combo, null);
					data.saveSpedizione(spedizione);
			lblNewLabel_6.setText("SPEDIZIONE CARICATA CORRETTAMENTE !");

		}
		if (sceltaButtone.equals("I MIEI ORDINI")) {

			JFrame adminFrame = new JFrame("I miei ordini");
			SwingUtilities.windowForComponent(this).setVisible(false);
			CaricaSpedizioni spedizioni = new CaricaSpedizioni(cliente);
			List<Spedizione> list = spedizioni.getListaSpedizioniRichiestaCliente();
			TablesModelUtil tablesModelUtil= new TablesModelUtil(list);
			JTable table = new JTable(tablesModelUtil);
			table.setToolTipText("Seleziona Una Riga Per Modificarla");
			JScrollPane scrollPane = new JScrollPane(table);
			scrollPane.setBounds(231, 11, 694, 551);
			add(scrollPane);
			
			
			adminFrame.setBounds(0, 0, 770, 480);
			adminFrame.getContentPane().add(tbm);
			adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			adminFrame.setLocationRelativeTo(null);
			adminFrame.setVisible(true);

		}

	}

}
