/**
 * 
 */
package model;

/**
 * represents authentication to DB
 * @author Moshe Shimon
 *
 */
public interface IAuthenticationHandler {

	/**
	 * login to DB 
	 * @param user - contain user info
	 * @throws AuthenticationHandlerException
	 */
	public void signInExistUser(User user) throws AuthenticationHandlerException;
	
	
	/**
	 * gets user object check if exist in DB
	 * if not exist create new one
	 * the pass will be encrypted in DB with md5 algorithm
	 * @param user
	 * @throws ToDoListsPlatformException 
	 */
	public void signUpNewUser(User user) throws  AuthenticationHandlerException;
	
}
