package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import metier.Partie;

/**
 * Servlet implementation class suppPartie
 */
@WebServlet("/suppPartie")
public class suppPartie extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE="/WEB-INF/Partie.jsp";   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public suppPartie() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String idpartie =request.getParameter("param");
		Partie part1 = new Partie();
		//supprimer les donner de la categorie 
		part1.supppartie(idpartie);
		//recuperer les donnees de la table categorie
		List<Partie> lpart= new ArrayList<Partie>();
		Partie part = new Partie();
		lpart = part.getpartie();
		//placer les donnees dans le request
		request.setAttribute("lpart",lpart);
		
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
