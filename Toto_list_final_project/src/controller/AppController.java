package controller;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import model.HibernateToDoListDAO;
import model.ToDoListItem;
import model.ToDoListsPlatformException;
import model.User;

/**
 * Servlet implementation class AppController
 */
@WebServlet("/AppController/*")
public class AppController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Logger logger = Logger.getLogger(AppController.class); 

	private HttpSession session = null;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AppController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().println("doGet");
		//checking which url address the request was equipped with
		StringBuffer sb = request.getRequestURL();
		String url = sb.toString();
		
		
		
//		try{
//		this.session = request.getSession();
//		User currenUser = (User)this.session.getAttribute("user");
//		if(this.session != null){
//			doAction(request,response,ControllerConst.USER_MENU);
//		}else if(url.endsWith(ControllerConst.USER_TASKS)){
//			try {
//				//get all todo list item from DB
//				Collection<ToDoListItem> items = HibernateToDoListDAO.getInstance().getAllToDoListItem(currenUser.getUserId());
//				this.session.setAttribute("items",items);
//				
//			} catch (ToDoListsPlatformException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//			doAction(request,response,ControllerConst.USER_TASKS);
//		}
//		}catch (Exception e){
//			doAction(request,response,ControllerConst.ERROR);
//			e.printStackTrace();
//			
//		}
//		
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		logger.info("AppController doPost");
		response.setContentType("text/html");
		//checking which url address the request was equipped with
		StringBuffer sb = request.getRequestURL();
		String url = sb.toString();
		try{
		this.session = request.getSession();
		User currenUser = (User)this.session.getAttribute("user");
		if(this.session != null){
			doAction(request,response,ControllerConst.USER_MENU);
		}else if(url.endsWith(ControllerConst.USER_TASKS)){
			try {
				//get all todo list item from DB
				Collection<ToDoListItem> items = HibernateToDoListDAO.getInstance().getAllToDoListItem(currenUser.getUserId());
				this.session.setAttribute("items",items);
				
			} catch (ToDoListsPlatformException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			doAction(request,response,ControllerConst.USER_TASKS);
		}
		}catch (Exception e){
			doAction(request,response,ControllerConst.ERROR);
			e.printStackTrace();
			
		}
	}
/**
 * get action from usermenu.jsp and active request action
 * @param request
 * @param response
 * @param action
 * @throws ServletException
 * @throws IOException
 */
	private void doAction(HttpServletRequest request, HttpServletResponse response , String action) throws ServletException, IOException {
		RequestDispatcher dispatcher = null;
		dispatcher = getServletContext().getRequestDispatcher("/"+action+".jsp");	
		dispatcher.forward(request, response);


	}

}
