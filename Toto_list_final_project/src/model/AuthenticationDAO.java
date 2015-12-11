package model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;

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
public class AuthenticationDAO implements IAuthenticationDAO{

	//define vars
	private static AuthenticationDAO instance;

	private Session session;

	static Logger logger = Logger.getLogger(AuthenticationDAO.class);


	private AuthenticationDAO(){}

	//singleton implementation
	public static AuthenticationDAO getInstance() {
		if (instance == null) {
			instance = new AuthenticationDAO();
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
		return authenticatUser;
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
				this.session.close();
			}
		}else {
			System.out.println("user is already in DB");
			logger.info("error - try to craete exist user");
		}

	}




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
			this.session.close();
		}
		return null;
	}

}
