package it.polito.tdp.corsi.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.polito.tdp.corsi.db.CorsoDAO;

public class Model {
	private CorsoDAO corsoDao;
	
	public Model() {
		corsoDao = new CorsoDAO();
	}
	
	public List<Corso> getCorsiByPeriodo(Integer pd){
		return corsoDao.getCorsiByPeriodo(pd);
	}
	
	public Map<Corso, Integer> getIscrittiByPeriodo(Integer pd){
		return corsoDao.getIscrittiByPeriodo(pd);
	}
	
	public List<Studente> getStudentiByCorso(String codins){
		return corsoDao.getStudentiByCorso(new Corso(codins, null, null, null));
	}
	
	
	public Map<String, Integer> getDivisioneCDS(String codins){
		/* SOLUZIONE 1 DIVISIONE STUDENTI
		Map<String, Integer> divisione = new HashMap<String, Integer>();
		List<Studente> studenti = this.getStudentiByCorso(codins);
		
		for(Studente s : studenti) {
			if(s.getCds() != null && !s.getCds().equals("")) {
				if(divisione.get(s.getCds()) == null) {
					divisione.put(s.getCds(), 1);
				}
				else {
					divisione.put(s.getCds(), divisione.get(s.getCds())+1);
				}
			}
		}
		
		return divisione;*/
		
		//SOLUZIONE 2
		return corsoDao.getDivisioneStudenti(new Corso(codins, null, null, null));
	}
	
	public boolean esisteCorso(String codins) {
		return corsoDao.esisteCorso(new Corso(codins, null, null, null));
	}
}
