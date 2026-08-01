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
import metier.Participer;
import metier.Partie;

/**
 * Servlet implementation class Enregistrerpartie
 */
@WebServlet("/Enregistrerpartie")
public class Enregistrerpartie extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE ="/WEB-INF/Partie.jsp";    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Enregistrerpartie() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		List<Partie> lpart = new ArrayList<Partie>();
		Partie part = new Partie();
		lpart = part.getpartie();
		
		// CORRECTION 2 : Envoyer la liste "laff" au lieu de l'objet vide "aff"
		// Vous devez utiliser la clé "laff" ou "affaires" pour la récupérer dans votre JSP
		request.setAttribute("lpart", lpart);
		request.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idpartie = request.getParameter("idpartie");
		String libpartie = request.getParameter("libpartie");
		String adrpartie = request.getParameter("adrpartie");
		String telpartie = request.getParameter("telpartie");
		Partie part = new Partie();
		part.setIdpartie(idpartie);
		part.setLibpartie(libpartie);
		part.setAdrpartie(adrpartie);
		part.setTelpartie(telpartie);
		part.Enregistrer(part);
		doGet(request, response);
	}

}
