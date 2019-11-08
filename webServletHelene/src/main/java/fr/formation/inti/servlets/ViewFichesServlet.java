package fr.formation.inti.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fr.formation.inti.entities.EntityView;
import fr.formation.inti.entities.Fiche;
import fr.formation.inti.entities.Patient;
import fr.formation.inti.service.PatientService;

/**
 * Servlet implementation class ViewFichesServlet
 */
@WebServlet("/view")
public class ViewFichesServlet extends HttpServlet {
	private static final Log log = LogFactory.getLog(ViewFichesServlet.class);
	private static final long serialVersionUID = 1L;

	PatientService service = new PatientService();

	public ViewFichesServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String hostName = "localhost";
		String dbName = "bdd";
		String userName = "root";
		String password = "1234";

		String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName + "?useSSL=false";

		List<EntityView> entView = new ArrayList<EntityView>();
		try {
			Connection conn = DriverManager.getConnection(connectionURL, userName, password);

			Statement stmt = conn.createStatement();
			String id = request.getParameter("viewFiche");
			int idd = Integer.parseInt(id);
			String sql = "Select nom\r\n" + ",prenom \r\n" + ",date_rdv\r\n" + ",poids\r\n" + "FROM bdd.patient \r\n"
					+ "INNER join bdd.fiche\r\n" + "on bdd.patient.pId = bdd.fiche.pId\r\n" + "where bdd.patient.pId = "
					+ id + ";";
			ResultSet rs = stmt.executeQuery(sql);
			EntityView ent;
			while (rs.next()) {
				ent = new EntityView();
				ent.setNom(rs.getString(1));
				ent.setPrenom(rs.getString(2));
				ent.setDateRdv(rs.getDate(3));
//				ent.setDateNaissance(rs.getDate(4));
				ent.setPoids(rs.getInt(4));
				entView.add(ent);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (EntityView e : entView) System.out.println(e.getDateRdv());
		request.setAttribute("patientView", entView);
		request.getRequestDispatcher("/viewFiche.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
