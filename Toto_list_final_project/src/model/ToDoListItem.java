package model;

/**
 * ToDoListItem class
 * Represents todo list item in database 
 * @author Moshe Shimon
 *
 */
public class ToDoListItem {

	//define vars
	private int id;
	private String title;
	private String description;
	private String status;
	private int userId ;
	/**
	 * Default constructor
	 */
	public ToDoListItem() {}


	/**
	 * ToDoListItem constructor
	 * @param id
	 * @param title
	 * @param description
	 
	 */
	public ToDoListItem(int id, String title, String description, int userId ) {
		super();
		setId(id);
		setTitle(title);
		setDescription(description);
		setStatus(ModelConst.OPEN);
		setUserId(userId); /// need to change 
	}
	
	/**
	 * 
	 * @param title
	 * @param description
	 * @param userId
	 */
	public ToDoListItem( String title, String description, int userId ) {
		super();
		setId(0);
		setTitle(title);
		setDescription(description);
		setStatus(ModelConst.OPEN);
		setUserId(userId); /// need to change 
	}

	////****** need to validate values in the setters **** don't forget!!!


	/**
	 * Item getter
	 * @return the item id
	 */
	public int getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}


	/**
	 * Item title
	 * @return the item title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}


	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}


	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}


	/**
	 * Item description
	 * @return the item description
	 */
	public String getDescription() {
		return description;
	}


	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString(){
		{
			return "Todo [id=" + id + ", title=" + title + ", description="
					+ description + "]";
		}
	}


	/**
	 * @return the userID
	 */
	public int getUserId() {
		return userId;
	}


	/**
	 * @param userID the userID to set
	 */
	public void setUserId(int userID) {
		this.userId = userID;
	}


}
