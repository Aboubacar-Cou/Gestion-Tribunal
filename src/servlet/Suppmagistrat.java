package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Magistrat;
import metier.Partie;

/**
 * Servlet implementation class Suppmagistrat
 */
@WebServlet("/Suppmagistrat")
public class Suppmagistrat extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE="/WEB-INF/frmmagistrat.jsp";   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Suppmagistrat() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String idmag =request.getParameter("param");
		Magistrat mag1 = new Magistrat();
		//supprimer les donner de la categorie 
		mag1.suppmagistrat(idmag);
		//recuperer les donnees de la table categorie
		List<Magistrat> lmag= new ArrayList<Magistrat>();
		Magistrat mag = new Magistrat();
		lmag = mag.getmagistrat();
		//placer les donnees dans le request
		request.setAttribute("lmag",lmag);
		
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
