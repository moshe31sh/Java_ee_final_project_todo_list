package model;

/**
 * ToDoListItem class
 * Represents todo list item in database 
 * @author Moshe Shimon
 *
 */
public class ToDoListItem {

	// Var declaration
	private int id;
	private String title;
	private String description;

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
	public ToDoListItem(int id, String title, String description) {
		super();
		setId(id);
		setTitle(title);
		setDescription(description);
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


}
