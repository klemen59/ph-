package fr.formation.inti.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.formation.inti.entities.Fiche;
import fr.formation.inti.entities.Patient;
import fr.formation.inti.utils.ConnectionUtils;
import fr.formation.inti.utils.Constants;


/**
 * Notre classe EmployeeDaoImpl suit le modèle de conception Singleton qui
 * garantit qu'une seule instance de cette classe sera créée dans l'application.
 * Lors de la première création de classe, la méthode getEntityManager () est
 * chargée de créer une instance de EntityManager.
 * 
 * @author 
 *
 */
public class FicheDaoImpl extends GenericDaoImpl<Fiche, Integer>{

	public FicheDaoImpl() {
		setClazz(Fiche.class);
	}


	public List<Patient> getLastDate() throws ClassNotFoundException, SQLException{
		
		 Connection connection = ConnectionUtils.getMySQLConnection();
		 Statement statement = connection.createStatement();
		 ResultSet rs = statement.executeQuery(Constants.LAST_RDV);
		 List<Patient> patient = new ArrayList();
		 List<Fiche> fiche = new ArrayList();
		 while (rs.next()) {
		     int idfiche = rs.getInt(1);
		     String nom = rs.getString(2);
		     String prenom = rs.getString(3);
		     Date dateRdv = rs.getDate(4);
		     patient.add(new Patient(idfiche, nom, prenom, dateRdv));
		 }

		 // Close connection.
		 connection.close();
		
		return patient;
		
	}
	

	
	
}
