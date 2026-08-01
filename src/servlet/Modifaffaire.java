package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Affaire;
import metier.Partie;

/**
 * Servlet implementation class Modifaffaire
 */
@WebServlet("/Modifaffaire")
public class Modifaffaire extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE1="/WEB-INF/modifaffaire.jsp";
	private static final String VUE2="/WEB-INF/suppaffaire.jsp";   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Modifaffaire() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String numaf = request.getParameter("param");
		Affaire aff1 = new Affaire();
		aff1 = aff1.getaffairebycode(numaf);
		request.setAttribute("aff", aff1);
		
		// Récupérer la liste complète des parties pour l'affichage en bas
		List<Affaire> laff = new ArrayList<Affaire>();
		Affaire aff = new Affaire();
		laff = aff.getaffaire();
		
		request.setAttribute("laff", laff);
		request.getServletContext().getRequestDispatcher(VUE1).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String numaf = request.getParameter("numaf");
	    String Datedebut = request.getParameter("datedebut");
	    String nature = request.getParameter("nature");
	    String typeaf = request.getParameter("typeaf");
	    String idmag = request.getParameter("idmag");

	    java.util.Date datedebut = stringtodate(Datedebut);

	    Affaire aff = new Affaire();
	    aff.setNumaf(numaf);
	    aff.setDatedebut(datedebut);
	    aff.setNature(nature);
	    aff.setTypeaf(typeaf);
	    aff.setIdmag(idmag);
	    aff.majaffaire(numaf, aff);
		
		doGet(request, response);
	}

	public java.util.Date stringtodate(String st){
		if (st == null || st.trim().isEmpty()) {
			return null;
		}
		java.util.Date unedate = null;
		SimpleDateFormat sdf_en = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf_fr = new SimpleDateFormat("dd/MM/yyyy");
		if(st.contains("/")) {
			try {
				unedate = sdf_fr.parse(st);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		else {
			try {
				unedate = sdf_en.parse(st);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return unedate;
	}
}
