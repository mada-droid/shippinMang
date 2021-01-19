package shippingmangment.frontend;

import java.io.File;

import javax.swing.JFrame;

public class Home extends JFrame{
	public Home() {
		super("HomeScreen");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		LoginPage logiinPage = new LoginPage();
		add(logiinPage);
		setBounds(0,0, 600, 600);
		setLocationRelativeTo(null);
		setVisible(true);

}}
