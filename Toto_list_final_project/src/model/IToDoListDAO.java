package model;


/**
 * ToDoList Data Access Object
 * represents the DAO Interface for ToDoList actions & Management
 * @author Moshe Shimon
 *
 */

public interface IToDoListDAO {


/**
 * Add ToDoList item to database
 * @param Item
 * @throws ToDoListsPlatformException
 */

public Boolean addToDoListItem(ToDoListItem Item) throws ToDoListsPlatformException;

/**
 * Delete ToDoList item to database
 * @return
 * @throws ToDoListsPlatformException
 */

public Boolean deleteToDoListItem() throws ToDoListsPlatformException;


/**
 * Get ToDoList items collection
 * @return
 * @throws ToDoListsPlatformException
 */
public ToDoListItem [] getAllToDoListItem() throws ToDoListsPlatformException;

}
