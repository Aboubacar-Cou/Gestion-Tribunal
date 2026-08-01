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

@WebServlet("/modifmagistrat")
public class modifmagistrat extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String VUE1 = "/WEB-INF/modifmagistrat.jsp";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idmag = request.getParameter("param");
        Magistrat mag1 = new Magistrat();
        mag1 = mag1.getmagistratbycode(idmag);
        request.setAttribute("mag", mag1);

        List<Magistrat> lmag = new ArrayList<Magistrat>();
        Magistrat mag = new Magistrat();
        lmag = mag.getmagistrat();
        request.setAttribute("lmag", lmag);

        request.getServletContext().getRequestDispatcher(VUE1).forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idmag = request.getParameter("idmag");
        String nommag = request.getParameter("nommag");
        String prenommag = request.getParameter("prenommag");

        Magistrat mag = new Magistrat();
        mag.setIdmag(idmag);
        mag.setNommag(nommag);
        mag.setPrenommag(prenommag);

        mag.majmagistrat(idmag, mag);

        // correctif : redirection vers le bon servlet (modifmagistrat, pas Modifpartie)
        response.sendRedirect("modifmagistrat?param=" + idmag);
    }
}