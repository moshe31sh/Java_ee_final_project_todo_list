package model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.swing.text.StyledEditorKit.BoldAction;

import org.hibernate.HibernateException;
import org.hibernate.classic.Session;

import com.mysql.jdbc.log.Log;
import com.sun.istack.internal.logging.Logger;

import javafx.print.Collation;

/**
 * Represents the MD5 Logic Controller
 * using for getting DB pass
 * Hashing password
 * Equation between passwords
 * @author Moshe Shimon
 *
 */
public class HibernateAuthenticationDAO implements IHibernateAuthenticationDAO{

	//define vars
	private static HibernateAuthenticationDAO instance;

	private Session session;

	static Logger logger = Logger.getLogger(HibernateAuthenticationDAO.class);


	private HibernateAuthenticationDAO(){}

	//singleton implementation
	public static HibernateAuthenticationDAO getInstance() {
		if (instance == null) {
			instance = new HibernateAuthenticationDAO();
		}
		return instance;
	}

	/**
	 * gets user object and verify if exist in DB
	 * @param user
	 * @throws AuthenticationHandlerException 
	 */
	public User signInExistUser(int userId , String password) throws AuthenticationHandlerException{
		//user holder var
		User authenticatUser = null;
		logger.info("Sign in request" + userId);

		/// set encrypted password to user
		password = (AuthenticationHandlerUtilitiesScala.passEncryption(password));
		//check if user exist , if yes returns user instance
		if ((authenticatUser = checkIfUserExist(userId)) != null){

			///***** need to implement some logic here ******
			logger.info(authenticatUser.getUserName());

			if(authenticatUser.getPassword().equals(password)){
				logger.info("user exist in DB");
				return authenticatUser;
			}
			else{
				return null;
			}
			//System.out.println(AuthenticationHandlerUtilitiesScala.comperUsers(user, authenticatUser));


		}else {
			//		System.out.println("No such user"+user.getUserName());
			logger.info("error authentication user");
		}
		return null;
	}







	/**
	 * gets user object verify if exist in DB
	 * if not exist create new one
	 * the pass will be encrypted in DB with md5 algorithm
	 * @param user
	 * @throws ToDoListsPlatformException 
	 */
	public void signInNewUser(User user) throws  AuthenticationHandlerException{
		logger.info("Sign up request");
		//check if user is in DB
		if (checkIfUserExist(user.getUserId()) == null){
			try{
				this.session = SessionFactoryAccess.getInstance().getSessionFactory().openSession();
				/// set encrypted password to user
				user.setPassword(AuthenticationHandlerUtilitiesScala.passEncryption(user.getPassword()));
				this.session.beginTransaction();
				this.session.save(user);
				this.session.getTransaction().commit();
				System.out.println("user successfuly sign up");

			}catch(HibernateException e){
				//roll back in case of problem
				if (this.session.getTransaction() != null) {
					this.session.getTransaction().rollback();
				}
				throw new  AuthenticationHandlerException("Problem add new user", e);


			} finally {
				try {
					this.session.close();
					}catch (HibernateException e){
						e.printStackTrace();
					}
			}
		}else {
			System.out.println("user is already in DB");
			logger.info("error - try to craete exist user");
		}

	}



/**
 * this method check if user exist in DB
 * @param userId
 * @return - user from DB
 * @throws AuthenticationHandlerException
 */
	private User checkIfUserExist(int userId) throws AuthenticationHandlerException{
		try{
			this.session = SessionFactoryAccess.getInstance().getSessionFactory().openSession();
			User user = (User) this.session.get(User.class , userId);	
			if (user != null){
				return user;
			}
		}catch (HibernateException e){		//roll back in case of problem

			throw new AuthenticationHandlerException("check if user exist failed", e);

		} finally {
			try {
				this.session.close();
				}catch (HibernateException e){
					e.printStackTrace();
				}
		}
		return null;
	}

	
	
	/**
	 * get all user list from DB
	 * @return user list
	 * @throws AuthenticationHandlerException
	 */
	
@Override
public Collection<User> getAllUsers() throws AuthenticationHandlerException {
	ArrayList<User> arrayList = new ArrayList<User>();

try{
	logger.info("Get items");
	this.session = SessionFactoryAccess.getInstance().getSessionFactory().openSession();
	List<User> userList = session.createQuery("FROM User").list();
	Iterator i = userList.iterator();
	while(i.hasNext()) 
	{
		User user = (User) i.next();
		arrayList.add(user);
	}
		
}catch (HibernateException e){
				
	throw new AuthenticationHandlerException("Problem get all items", e);
} finally {
	try {
		this.session.close();
		}catch (HibernateException e){
			e.printStackTrace();
		}
}
return arrayList;
}

	
	
}
