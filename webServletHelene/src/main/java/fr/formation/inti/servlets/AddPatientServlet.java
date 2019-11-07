package fr.formation.inti.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fr.formation.inti.entities.Patient;
import fr.formation.inti.service.PatientService;

/**
 * Servlet implementation class AddEmployeeServlet
 */
@WebServlet("/add")
public class AddPatientServlet extends HttpServlet {
	private static final Log log = LogFactory.getLog(AddPatientServlet.class);
	private static final long serialVersionUID = 1L;
	
	PatientService service = new PatientService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPatientServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String ddn = request.getParameter("ddn");
		String taille = request.getParameter("taille");
		
		
		Patient p = new Patient();
		p.setNom(nom);
		p.setPrenom(prenom);
		
		p.setDateNaissance(new Date());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date;
        try {
            date = format.parse(ddn);
            p.setDateNaissance(date);
        } catch (ParseException e1) {
            e1.printStackTrace();
        }
        
        p.setTaille(Integer.parseInt(taille)) ;
		Integer id = service.save(p);
		if (id !=null) { 
			String contextPath = request.getContextPath();
			response.sendRedirect(contextPath + "/helllo");
		}
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
