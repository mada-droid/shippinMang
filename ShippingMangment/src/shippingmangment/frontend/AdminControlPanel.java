package shippingmangment.frontend;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import shippingmangment.classesmodel.Spedizione;
import shippingmangment.classesmodel.TableModel;
import shippingmangment.utility.CaricaSpedizioni;
import shippingmangment.utility.TablesModelUtil;

public class AdminControlPanel extends JPanel implements ActionListener {

	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JTable table;
	private JTextField textField;
	private String statoPassato;
	protected static ButtonGroup bg;
	protected JCheckBox chckbxNewCheckBox;
	protected JCheckBox chckbxNewCheckBox_1;
	protected JCheckBox chckbxNewCheckBox_2;
	protected JCheckBox chckbxNewCheckBox_3;
	private JButton btnNewButton_3;

	private Home home ;
	private List<Spedizione> listSpedizioni;
	TablesModelUtil tablesModelUtil ;

	/**
	 * Create the panel.
	 */
	public AdminControlPanel() {
		setBackground(Color.DARK_GRAY);
		CaricaSpedizioni caricaSpedizioni = new CaricaSpedizioni();
		this.listSpedizioni = caricaSpedizioni.getListaSpedizioniRichiestaAdmin();

		btnNewButton = new JButton("LOGOUT");
		btnNewButton.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 13));
		btnNewButton.setBounds(121, 511, 100, 32);
		btnNewButton.addActionListener(this);
		setLayout(null);
		add(btnNewButton);

		TablesModelUtil tablesModelUtil= new TablesModelUtil(listSpedizioni);
		//TableModel tableModel = new TableModel(tablesModelUtil);
		table = new JTable(tablesModelUtil);
		table.setToolTipText("Seleziona Una Riga Per Modificarla");

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(231, 11, 694, 551);
		add(scrollPane);

		bg = new ButtonGroup();

		btnNewButton_2 = new JButton("Aggiorna Stato");
		btnNewButton_2.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 13));
		btnNewButton_2.setBounds(48, 244, 133, 32);
		btnNewButton_2.addActionListener(this);
		add(btnNewButton_2);

		chckbxNewCheckBox = new JCheckBox("RICEVUTA");
		chckbxNewCheckBox.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 10));
		chckbxNewCheckBox.setBounds(21, 100, 118, 23);
		add(chckbxNewCheckBox);

		chckbxNewCheckBox_1 = new JCheckBox("RIMBORSO_EROGATO");
		chckbxNewCheckBox_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 10));
		chckbxNewCheckBox_1.setBounds(21, 178, 133, 23);
		add(chckbxNewCheckBox_1);

		chckbxNewCheckBox_2 = new JCheckBox("IN_TRANSITO");
		chckbxNewCheckBox_2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 10));
		chckbxNewCheckBox_2.setBounds(92, 61, 118, 23);
		add(chckbxNewCheckBox_2);

		chckbxNewCheckBox_3 = new JCheckBox("FALLITA");
		chckbxNewCheckBox_3.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 10));
		chckbxNewCheckBox_3.setBounds(92, 140, 118, 23);
		add(chckbxNewCheckBox_3);

		JCheckBox chckbxNewCheckBox_4 = new JCheckBox("IN_PREPARAZIONE", true);
		chckbxNewCheckBox_4.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 10));
		chckbxNewCheckBox_4.setBounds(21, 22, 133, 23);
		add(chckbxNewCheckBox_4);

		bg.add(chckbxNewCheckBox);
		bg.add(chckbxNewCheckBox_1);
		bg.add(chckbxNewCheckBox_2);
		bg.add(chckbxNewCheckBox_3);
		bg.add(chckbxNewCheckBox_4);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(AdminControlPanel.class.getResource("/packagingImage/cloud-database (1).png")));
		lblNewLabel.setBounds(10, 309, 211, 159);
		add(lblNewLabel);

		btnNewButton_3 = new JButton("Remove");
		btnNewButton_3.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 13));
		btnNewButton_3.setBounds(10, 512, 100, 32);
		btnNewButton_3.addActionListener(this);
		add(btnNewButton_3);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String scelta = e.getActionCommand();
		System.out.println(scelta);
		
		try {
			if (scelta.equals("LOGOUT")) {
				Home home = new Home ();
				SwingUtilities.windowForComponent(this).setVisible(false);}

			int i = table.getSelectedRow();
			String strStato_1 = (String) table.getValueAt(i, 6);
			String strTipo_1 = (String) table.getValueAt(i, 2);
			String nome_rimosso = (String) table.getValueAt(i, 5);

			if (scelta.equals("Remove")) {
				
				 tablesModelUtil = new TablesModelUtil();
				 tablesModelUtil.removeSpedizione(nome_rimosso);
				JOptionPane.showMessageDialog(null, "Spedizione Rimossa");
				 home = new Home();
				SwingUtilities.windowForComponent(this).setVisible(false);
			}

			if (scelta.equals("Aggiorna Stato")) {

				if (chckbxNewCheckBox.isSelected() && table.getValueAt(i, 6).equals("RICEVUTA")
						|| (chckbxNewCheckBox.isSelected() && table.getValueAt(i, 6).equals("RIMBORSO_EROGATO"))) {
					JOptionPane.showMessageDialog(null, "Operazione Non Disponibile Per Tale Spedizione !!");
				} else if (chckbxNewCheckBox_1.isSelected() && strTipo_1.equals("Normale")
						|| (chckbxNewCheckBox_1.isSelected() && strTipo_1.equals("Normale"))) {
					JOptionPane.showMessageDialog(null, "Errore, La Spedizione è di tipo Normale !!");
				} else if (chckbxNewCheckBox_1.isSelected() && strStato_1.equals("RICEVUTA")
						|| (chckbxNewCheckBox_1.isSelected() && strStato_1.equals("RIMBORSO_EROGATO"))) {
					JOptionPane.showMessageDialog(null, "Operazione Non Disponibile Per Tale Spedizione !!");
				} else if (chckbxNewCheckBox_2.isSelected() && strStato_1.equals("RICEVUTA")
						|| (chckbxNewCheckBox_2.isSelected() && strStato_1.equals("RIMBORSO_EROGATO"))) {
					JOptionPane.showMessageDialog(null, "Operazione Non Disponibile Per Tale Spedizione !!");
				} else if (chckbxNewCheckBox_3.isSelected() && strStato_1.equals("RICEVUTA")
						|| (chckbxNewCheckBox_3.isSelected() && strStato_1.equals("RIMBORSO_EROGATO"))) {
					JOptionPane.showMessageDialog(null, "Operazione Non Disponibile Per Tale Spedizione !!");
				}

				else if (chckbxNewCheckBox.isSelected() && !strStato_1.equals("RICEVUTA")
						|| (chckbxNewCheckBox.isSelected() && !strStato_1.equals("RIMBORSO_EROGATO"))) {


					tablesModelUtil.setValueAt(chckbxNewCheckBox.getText(), i, 6);
//				table = new JTable(tb);
//				table.setBounds(29, 11, 503, 339);
//				JScrollPane scrollPane = new JScrollPane(table);
//				scrollPane.setBounds(231, 11, 694, 551);
//				add(scrollPane);
					JOptionPane.showMessageDialog(null, "Stato Aggiornato !!");
					Home home1 = new Home();
					SwingUtilities.windowForComponent(this).setVisible(false);

				} else if (chckbxNewCheckBox_1.isSelected()) {
					tablesModelUtil.setValueAt(chckbxNewCheckBox_3.getText(), i, 6);
					table = new JTable(tablesModelUtil);
					table.setBounds(29, 11, 503, 339);
					JScrollPane scrollPane = new JScrollPane(table);
					scrollPane.setBounds(231, 11, 694, 551);
					add(scrollPane);
					JOptionPane.showMessageDialog(null, "Stato Aggiornato");
					home = new Home ();
					SwingUtilities.windowForComponent(this).setVisible(false);
				}

				else if (chckbxNewCheckBox_2.isSelected()) {
					tablesModelUtil.setValueAt(chckbxNewCheckBox_2.getText(), i, 6);
					table = new JTable(tablesModelUtil);
					table.setBounds(29, 11, 503, 339);
					JScrollPane scrollPane = new JScrollPane(table);
					scrollPane.setBounds(231, 11, 694, 551);
					add(scrollPane);
					JOptionPane.showMessageDialog(null, "Stato Aggiornato");
					home = new Home ();
					SwingUtilities.windowForComponent(this).setVisible(false);
				}

				else if (chckbxNewCheckBox_3.isSelected()) {
					tablesModelUtil.setValueAt(chckbxNewCheckBox_3.getText(), i, 6);
					table = new JTable(tablesModelUtil);
					table.setBounds(29, 11, 503, 339);
					JScrollPane scrollPane = new JScrollPane(table);
					scrollPane.setBounds(231, 11, 694, 551);
					add(scrollPane);
					JOptionPane.showMessageDialog(null, "Stato Aggiornato");
					 home = new Home();
					SwingUtilities.windowForComponent(this).setVisible(false);
				}

			}
			

		} catch (IndexOutOfBoundsException e1) {

		}
	}
}
	
