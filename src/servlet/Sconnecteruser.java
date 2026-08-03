package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import metier.User;

@WebServlet("/Sconnecteruser")
public class Sconnecteruser extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String VUE_ECHEC = "/user.jsp"; // ton formulaire actuel

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nomuser = request.getParameter("nomuser");
        String prenomuser = request.getParameter("prenomuser");
        String motdepasse = request.getParameter("motdepasse");

        User userMetier = new User();
        User connecte = userMetier.seConnecter(nomuser,prenomuser, motdepasse);

        if (connecte != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", connecte);
            response.sendRedirect("Accueil.jsp");
        } else {
            request.setAttribute("erreur", "Identifiant ou mot de passe incorrect");
            request.getServletContext().getRequestDispatcher(VUE_ECHEC).forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}