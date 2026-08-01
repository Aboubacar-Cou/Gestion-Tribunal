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

@WebServlet("/Modifpartie")
public class Modifpartie extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE1="/WEB-INF/modifpartie.jsp";
	// Note : VUE2 n'est pas utilisée ici, vous pouvez la garder ou la supprimer

    public Modifpartie() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idpartie = request.getParameter("param");
		Partie part1 = new Partie();
		part1 = part1.getpartiebycode(idpartie);
		request.setAttribute("part", part1);
		
		// Récupérer la liste complète des parties pour l'affichage en bas
		List<Partie> lpart = new ArrayList<Partie>();
		Partie part = new Partie();
		lpart = part.getpartie();
		
		request.setAttribute("lpart", lpart);
		request.getServletContext().getRequestDispatcher(VUE1).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idpartie = request.getParameter("idpartie");
		String libpartie = request.getParameter("libpartie");
		String adrpartie = request.getParameter("adrpartie");
		String telpartie = request.getParameter("telpartie");
		
		Partie part = new Partie();
		part.setIdpartie(idpartie);
		part.setLibpartie(libpartie);
		part.setAdrpartie(adrpartie);
		part.setTelpartie(telpartie);
		
		// Exécution de la mise à jour dans la base de données
		part.majpartie(idpartie, part);
		
		// CORRECTION CRITIQUE : Au lieu de mélanger doGet et forward, 
		// on redirige proprement vers le doGet pour rafraîchir la page avec le bon paramètre modifié.
		// Cela évite l'erreur d'état de réponse de Tomcat.
		response.sendRedirect("Modifpartie?param=" + idpartie);
	}
}
