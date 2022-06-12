package web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClientDAO;
import dao.FamilleDAO;
import model.Client;
import model.Famille;
import model.Produit;
import model.Users;

/**
 * Servlet implementation class controller
 */
@WebServlet(name="s",urlPatterns = {"/homeClient","/register","/prodByFam"})
public class controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ClientDAO cd=new ClientDAO();   
    FamilleDAO fd = new FamilleDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public controller() {
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
		
		String path= request.getServletPath();
		System.out.println("in cont "+ path);
		if (path.equals("/register")) {
			System.out.println("in reg");
			Client cl=new Client();
			Users us=new Users();
			us.setLogin(request.getParameter("username"));;
			us.setMdp(request.getParameter("password"));  
			cd.addUser(us);
			cl.setNom(request.getParameter("nom")); 
			cl.setPrenom(request.getParameter("prenom")); 
			cl.setTelephone(request.getParameter("telphone")); 
			cl.setEmail(request.getParameter("email"));
			cd.addClient(cl,cd.getIdUser(us));
			this.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
		}else if(path.equals("/homeClient")) {
				List<Famille> lf =new ArrayList<Famille>();
				lf=fd.listerFamilles();
				request.setAttribute("familles", lf);
			this.getServletContext().getRequestDispatcher("/homeClient.jsp").forward(request, response);

		}else if(path.equals("/prodByFam")) {
			String idf =request.getParameter("id_fam");
			Integer id = Integer.parseInt(idf);
			List<Produit> lp = fd.getProduitFromFamille(id);
			System.out.println(lp);
			request.setAttribute("produits", lp);
			this.getServletContext().getRequestDispatcher("/homeProduit.jsp").forward(request, response);

		}
	}

}
