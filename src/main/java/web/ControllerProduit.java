package web;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.itextpdf.text.log.SysoCounter;

import dao.FamilleDAO;
import dao.FournissuerDAO;
import dao.ProduitDAO;
import model.Famille;
import model.Fournisseur;
import model.Produit;

/**
 * Servlet implementation class ControllerFamille
 */
@WebServlet(name="Produit",urlPatterns = {"/listeProduit","/ajoutProduit","/ajoutProduitListe","/modifierProd","/modifierProduit"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)

public class ControllerProduit extends HttpServlet {
	private static final long serialVersionUID = 1L;
    InputStream inputStream=null;
    ProduitDAO pd = new ProduitDAO();
    FournissuerDAO fd = new FournissuerDAO();
    FamilleDAO fad = new FamilleDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerProduit() {
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
		String path = request.getServletPath();
		if(path.equals("/ajoutProduit")) {
			String nom = request.getParameter("nom");
			String nomFour=request.getParameter("nomFour");
			int prix=Integer.parseInt(request.getParameter("prix")) ;
			int qte=Integer.parseInt(request.getParameter("qte")) ;
			String famille=request.getParameter("famille");
			String description=request.getParameter("description");
			Part filePart = request.getPart("image");

			if (filePart != null) {

				System.out.println(filePart.getName());
				System.out.println(filePart.getSize());
				System.out.println(filePart.getContentType());

				inputStream = filePart.getInputStream();
			}
			Produit f = new Produit();
			f.setNom(nom);
			f.setDescription(description);
			f.setPrix(prix);
			f.setQtte(qte);
			f.setImage(inputStream);
			System.out.println(pd.getIdFammile(famille));
			System.out.println(pd.getIdFour(nomFour));
			f.setIdfamille(pd.getIdFammile(famille));
			f.setIdfournisseur(pd.getIdFour(nomFour));
			pd.addProduit(f);
			this.getServletContext().getRequestDispatcher("/listeProduit").forward(request, response);

		}else if(path.equals("/listeProduit")) {
			List<Produit> lp = new ArrayList<Produit>();
			lp=pd.listerProduit();
			System.out.println(lp);
			request.setAttribute("prod", lp);
			this.getServletContext().getRequestDispatcher("/listeProduits.jsp").forward(request, response);

		}else if(path.equals("/ajoutProduitListe")) {
			List<Fournisseur> lf = new ArrayList<Fournisseur>();
			lf=fd.ListFournisseur();
			request.setAttribute("fournisseur", lf);
			List<Famille> lfa = new ArrayList<Famille>();
			lfa=fad.listerFamilles();
			request.setAttribute("familles", lfa);
			this.getServletContext().getRequestDispatcher("/ajoutProduit.jsp").forward(request, response);

		}
		else if(path.equals("/modifierProd")) {
			Integer id= Integer.parseInt(request.getParameter("id_fam"));
			
			List<Produit> lf =pd.listerProduit();
			Produit f =null;
			for (Produit famille : lf) {
				if(famille.getIdfamille()==id) {
					f=famille;
				}
			}
			request.setAttribute("famille", f);
			request.setAttribute("id", id);
			this.getServletContext().getRequestDispatcher("/modifierFam.jsp").forward(request, response);

			
			
		}else if(path.equals("/modifierProduit")) {
			Integer id= Integer.parseInt(request.getParameter("id_fam"));
			Produit f =new Produit();
			f.setIdfamille(id);
			f.setNom(request.getParameter("nom"));
			Part filePart = request.getPart("photo");
			f.setImage(null);
			if (filePart.getSize()!=0) {

				System.out.println(filePart.getName());
				System.out.println(filePart.getSize());
				System.out.println(filePart.getContentType());
				inputStream = filePart.getInputStream();
				
				f.setImage(inputStream);
				
			}
			pd.modifierProduit(f);
			this.getServletContext().getRequestDispatcher("/listeFamille").forward(request, response);
		}
	}

}
