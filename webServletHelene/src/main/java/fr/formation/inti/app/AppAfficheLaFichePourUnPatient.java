package fr.formation.inti.app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.formation.inti.utils.ConnectionUtils;

public class AppAfficheLaFichePourUnPatient {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		// Get a connection
		Connection connection = ConnectionUtils.getMySQLConnection();

		// Create a SQL statement with two parameters (?)
		String sql = "Select *\r\n" + 
				"FROM bdd.patient \r\n" + 
				"INNER join bdd.fiche\r\n" + 
				"on bdd.patient.pId = bdd.fiche.pId\r\n" + 
				"where bdd.patient.pId = ? and bdd.fiche.idfiche= ? \r\n" + 
				";"; 
				// and bdd.fiche.idfiche = ?  \r\n 

		// Create a PreparedStatement object.
		PreparedStatement pstm = connection.prepareStatement(sql);

		// Set value for the first parameter (First '?')
		pstm.setInt(1, 1);
		
		// Set value for the second parameter (Second '?')		
		pstm.setInt(2, 3);

		ResultSet rs = pstm.executeQuery();

		while (rs.next()) {
			System.out.println(" ---- ");
			System.out.println("pId: " + rs.getString(1));
			System.out.println("Nom : " + rs.getString(2));
			System.out.println("Prenom : " + rs.getString(3));
			System.out.println("date de naissance : " + rs.getString(4));
			System.out.println("taille : " + rs.getString(5));
			System.out.println("idfiche : " + rs.getString(6));
			System.out.println("Date de rdv : " + rs.getString(8));
			System.out.println("Poids : " + rs.getString(9));
			System.out.println("Commentaire santé : " + rs.getString(10));
			System.out.println("Commentaire activité : " + rs.getString(11));
			System.out.println("Commentaire général : " + rs.getString(12));
		}

	}
}
