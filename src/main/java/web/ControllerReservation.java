package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PanierDAO;
import model.Panier;

/**
 * Servlet implementation class ControllerReservation
 */
@WebServlet(name="reservation",urlPatterns = {"/listeReservation"})
public class ControllerReservation extends HttpServlet {
	private static final long serialVersionUID = 1L;
      PanierDAO pd = new PanierDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerReservation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path=request.getServletPath();
		if(path.equals("/listeReservation")) {
			List<Panier> lp = pd.ListReservation();
			request.setAttribute("reservations", lp);
			this.getServletContext().getRequestDispatcher("/listeReservations.jsp").forward(request, response);

		}
	}

}
