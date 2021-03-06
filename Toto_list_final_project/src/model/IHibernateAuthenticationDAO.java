/**
 * 
 */
package model;

import java.util.Collection;

/**
 * represents authentication to DB
 * @author Moshe Shimon
 *
 */
public interface IHibernateAuthenticationDAO {

	/**
	 * login to DB 
	 * @param user - contain user info
	 * @throws AuthenticationHandlerException
	 */
	public User signInExistUser(int userId , String password) throws AuthenticationHandlerException;
	
	
	/**
	 * gets user object check if exist in DB
	 * if not exist create new one
	 * the pass will be encrypted in DB with md5 algorithm
	 * @param user
	 * @throws ToDoListsPlatformException 
	 */
	public void signInNewUser(User user) throws  AuthenticationHandlerException;
	
	
	/**
	 * get all user list from DB
	 * @return user list
	 * @throws AuthenticationHandlerException
	 */
	public Collection<User> getAllUsers() throws AuthenticationHandlerException;

	
}
