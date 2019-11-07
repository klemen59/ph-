package fr.formation.inti.app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.formation.inti.utils.ConnectionUtils;


public class AppAfficheListeRdvPourUnPatient {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		// Get a connection
		Connection connection = ConnectionUtils.getMySQLConnection();

		// Create a SQL statement with two parameters (?)
		String sql = "Select nom\r\n" + 
				",prenom \r\n" + 
				",date_rdv\r\n" + 
				",poids\r\n" + 
				"FROM bdd.patient \r\n" + 
				"INNER join bdd.fiche\r\n" + 
				"on bdd.patient.pId = bdd.fiche.pId\r\n" + 
				"where bdd.patient.pId = ? \r\n";

		// Create a PreparedStatement object.
		PreparedStatement pstm = connection.prepareStatement(sql);

		// Set value for the first parameter (First '?')
		pstm.setInt(1, 1);

		ResultSet rs = pstm.executeQuery();

		while (rs.next()) {
			System.out.println(" ---- ");
			System.out.println("Nom : " + rs.getString(1));
			System.out.println("Prenom : " + rs.getString(2));
			System.out.println("Date de rdv : " + rs.getString(3));
			System.out.println("Poids : " + rs.getString(4));
		}

	}
}
