package shippingmangment.classesmodel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

import shippingmangment.frontend.Home;
import shippingmangment.utility.TablesModelUtil;

public class TableModel extends JPanel implements ActionListener {
	private JTable table;
	private Home home;
	JComboBox<String> comboBox;
	private JButton btnNewButton_1;
	private JCheckBox chckbxNewCheckBox;
	private TablesModelUtil tablesModelUtil;

	public TableModel(TablesModelUtil tablesModelUtil) {
		setBackground(Color.DARK_GRAY);
		this.tablesModelUtil = tablesModelUtil;
		JButton btnNewButton = new JButton("LOGOUT");
		btnNewButton.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 10));
		btnNewButton.setBounds(55, 359, 96, 38);
		btnNewButton.addActionListener(this);
		setLayout(null);
		add(btnNewButton);
		
			table = new JTable(tablesModelUtil);
			table.setToolTipText("Seleziona Una Spedizione Fallita");
			table.setBounds(29, 11, 503, 339);
			add(table);


		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(207, 11, 532, 416);
		add(scrollPane);

		chckbxNewCheckBox = new JCheckBox("RICHIEDI_RIMBORSO");
		chckbxNewCheckBox.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 10));
		chckbxNewCheckBox.setBounds(10, 45, 157, 23);
		add(chckbxNewCheckBox);

		btnNewButton_1 = new JButton("AGGIORNA STATO SPEDIZIONE");
		btnNewButton_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 10));
		btnNewButton_1.setBounds(10, 98, 187, 38);
		btnNewButton_1.addActionListener(this);
		add(btnNewButton_1);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TableModel.class.getResource("/packagingImage/cloud-database (1).png")));
		lblNewLabel.setBounds(10, 175, 187, 163);
		add(lblNewLabel);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String scelta = e.getActionCommand();

		if (scelta.equals("LOGOUT")) {
			Home home = new Home();
			SwingUtilities.windowForComponent(this).setVisible(false);
		}

		if (scelta.equals("AGGIORNA STATO SPEDIZIONE")) {

			int i = table.getSelectedRow();
			String strStato = (String) table.getValueAt(i, 6);
			String strTipo = (String) table.getValueAt(i, 1);

			if (chckbxNewCheckBox.isSelected() && strStato.equals("FALLITA") && strTipo.equals("Normale")) {
				JOptionPane.showMessageDialog(null, "Ci dispiace, La Tua Spedizione non è Assicurata !!");
			}

			else if (chckbxNewCheckBox.isSelected() && strStato.equals("FALLITA") && strTipo.equals("Assicurata")) {
				
				tablesModelUtil.setValueAt("RIMBORSO_RICHIESTO", i, 6);
				//table = new JTable(tb);
//				table.setBounds(29, 11, 503, 339);
//				JScrollPane scrollPane = new JScrollPane(table);
//				scrollPane.setBounds(207, 11, 532, 416);
//				add(scrollPane);
				JOptionPane.showMessageDialog(null, "Stato Aggiornato !!");
				 home = new Home();
				SwingUtilities.windowForComponent(this).setVisible(false);
			}

			else {
				JOptionPane.showMessageDialog(null, "Hai scelto Una Spedizione Non-Fallita !!");
			}
		}
	}

	/**
	 * @param comboBox the comboBox to set
	 * @return
	 */
//	public JComboBox<String> setComboBox() {

//		return comboBox;
//	}
//	
}
