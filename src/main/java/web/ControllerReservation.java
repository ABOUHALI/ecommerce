package web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PanierDAO;
import model.Panier;
import model.Produit;

/**
 * Servlet implementation class ControllerReservation
 */
@WebServlet(name="reservation",urlPatterns = {"/listeReservation","/mesreservations"})
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
		HttpSession session = request.getSession();
		if(path.equals("/listeReservation")) {
			List<Panier> lp = pd.ListReservation();
			request.setAttribute("paniers", lp);
			this.getServletContext().getRequestDispatcher("/listeReservations.jsp").forward(request, response);

		}else if(path.equals("/mesreservations")) {
			String idcc=String.valueOf(session.getAttribute("idclient"));
			//System.out.println(idcc);
			int idc =Integer.parseInt(idcc);
			
			List<Panier> lp = pd.ListReservation();
			List<Panier> mesReserv = new ArrayList<Panier>();
			for (Panier  panier : lp) {
				if(panier.getIdclient()==idc) {
					mesReserv.add(panier);
				}
			}
			System.out.println(lp);
			System.out.print(idc);
			System.out.println(mesReserv);
			request.setAttribute("reservations", mesReserv);
			this.getServletContext().getRequestDispatcher("/contacts.jsp").forward(request, response);

		}
	}

}
