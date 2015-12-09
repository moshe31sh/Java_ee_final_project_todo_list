package controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.apache.log4j.Logger;

import model.AuthenticationDAO;
import model.AuthenticationHandlerException;
import model.HibernateToDoListDAO;
import model.User;

/**
 * Servlet implementation class AutenticationController
 */
@WebServlet("/AutenticationController")
public class AutenticationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Logger logger = Logger.getLogger(AutenticationController.class); 

	private HttpSession session = null;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AutenticationController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("doget");
		User currentUser = null;
		response.getWriter().println("doGet");
		session = request.getSession(true);
	      // Get session creation time.
	   //   Date createTime = new Date(session.getCreationTime());
	       // Get last access time of this web page.
	    //  Date lastAccessTime = new Date(session.getLastAccessedTime());
	      currentUser = (User)session.getAttribute("user");
	      if(currentUser != null){
	    	  logger.info(currentUser.getUserName()+" is login");
	    	  userDBAccess(request,response);
	      }else{
	    	  logout(request, response);  
	      }
	      
		if (this.session.isNew()){
			logout(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("doPost");
		response.getWriter().println("doPost");
		if (userAuthentication(request, response) == true ){
			userDBAccess(request, response);
		}else{
			//***TODO ***
		}
		
	}

	/**
	 * this method verify if user exist in registered on DB 
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	private boolean userAuthentication(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		User user = null;
		this.session = request.getSession();
		String password =(String) request.getParameter("password");
		String id =(String) request.getParameter("id");
		if(password != null && id !=null){
			password = password.trim();
			id = id.trim();
			try {
				user = AuthenticationDAO.getInstance().signInExistUser(Integer.parseInt(id), password);
				this.session.setAttribute("user", user);
				return true;
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (AuthenticationHandlerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			logger.info("user id" + id + " try to login");
		}
		return false;

	}

	/**
	 * this method forward to login page
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void logout(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		response.setContentType("text/html");

		//creating a variable for storing the reference for the request dispatcher
		RequestDispatcher dispatcher = null;
		dispatcher = getServletContext().getRequestDispatcher("/login.jsp");			
		dispatcher.forward(request, response);
	}

	/**
	 * this method forward user to user dashboard
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void userDBAccess(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		response.setContentType("text/html");

		//creating a variable for storing the reference for the request dispatcher
		RequestDispatcher dispatcher = null;
		dispatcher = getServletContext().getRequestDispatcher("/usermenu.jsp");			
		dispatcher.forward(request, response);
	}
}