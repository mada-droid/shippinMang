package shippingmangment.classesmodel;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


/**
 * @author Mada
 *
 */
public class Spedizione implements Serializable {

	private String codice;
	private String garanziaAssicurativa;
	private String destinazione;
	private String peso;
	private String date;
	private String tipo;
	private String nome;
	private String stato;
	
	public Spedizione() {
	}

	public Spedizione(String nome, String destinazione, String peso, String date, String garanziaAssicurativa,
			String tipo, String codice) {
		this.codice = codice;
		this.nome = nome;
		this.destinazione = destinazione;
		this.peso = peso;
		this.garanziaAssicurativa = garanziaAssicurativa;
		this.tipo = tipo;
		this.date = date;
		setStato(tipo);
	}

	public Spedizione(String codice, String garanziaAssicurativa, String destinazione, String peso, String date,
			String tipo, String nome, String stato) {
		this.codice = codice;
		this.nome = nome;
		this.destinazione = destinazione;
		this.peso = peso;
		this.date = date;
		this.garanziaAssicurativa = garanziaAssicurativa;
		this.tipo = tipo;
		this.stato = stato;
	}

	//
//		/**
//		 * @return the comboBox
//		 */
//		public JComboBox<String> getComboBox() {
//			return comboBox;
//		}
	//
	//
	//
//		/**
//		 * @param comboBox the comboBox to set
//		 */
//		public void setComboBox() {
//			 String[] dir = new String[5];
//			 dir[0]="IN_PREPARAZIONE";
//			 dir[0]="IN_TRANSITO";
//			 dir[0]="RICEVUTA";
//			 dir[0]="FALLITA";
//			 comboBox.setModel(new DefaultComboBoxModel<>(dir));
//		}

	
	public String getCodice() {
		return codice;
	}

	public String getDestinazione() {
		return destinazione;
	}

	public void setDestinazione(String destinazione) {
		this.destinazione = destinazione;
	}

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
//					
		this.date = date;
	}

	public String getGaranziaAssicurativa() {
		return garanziaAssicurativa;
	}

	public void setGaranziaAssicurativa(String garanziaAssicurativa) {
		this.garanziaAssicurativa = garanziaAssicurativa;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public String getStato() {
		return stato;
	}

	
	public void setStato(String tipo) {
		switch (tipo) {
		case "Assicurata":
			this.stato = "IN_PREPARAZIONEAssicurata";
//			listadiStati.add("IN_TRANSITO");
//			listadiStati.add("RICEVUTA");
//			listadiStati.add("FALLITA");
//			listadiStati.add("RIMBORSO_RICHIESTO");
//			listadiStati.add("RIMBORSO_EROGATO");
			break;
		case "Normale":
			this.stato = "IN_PREPARAZIONENormale";
//			listadiStati.add("IN_TRANSITO");
//			listadiStati.add("RICEVUTA");
//			listadiStati.add("FALLITA");
			break;
		}
	}
	
	public void setStatoLettura(String stato) {
	this.stato = stato;
	}
	
	
	
	

	public Object[] toArray() {
		Object object[] = new Object[7];

		object[0] = this.nome;
		object[1] = this.tipo;
		object[2] = this.destinazione;
		object[3] = this.peso;
		object[4] = this.garanziaAssicurativa;
		object[5] = this.codice;
		object[6] = this.stato;

		return object;
	}

}
