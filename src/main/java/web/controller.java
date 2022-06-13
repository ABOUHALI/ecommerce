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

import dao.ClientDAO;
import dao.FamilleDAO;
import dao.PanierDAO;
import dao.ProduitDAO;
import model.Client;
import model.Famille;
import model.Panier;
import model.Produit;
import model.Users;

/**
 * Servlet implementation class controller
 */
@WebServlet(name="s",urlPatterns = {"/homeClient","/register","/prodByFam","/ajoutPanier","/listePanier"})
public class controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ClientDAO cd=new ClientDAO();   
    FamilleDAO fd = new FamilleDAO();
    ProduitDAO pd = new ProduitDAO();
    PanierDAO panierd = new PanierDAO();
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
		HttpSession session = request.getSession();
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

		}else if(path.equals("/ajoutPanier")) {
			String idclient =request.getParameter("id_client");
			int idc =Integer.parseInt(idclient);
			String idprod =request.getParameter("idprod");
			int idp = Integer.parseInt(idprod);
			/////////////////////
			List<Produit> lp = pd.listerProduit();
			Produit p =null;
			for (Produit produit : lp) {
				if(produit.getId_produit()==idp) {
					p=produit;
				}
			}
			Panier panier = new Panier();
			panier.setIdclient(idc);
			panier.setIdproduit(idp);
			panier.setPrixT(p.getPrix());
			panier.setQtte(p.getQtte());
			///////////////////
			panierd.addPanier(panier);
			//////////////
			List <Panier> paniers= panierd.ListPanier();
			List<Panier> panierClient = new ArrayList<Panier>();
			for (Panier pp : paniers) {
				if(pp.getIdclient()==idc) {
					panierClient.add(pp);
				}
			}
			request.setAttribute("paniers", panierClient);
			this.getServletContext().getRequestDispatcher("/listePanier").forward(request, response);

		}else if(path.equals("/listePanier")) {
			
			String idcc=String.valueOf(session.getAttribute("idclient"));
			System.out.println(idcc);
			int idc =Integer.parseInt(idcc);
			System.out.println(idc);
			List <Panier> paniers= panierd.ListPanier();
			List<Panier> panierClient = new ArrayList<Panier>();
			for (Panier pp : paniers) {
				if(pp.getIdclient()==idc) {
					panierClient.add(pp);
				}
			}
			request.setAttribute("paniers", panierClient);
			this.getServletContext().getRequestDispatcher("/ReservationsClient.jsp").forward(request, response);

		}
	}

}
