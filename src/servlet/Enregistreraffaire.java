package servlet;

import java.io.IOException;
// CORRECTION 1 : Suppression de l'import java.sql.Date pour éliminer les conflits
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
import metier.Magistrat;


@WebServlet("/Enregistreraffaire")
public class Enregistreraffaire extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String VUE="/WEB-INF/frmaffaire.jsp";   

    public Enregistreraffaire() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Affaire> laff = new ArrayList<Affaire>();
		Affaire aff = new Affaire();
		laff = aff.getaffaire();
		
		 List<Magistrat> lmag = new ArrayList<Magistrat>();
		   Magistrat mag = new Magistrat();
		    lmag = mag.getmagistrat(); // méthode à adapter selon votre classe métier
		    request.setAttribute("lmag", lmag);
		request.setAttribute("laff", laff);
		
		request.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		aff.Enregistrer(aff);
		//response.sendRedirect("Enregistreraffaire");
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
