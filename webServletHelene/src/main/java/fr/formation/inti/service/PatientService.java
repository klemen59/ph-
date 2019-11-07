package fr.formation.inti.service;

import java.util.List;

import fr.formation.inti.dao.PatientDaoImpl;
import fr.formation.inti.entities.Patient;

public class PatientService {
	
	private static PatientDaoImpl dao;
	
	public PatientService() {
		dao = new PatientDaoImpl();
	}
	public void persist(Patient p) {
        dao.openCurrentSessionwithTransaction();
        dao.persist(p);
        dao.closeCurrentSessionwithTransaction();
    }
	public Integer save(Patient p) {
		Integer id;
        dao.openCurrentSessionwithTransaction();
        id = dao.save(p);
        dao.closeCurrentSessionwithTransaction();
        return id;
    }
    public void update(Patient p) {
    	
        dao.openCurrentSessionwithTransaction();
        dao.update(p);
        dao.closeCurrentSessionwithTransaction();
    }
 
    public Patient findById(Integer id) {
        dao.openCurrentSession();
        Patient patient = dao.findById(id);
        dao.closeCurrentSession();
        return patient;
    }
 
    public void delete(Integer id) {
        dao.openCurrentSessionwithTransaction();
        Patient patient = dao.findById(id);
        dao.delete(patient);
        dao.closeCurrentSessionwithTransaction();
    }
    public List<Patient> findAll() {
        dao.openCurrentSession();
        List<Patient> patients = dao.getAll();
        dao.closeCurrentSession();
        return patients;
    }
 
    
 
    public PatientDaoImpl PatientDao() {
        return dao;
    }
}
