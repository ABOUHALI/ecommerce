package web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FournissuerDAO;
import model.Fournisseur;

/**
 * Servlet implementation class ControllerFournisseur
 */
@WebServlet(name="fournisseur",urlPatterns = {"/listeFournisseur","/ajoutFournisseur"})
public class ControllerFournisseur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	FournissuerDAO fd =new FournissuerDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerFournisseur() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
doPost(request, response);	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = request.getServletPath();
		if(path.equals("/listeFournisseur")) {
				List<Fournisseur> lf=new ArrayList<Fournisseur>();
				lf=fd.ListFournisseur();
				request.setAttribute("fournisseurs", lf);
				this.getServletContext().getRequestDispatcher("/listFournisseur.jsp").forward(request, response);
		}else if(path.equals("/ajoutFournisseur")) {
			String name =request.getParameter("nom");
			String prenom =request.getParameter("prenom");
			String email =request.getParameter("email");
			String tel =request.getParameter("tel");
			Fournisseur f = new Fournisseur();
			f.setNom(name);
			f.setPrenom(prenom);
			f.setEmail(email);
			f.setTel(tel);
			fd.addFournisseur(f);
			this.getServletContext().getRequestDispatcher("/listeFournisseur").forward(request, response);

			
		}
		
		}

}
