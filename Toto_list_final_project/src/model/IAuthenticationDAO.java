/**
 * 
 */
package model;

/**
 * represents authentication to DB
 * @author Moshe Shimon
 *
 */
public interface IAuthenticationDAO {

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
	public void signUpNewUser(User user) throws  AuthenticationHandlerException;
	
}
