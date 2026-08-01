package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Participer;

/**
 * Servlet implementation class suppParticiper
 */
@WebServlet("/suppParticiper")
public class suppParticiper extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String VUE ="/WEB-INF/frmparticiper.jsp";   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public suppParticiper() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String idparticiper =request.getParameter("param");
		Participer part1 = new Participer();
		//supprimer les donner de la categorie 
		part1.suppparticiper(idparticiper);
		//recuperer les donnees de la table categorie
		List<Participer> lpart= new ArrayList<Participer>();
		Participer part = new Participer();
		lpart = part.getparticiper();
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
