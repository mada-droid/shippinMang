package shippingmangment.classesmodel;

import java.io.Serializable;

public class Utente implements Serializable {

	private String username;
	private String password;
	private String indirizzo;

	public Utente() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param username
	 * @param password
	 * @param indirizzo
	 */
	public Utente(String username, String password, String indirizzo) {
		this.username = username;
		this.password = password;
		this.indirizzo = indirizzo;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the indirizzo
	 */
	public String getIndirizzo() {
		return indirizzo;
	}

	/**
	 * @param indirizzo the indirizzo to set
	 */
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	@Override
	public String toString() {
		return "Cliente [username=" + username + ", password=" + password + ", indirizzo=" + indirizzo + "]";
	}

}
