package shippingmangment.utility;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import shippingmangment.classesmodel.Utente;

public class ClientManagement {
	private File source = new File("");
	public final String usersSourcePath = source.getAbsolutePath() + source.separator + "src" + source.separator
			+ "users.txt";

	public ClientManagement() {
	}

	public boolean validatePassword(String username, String password) {
		List<Utente> listaUtenti = new ArrayList<Utente>();
		Utente utente = new Utente();
		try {
			File sourceUtenti = new File(usersSourcePath);
			Scanner scan = new Scanner(sourceUtenti);
			// Lettura file users.txt
			while ((scan.hasNextLine())) {
				String line = scan.nextLine();
				if (line.startsWith("_")) {
					listaUtenti.add(new Utente(utente.getUsername(), utente.getPassword(), utente.getIndirizzo()));

				} else {
					utente.setUsername(line);
					utente.setPassword(scan.nextLine());
					utente.setIndirizzo(scan.nextLine());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Lettura usersSource fallita");
		}

		for (Utente user : listaUtenti)
			if (user.getUsername().equals(username) && user.getPassword().equals(password))
				return true;

		return false;

	}

	public boolean isUser(String username) {
		List<Utente> listaUtenti = new ArrayList<Utente>();
		Utente utente = new Utente();
		try {
			File sourceUtenti = new File(usersSourcePath);
			Scanner scan = new Scanner(sourceUtenti);
			// Lettura file users.txt
			while ((scan.hasNextLine())) {
				String line = scan.nextLine();
				if (line.startsWith("_")) {
					listaUtenti.add(new Utente(utente.getUsername(), utente.getPassword(), utente.getIndirizzo()));

				} else {
					utente.setUsername(line);
					utente.setPassword(scan.nextLine());
					utente.setIndirizzo(scan.nextLine());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Lettura usersSource fallita");
		}

		for (Utente user : listaUtenti)
			if (user.getUsername().equals(username))
				return true;

		return false;

	}

	public boolean saveUser(Utente utente) {
		List<Utente> listaUtenti = new ArrayList<Utente>();
		Utente utenteTemp = new Utente();
		try {
			File sourceUtenti = new File(usersSourcePath);
			Scanner scan = new Scanner(sourceUtenti);
			// Lettura file users.txt
			while ((scan.hasNextLine())) {
				String line = scan.nextLine();
				if (line.startsWith("_")) {
					listaUtenti.add(
							new Utente(utenteTemp.getUsername(), utenteTemp.getPassword(), utenteTemp.getIndirizzo()));

				} else {
					utenteTemp.setUsername(line);
					utenteTemp.setPassword(scan.nextLine());
					utenteTemp.setIndirizzo(scan.nextLine());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Lettura usersSource fallita");
		}

		listaUtenti.add(utente);
		try {
			FileWriter fw = new FileWriter(usersSourcePath, false);

			for (Utente user : listaUtenti) {
				fw.append(user.getUsername() + "\n");
				fw.append(user.getPassword() + "\n");
				fw.append(user.getIndirizzo() + "\n");
				fw.append("_______________________" + "\n");
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("erroe nel aggiornamento degli utenti");
			return false;
		}

		System.out.println("utente aggiunto correttamente");
		return true;
	};

}
