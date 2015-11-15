package model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.swing.text.StyledEditorKit.BoldAction;

import org.hibernate.HibernateException;
import org.hibernate.classic.Session;

import com.sun.istack.internal.logging.Logger;

/**
 * Represents the MD5 Logic Controller
 * using for getting DB pass
 * Hashing password
 * Equation between passwords
 * @author Moshe Shimon
 *
 */
public class AuthenticationHandler {

	//define vars
	private static AuthenticationHandler instance;

	private Session session;

	static Logger logger = Logger.getLogger(AuthenticationHandler.class);


	private AuthenticationHandler(){}

	//singleton implementation
	public static AuthenticationHandler getInstance() {
		if (instance == null) {
			instance = new AuthenticationHandler();
		}
		return instance;
	}

	/**
	 * gets user object and verify its data 
	 * with DB 
	 * @param user
	 */
	public void LogInExistUser(User user){
		this.session = SessionFactoryAccess.getInstance().getSessionFactory().openSession();


	}

	/**
	 * gets user object check if exist in DB
	 * if not exist create new one
	 * the pass will be encrypted in DB with md5 algorithm
	 * @param user
	 * @throws ToDoListsPlatformException 
	 */
	public void signUpNewUser(User user) throws ToDoListsPlatformException{



		logger.info("Open session");
		//check if user is in DB
		if (checkIfUserExist(user.getUserId()) == false){
			try{
				this.session = SessionFactoryAccess.getInstance().getSessionFactory().openSession();
				/// set encrypted password to user
				user.setPassword(passEncryption(user.getPassword()));
				this.session.beginTransaction();
				this.session.save(user);
				this.session.getTransaction().commit();
				System.out.println("user successfuly sign up");

			}catch(HibernateException e){
				//roll back in case of problem
				if (this.session.getTransaction() != null) {
					this.session.getTransaction().rollback();
				}
				throw new ToDoListsPlatformException("Problem add new user", e);


			} finally {
				this.session.close();
			}
		}else {
			System.out.println("user is already in DB");
			logger.info("error - try to craete exist user");
		}

	}



	/**
	 * receive user password and encrypt it
	 * returns md5 string 
	 * @param pass
	 * @return
	 */
	private String passEncryption(String pass) {
		String generatedPassword = null;
		try {
			logger.info("convert password");
			// Create MessageDigest instance for MD5
			MessageDigest md = MessageDigest.getInstance("MD5");
			//Add password bytes to digest
			md.update(pass.getBytes());
			//Get the hash's bytes
			byte[] bytes = md.digest();
			//This bytes[] has bytes in decimal format;
			//Convert it to hexadecimal format
			StringBuilder sb = new StringBuilder();
			for(int i=0; i< bytes.length ;i++)
			{
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			//Get complete hashed password in hex format
			generatedPassword = sb.toString();
		}
		catch (NoSuchAlgorithmException e)
		{
			e.printStackTrace();
			logger.info("password hashed faild");
			return null;
		}

		logger.info("password successfuly hashed ");
		return generatedPassword;
	}


	private boolean checkIfUserExist(int userId) throws ToDoListsPlatformException{
		try{
			this.session = SessionFactoryAccess.getInstance().getSessionFactory().openSession();
			User user = (User) this.session.get(User.class , userId);	
			if (user != null){
				return true;
			}
		}catch (HibernateException e){		//roll back in case of problem

			throw new ToDoListsPlatformException("check if user exist failed", e);

		} finally {
			this.session.close();
		}
		return false;
	}

}
