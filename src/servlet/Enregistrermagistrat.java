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
import metier.Participer;

/**
 * Servlet implementation class Enregistrermagistrat
 */
@WebServlet("/Enregistrermagistrat")
public class Enregistrermagistrat extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE ="/WEB-INF/frmmagistrat.jsp";   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Enregistrermagistrat() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		List<Magistrat> lmag = new ArrayList<Magistrat>();
		Magistrat mag = new Magistrat();
		lmag = mag.getmagistrat();
		request.setAttribute("lmag", lmag);
		request.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idmag = request.getParameter("idmag");
		String nommag = request.getParameter("nommag");
		String prenommag = request.getParameter("prenommag");
		Magistrat mag = new Magistrat();
		mag.setIdmag(idmag);
		mag.setNommag(nommag);
		mag.setPrenommag(prenommag);
		mag.Enregistrer(mag);
		doGet(request, response);
	}

}
