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
import model.Famille;

/**
 * Servlet implementation class ControllerFamille
 */
@WebServlet(name="famille",urlPatterns = {"/listeFamille","/ajoutFamille","/modifierFam","/modifierFamille"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)

public class ControllerFamille extends HttpServlet {
	private static final long serialVersionUID = 1L;
    InputStream inputStream=null;
    FamilleDAO fd = new FamilleDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerFamille() {
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
		if(path.equals("/ajoutFamille")) {
			String nom = request.getParameter("nom");
			Part filePart = request.getPart("image");

			if (filePart != null) {

				System.out.println(filePart.getName());
				System.out.println(filePart.getSize());
				System.out.println(filePart.getContentType());

				inputStream = filePart.getInputStream();
			}
			Famille f = new Famille();
			f.setNom(nom);
			f.setImage(inputStream);
			fd.addFamille(f);
			this.getServletContext().getRequestDispatcher("/listeFamille").forward(request, response);

		}else if(path.equals("/listeFamille")) {
			List<Famille> lf = new ArrayList<Famille>();
			lf=fd.listerFamilles();
			request.setAttribute("familles", lf);
			this.getServletContext().getRequestDispatcher("/listFamille.jsp").forward(request, response);

		}else if(path.equals("/modifierFam")) {
			Integer id= Integer.parseInt(request.getParameter("id_fam"));
			
			List<Famille> lf =fd.listerFamilles();
			Famille f =null;
			for (Famille famille : lf) {
				if(famille.getIdfamille()==id) {
					f=famille;
				}
			}
			request.setAttribute("famille", f);
			request.setAttribute("id", id);
			this.getServletContext().getRequestDispatcher("/modifierFam.jsp").forward(request, response);

			
			
		}else if(path.equals("/modifierFamille")) {
			Integer id= Integer.parseInt(request.getParameter("id_fam"));
			Famille f =new Famille();
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
			fd.modifierFamille(f);
			this.getServletContext().getRequestDispatcher("/listeFamille").forward(request, response);
		}
	}

}
