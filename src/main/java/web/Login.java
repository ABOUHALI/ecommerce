package web;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import dao.LoginDAO;
import model.Users;

/**
 * Servlet implementation class LoginSER
 */
@WebServlet(name="cs",urlPatterns={"/login"})
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LoginDAO ld = new LoginDAO();
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("GET");
		this.getServletContext().getRequestDispatcher("login.jsp").forward(request, response);


	}

	/*
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 * response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("POST");
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Users user = new Users();
		user.setLogin(username);
		user.setMdp(password);
		if (ld.validation(user)) {
			String role = ld.Role(user);
			if(role.equals("admin")) {
				System.out.println(4);
				session.setAttribute("admin", user);
				System.out.println(session.getAttribute("admin"));
				this.getServletContext().getRequestDispatcher("/homeAdmin.jsp").forward(request, response);

			}else if (role.equals("client")){
				session.setAttribute("client", user);
				System.out.println(session.getAttribute("client"));
				this.getServletContext().getRequestDispatcher("/homeClient.jsp").forward(request, response);
			}
			}
		else {
			this.getServletContext().getRequestDispatcher("/errorLOGIN.jsp").forward(request, response);
		}
	}
	}

