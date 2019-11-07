package fr.formation.inti.service;

import java.util.List;

import fr.formation.inti.dao.FicheDaoImpl;
import fr.formation.inti.entities.Fiche;

public class FicheService {
	
	private static FicheDaoImpl dao;
	
	public FicheService() {
		dao = new FicheDaoImpl();
	}
	public void persist(Fiche f) {
        dao.openCurrentSessionwithTransaction();
        dao.persist(f);
        dao.closeCurrentSessionwithTransaction();
    }
	public Integer save(Fiche f) {
		Integer id;
        dao.openCurrentSessionwithTransaction();
        id = dao.save(f);
        dao.closeCurrentSessionwithTransaction();
        return id;
    }
    public void update(Fiche f) {
    	
        dao.openCurrentSessionwithTransaction();
        dao.update(f);
        dao.closeCurrentSessionwithTransaction();
    }
 
    public Fiche findById(Integer id) {
        dao.openCurrentSession();
        Fiche fiche = dao.findById(id);
        dao.closeCurrentSession();
        return fiche;
    }
 
    public void delete(Integer id) {
        dao.openCurrentSessionwithTransaction();
        Fiche fiche = dao.findById(id);
        dao.delete(fiche);
        dao.closeCurrentSessionwithTransaction();
    }
    public List<Fiche> findAll() {
        dao.openCurrentSession();
        List<Fiche> fiches = dao.getAll();
        dao.closeCurrentSession();
        return fiches;
    }
 
    public FicheDaoImpl FicheDao() {
        return dao;
    }
}
