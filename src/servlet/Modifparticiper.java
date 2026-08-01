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

@WebServlet("/Modifparticiper")
public class Modifparticiper extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE1="/WEB-INF/modifparticiper.jsp";

    public Modifparticiper() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idpartie = request.getParameter("idpartie");
        String numaf = request.getParameter("numaf");
        Participer part1 = new Participer();
        part1 = part1.getparticiperbycode(idpartie, numaf);
        request.setAttribute("part", part1);

        List<Participer> lpart = new ArrayList<Participer>();
        Participer part = new Participer();
        lpart = part.getparticiper();
        request.setAttribute("lpart", lpart);
        request.getServletContext().getRequestDispatcher(VUE1).forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idpartie = request.getParameter("idpartie");
        String numaf = request.getParameter("numaf");
        String rolepartie = request.getParameter("rolepartie");

        Participer part = new Participer();
        part.setIdpartie(idpartie);
        part.setNumaf(numaf);
        part.setRolepartie(rolepartie);

        part.majparticiper(idpartie, numaf, part);

        response.sendRedirect("Modifparticiper?idpartie=" + idpartie + "&numaf=" + numaf);
    }
}
