package shippingmangment.utility;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import shippingmangment.classesmodel.Spedizione;


	public class TablesModelUtil extends AbstractTableModel {

		public TablesModelUtil() {
			// TODO Auto-generated constructor stub
		}
		
		private List<Spedizione> listSpedizioni;
		private List<Spedizione> listSpedizioniCliente;

	
		public TablesModelUtil(List<Spedizione> listSpedizioni) {
			this.listSpedizioni = listSpedizioni;
			
		}


		@Override
		public int getColumnCount() {
			return 8;
		}

		@Override
		public int getRowCount() {
			return listSpedizioni.size();
		}

		@Override
		public Object getValueAt(int row, int col) {

			switch (col) {

			case 0:
				return listSpedizioni.get(row).getNome();
			case 1:
				return listSpedizioni.get(row).getTipo();
			case 2:
				return listSpedizioni.get(row).getDestinazione();
			case 3:
				return listSpedizioni.get(row).getPeso();
			case 4:
				return listSpedizioni.get(row).getGaranziaAssicurativa();
			case 5:
				return listSpedizioni.get(row).getCodice();
			case 6:
				return listSpedizioni.get(row).getStato();
			case 7:
				return listSpedizioni.get(row).getDate();
			}

			return "";

		}


//		@Override
//		public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
//			try {
//				if(((String)aValue).equals("RIMBORSO_RICHIESTO")) {
//					File file = new File("");
//					File filenew = new File(
//							file.getAbsolutePath() + file.separator + "src" + file.separator + "spedizione.txt");
//				String codiceSpedizioneDaModificare ;
//					listSpedizioni.clear();
//					getSpedzioni();
//					codiceSpedizioneDaModificare =	listSpedizioniCliente.get(rowIndex).getCodice();
//					
//					
//					//Eseguo Loop nella lista di spedizioni e modico solo la spedizione del cliente Falita
//					for(Spedizione spedizione : listSpedizioni)
//						if(spedizione.getCodice().equals(codiceSpedizioneDaModificare))
//							//modifico lo stato della spedizione 
//							spedizione.getStato().setDefaultStato(((String)aValue));
//					FileWriter fw = new FileWriter(filenew, false);
//
//					for (Spedizione spedizione : listSpedizioni) {
//						fw.append(spedizione.getNome() + "\n");
//						fw.append(spedizione.getTipo() + "\n");
//						fw.append(spedizione.getDestinazione() + "\n");
//						fw.append(spedizione.getPeso() + "\n");
//						fw.append(spedizione.getGaranziaAssicurativa() + "\n");
//						fw.append(spedizione.getCodice() + "\n");
//						fw.append(spedizione.getStato().getDefaultStato() + "\n");
//						fw.append("_______________________" + "\n");
//					}
//					fw.close();
//					
//					
//				}
//				
//				else {
//				File file = new File("");
//				File filenew = new File(
//						file.getAbsolutePath() + file.separator + "src" + file.separator + "spedizione.txt");
//				listSpedizioni.get(rowIndex).getStato().setDefaultStato(aValue.toString());
//				FileWriter fw = new FileWriter(filenew, false);
//
//				for (Spedizione spedizione : listSpedizioni) {
//					fw.append(spedizione.getNome() + "\n");
//					fw.append(spedizione.getTipo() + "\n");
//					fw.append(spedizione.getDestinazione() + "\n");
//					fw.append(spedizione.getPeso() + "\n");
//					fw.append(spedizione.getGaranziaAssicurativa() + "\n");
//					fw.append(spedizione.getCodice() + "\n");
//					fw.append(spedizione.getStato().getDefaultStato() + "\n");
//					fw.append("_______________________" + "\n");
//				}
//				fw.close();}
//			} catch (FileNotFoundException e) {
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//		}

		public void removeSpedizione(String codice) {
			List <Spedizione> temp = new ArrayList<Spedizione>();
			CaricaSpedizioni carica = new CaricaSpedizioni();
			temp = carica.getListaSpedizioniRichiestaAdmin();
			for( Spedizione spedizione : temp) {
				if(spedizione.getCodice().equals(codice)) {
					temp.remove(spedizione);
					break;
				}
			}
			carica.saveSpedizioni(temp);
		}

	}


