package shippingmangment.classesmodel;

import java.util.ArrayList;
import java.util.List;

public class Stato {
	private String defaultStato;
	private List<String> listadiStati = new ArrayList<String>();

	public Stato(String tipo) {

		switch (tipo) {
		case "Assicurata":
			this.defaultStato = "IN_PREPARAZIONEAssicurata";
			listadiStati.add("IN_TRANSITO");
			listadiStati.add("RICEVUTA");
			listadiStati.add("FALLITA");
			listadiStati.add("RIMBORSO_RICHIESTO");
			listadiStati.add("RIMBORSO_EROGATO");
			break;
		case "Normale":
			this.defaultStato = "IN_PREPARAZIONENormale";
			listadiStati.add("IN_TRANSITO");
			listadiStati.add("RICEVUTA");
			listadiStati.add("FALLITA");
			break;
		}

		
		
		
	}

	public String getDefaultStato() {
		return defaultStato;
	}

	public void setDefaultStato(String defaultStato) {
		this.defaultStato = defaultStato;
	}
}
