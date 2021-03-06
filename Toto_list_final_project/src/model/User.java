package model;


/**
 * User class
 * Represents user in database 
 * @author Moshe Shimon
 *
 */
public class User {

	//define vars
	
	private String userName;
	private String userLastName;
	private int userId;
	private String Password;
	
	
	
	/**
	 * default constructor
	 */
	
	public User(){}
	
	/**
	 * @param userName
	 * @param userLastName
	 * @param id
	 */
	public User(String userName, String userLastName, int id ,String password) {
		super();
		setUserName(userName);
		setUserLastName(userLastName);
		setUserId(id);
		setPassword(password);
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the userLastName
	 */
	public String getUserLastName() {
		return userLastName;
	}

	/**
	 * @param userLastName the userLastName to set
	 */
	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	/**
	 * @return the id
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param id the id to set
	 */
	public void setUserId(int id) {
		this.userId = id;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return Password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		Password = password;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [userName=" + userName + ", userLastName=" + userLastName + ", userId=" + userId + "]";
	}
	
	
		
}
