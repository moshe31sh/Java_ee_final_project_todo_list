package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import model.HibernateAuthenticationDAO;
import model.AuthenticationHandlerException;
import model.User;

/**
 * Servlet implementation class SigninController
 */
@WebServlet("/SigninController/*")
public class SigninController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//instantiate logger     
	public static Logger logger = Logger.getLogger(SigninController.class); 
	//http session var
	private HttpSession session;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SigninController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = null;
		//for new user sign in
		this.session = request.getSession(true);
		//checking which url address the request was equipped with
		StringBuffer sb = request.getRequestURL();
//		String url = sb.toString();
//		if (url.endsWith("signin")){
//		dispatcher = getServletContext().getRequestDispatcher("/signin.jsp");	
//		
//		}else {
			dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
//		}
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		signUpNewUser(request,response); // get signin request and handler with siginin 
		directToLogInPage(request, response); // after finish signin go to login page
	
	}
	
	/**
	 * this method get user details data and create new user in DB 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void signUpNewUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get user parameters from new user page
		String fName =(String) request.getParameter("fname");
		String lName =(String) request.getParameter("lname");
		String id =(String) request.getParameter("id");
		String password =(String) request.getParameter("password");
		response.getWriter().println(fName +" " + lName +" "+id + " "+password);

		if(fName != null && lName != null && id != null && password != null ){
			fName = fName.trim();
			lName = lName.trim();
			id = id.trim();
			password = password.trim();
		//	response.getWriter().println(fName);
			try{
				int intId = Integer.parseInt(id);
				try {
					HibernateAuthenticationDAO.getInstance().signInNewUser(new User(fName,lName,intId , password));
				} catch (AuthenticationHandlerException e) {
					// TODO Auto-generated catch block
					
				}

			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				
			} 
		}
	}
	
	/**
	 * after finish to signin direct to login page 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void directToLogInPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = null;
		dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
		dispatcher.forward(request, response);
	}
}
