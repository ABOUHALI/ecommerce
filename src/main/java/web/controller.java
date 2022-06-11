package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClientDAO;
import model.Client;
import model.Users;

/**
 * Servlet implementation class controller
 */
@WebServlet(name="s",urlPatterns = {"/admin","/register"})
public class controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ClientDAO cd=new ClientDAO();   
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
		}
	}

}
