package fr.formation.inti.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fr.formation.inti.entities.Fiche;
import fr.formation.inti.entities.Patient;
import fr.formation.inti.service.FicheService;
import fr.formation.inti.service.PatientService;
import fr.formation.inti.utils.ConnectionUtils;
import fr.formation.inti.utils.Constants;

/**
	 * 
	 */
/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/helllo")
public class HelloServlet extends HttpServlet {
	private static final Log log = LogFactory.getLog(HelloServlet.class);
	private static final long serialVersionUID = 1L;
	
	FicheService serviceF = new FicheService();


	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HelloServlet() {
		super();
	
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		List<Fiche> fiche = serviceF.findAll();
		request.setAttribute("fiche", fiche);
		request.getRequestDispatcher("/HelloWorld.jsp").forward(request, response);
	}

		
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doGet(request, response);
	}

}
