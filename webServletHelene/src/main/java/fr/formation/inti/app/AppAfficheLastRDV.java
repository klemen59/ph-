package fr.formation.inti.app;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import fr.formation.inti.utils.ConnectionUtils;
import fr.formation.inti.utils.Constants;

public class AppAfficheLastRDV {

		 public static void main(String[] args) throws ClassNotFoundException,
	     SQLException {

	 // Get Connection
	 Connection connection = ConnectionUtils.getMySQLConnection();

	 // Create statement
	 Statement statement = connection.createStatement();

	 // Execute SQL statement returns a ResultSet object.
	 ResultSet rs = statement.executeQuery(Constants.LAST_RDV);

	 // Fetch on the ResultSet        
	 // Move the cursor to the next record.
	 while (rs.next()) {
	     int idfiche = rs.getInt(1);
	     String nom = rs.getString(2);
	     String prenom = rs.getString(3);
	     Date dateRdv = rs.getDate(4);
	     System.out.println("--------------------");
	     System.out.println("EmpId:" + idfiche);
	     System.out.println("EmpNo:" + nom);
	     System.out.println("EmpName:" + prenom);
	     System.out.println("EmpName:" + dateRdv);
	 }

	 // Close connection.
	 connection.close();
	}

	

}
