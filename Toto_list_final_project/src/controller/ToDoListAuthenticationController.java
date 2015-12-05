package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.log.Log;
import com.sun.istack.internal.logging.Logger;

import model.AuthenticationDAO;
import model.AuthenticationHandlerException;
import model.User;
/**
 * Servlet implementation class ToDoListMainController
 */
@WebServlet("/ToDoListMainController")
public class ToDoListAuthenticationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//static Logger logger = Logger.getLogger(ToDoListAuthenticationController.class);

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToDoListAuthenticationController() {
        super();
      
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//checking which url address the request was equipped with
		
		StringBuffer sb = request.getRequestURL();
		PrintWriter out = response.getWriter();
		out.println("<h1>LOGIN</h1>");
	//	try{
	//	User u = AuthenticationDAO.getInstance().signInExistUser(1245, "abcd");
	//	out.println(u.getUserName())
		//}
//		catch (AuthenticationHandlerException e){
			
	//	}
		String url = sb.toString();
		if (authenticate(request) == true){
			out.println("<h1>LOGIN</h1>");

		}
		//creating a variable for storing the reference for the request dispatcher
		RequestDispatcher dispatcher = null;
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	/**
	 * this method check if user 
	 * exist in DB 
	 * @return true or false
	 */
	
	private boolean authenticate(HttpServletRequest request){
		
		String userId = request.getParameter("id");
		String userPassword = request.getParameter("password");
		
		if(userId !=null && userPassword != null){
			User currentUser = null;
			userId = userId.trim();
			userPassword = userPassword.trim();
			
			int userIdParsingToInt = Integer.parseInt(userId);
	//		logger.info(userId +" "+userPassword);
			try{
			currentUser = AuthenticationDAO.getInstance().signInExistUser(userIdParsingToInt, userPassword);
			
	//		logger.info(currentUser.getUserName() + "is login");
			if (currentUser!=null){
				return true;
			}
			}catch (AuthenticationHandlerException e){
				e.printStackTrace();
			}
			
		}
		
		return false;
	}

}