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

/**
 * Servlet implementation class suppaffaire
 */
@WebServlet("/suppaffaire")
public class suppaffaire extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE = "/WEB-INF/frmaffaire.jsp";
   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public suppaffaire() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String numaf =request.getParameter("param");
		Affaire aff1 = new Affaire();
		//supprimer les donner de la categorie 
		aff1.suppaffaire(numaf);
		//recuperer les donnees de la table categorie
		List<Affaire> laff= new ArrayList<Affaire>();
		Affaire aff = new Affaire();
		laff = aff.getaffaire();
		//placer les donnees dans le request
		request.setAttribute("laff",laff);
		
		//ouvrir le formulaire
		request.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
