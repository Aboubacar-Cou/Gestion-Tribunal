package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Affaire;
import metier.Magistrat;
import metier.Participer;

/**
 * Servlet implementation class Enregistrerparticiper
 */
@WebServlet("/Enregistrerparticiper")
public class Enregistrerparticiper extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE ="/WEB-INF/frmparticiper.jsp";   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Enregistrerparticiper() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		List<Participer> lpart = new ArrayList<Participer>();
		Participer part = new Participer();
		lpart = part.getparticiper();
		request.setAttribute("lpart", lpart);
		
		List<Affaire> laff = new ArrayList<Affaire>();
		Affaire aff = new Affaire();
		laff = aff.getaffaire();
		request.setAttribute("laff", laff);
		request.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idpartie = request.getParameter("idpartie");
		String numaf = request.getParameter("numaf");
		String rolepartie = request.getParameter("rolepartie");
		Participer part = new Participer();
		part.setIdpartie(idpartie);
		part.setNumaf(numaf);
		part.setRolepartie(rolepartie);
		part.Enregistrer(part);
		doGet(request, response);
	}

}
