package shippingmangment.utility;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import shippingmangment.classesmodel.Spedizione;


public class CaricaSpedizioni {
	private File source = new File("");
	public final String spedizioniSourcePath = source.getAbsolutePath() + source.separator + "src" + source.separator + "spedizione.txt";		

	List<Spedizione> listaSpedizioniRichiesta = new ArrayList<Spedizione>();
	String nomeCliente;

	public CaricaSpedizioni() {
		setListaSpedizioniRichiesta(getListaSpedizioniRichiestaAdmin());
	}

	public CaricaSpedizioni(String nomeCliente) {
		this.nomeCliente = nomeCliente;
		setListaSpedizioniRichiesta(getListaSpedizioniRichiestaCliente());
	}

	public List<Spedizione> getListaSpedizioniRichiestaAdmin() {
		listaSpedizioniRichiesta.clear();
		try {
			File file = new File (spedizioniSourcePath);
			Scanner scan = new Scanner(file);
			Spedizione spedizione = new Spedizione();

			while ((scan.hasNextLine())) {
				String line = scan.nextLine();
				if (line.startsWith("_")) {

					listaSpedizioniRichiesta.add(new Spedizione(spedizione.getCodice(), spedizione.getGaranziaAssicurativa(),
							spedizione.getDestinazione(), spedizione.getPeso(), spedizione.getDate(),
							spedizione.getTipo(), spedizione.getNome(), spedizione.getStato()));

				} else {
					spedizione.setNome(line);
					spedizione.setTipo(scan.nextLine());
					spedizione.setDestinazione(scan.nextLine());
					spedizione.setPeso(scan.nextLine());
					spedizione.setGaranziaAssicurativa(scan.nextLine());
					spedizione.setCodice(scan.nextLine());
					spedizione.setStatoLettura(scan.nextLine());
					spedizione.setDate(scan.nextLine());
				}
			}
			scan.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("caricamento spedizioni Fallito");
		}
		return listaSpedizioniRichiesta;
	}

	public List<Spedizione> getListaSpedizioniRichiestaCliente() {
		listaSpedizioniRichiesta.clear();
		try {
			File file = new File (spedizioniSourcePath);
			Scanner scan = new Scanner(file);
			Spedizione spedizione = new Spedizione();

			while ((scan.hasNextLine())) {
				String line = scan.nextLine();
				if (line.startsWith("_")) {

					listaSpedizioniRichiesta.add(new Spedizione(spedizione.getNome(), spedizione.getDestinazione(),
							spedizione.getPeso(), spedizione.getDate(), spedizione.getGaranziaAssicurativa(),
							spedizione.getTipo(), spedizione.getCodice(), spedizione.getStato()));

				} else {
					spedizione.setNome(line);
					spedizione.setTipo(scan.nextLine());
					spedizione.setDestinazione(scan.nextLine());
					spedizione.setPeso(scan.nextLine());
					spedizione.setGaranziaAssicurativa(scan.nextLine());
					spedizione.setCodice(scan.nextLine());
					spedizione.setStatoLettura(scan.nextLine());
					spedizione.setDate(scan.nextLine());

				}
			}
			scan.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Stampa Fallita");
		}
		for (Spedizione spedizone : listaSpedizioniRichiesta)
			if (!(spedizone.getNome().equals(nomeCliente)))
				listaSpedizioniRichiesta.remove(spedizone);
		
		return listaSpedizioniRichiesta;
	}

	public void setListaSpedizioniRichiesta(List<Spedizione> listaSpedizioniRichiesta) {
		this.listaSpedizioniRichiesta = listaSpedizioniRichiesta;
	}

	public void saveSpedizione(Spedizione spedizione) {
		try {
			int random_int = (int) (Math.random() * (999 - 1 + 1));
			spedizione.setCodice(random_int+"");
			spedizione.setStato(spedizione.getTipo());
			FileWriter fw = new FileWriter(spedizioniSourcePath, true);
			fw.append(spedizione.getNome() + "\n");
			fw.append(spedizione.getTipo() + "\n");
			fw.append(spedizione.getDestinazione() + "\n");
			fw.append(spedizione.getPeso() + "\n");
			fw.append(spedizione.getGaranziaAssicurativa() + "\n");
			fw.append(spedizione.getCodice() + "\n");
			fw.append(spedizione.getStato() + "\n");
			fw.append(spedizione.getDate() + "\n");
			fw.append("_______________________" + "\n");
			fw.close();
			System.out.println("spedizione aggiunta");
		} catch (IOException e) {
			System.out.println("spedzioen non aggiunta!!");
			e.printStackTrace();
		}
		
	}

	public void saveSpedizioni(List <Spedizione> spedizioni) {
		try {
			FileWriter fw = new FileWriter(spedizioniSourcePath, false);
			for(Spedizione spedizione: spedizioni)
			{
			fw.append(spedizione.getNome() + "\n");
			fw.append(spedizione.getTipo() + "\n");
			fw.append(spedizione.getDestinazione() + "\n");
			fw.append(spedizione.getPeso() + "\n");
			fw.append(spedizione.getGaranziaAssicurativa() + "\n");
			fw.append(spedizione.getCodice() + "\n");
			fw.append(spedizione.getStato() + "\n");
			fw.append(spedizione.getDate() + "\n");
			fw.append("_______________________" + "\n");
			}
			fw.close();
			System.out.println("file aggiornato ");
		} catch (IOException e) {
			System.out.println("file non aggiornato!!");
			e.printStackTrace();
		}
		
	}
}
