package model;

import java.util.Collection;

import javafx.print.Collation;

/**
 * ToDoList Data Access Object
 * represents the DAO Interface for ToDoList actions & Management
 * @author Moshe Shimon
 *
 */

public interface IHibernateToDoListDAO {


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

public Boolean deleteToDoListItem(ToDoListItem item) throws ToDoListsPlatformException;


/**
 * Get ToDoList items collection
 * @return
 * @throws ToDoListsPlatformException
 */
public Collection<ToDoListItem> getAllToDoListItem(int userId) throws ToDoListsPlatformException;




/**
 * Update ToDoList item to database
 * @return true if success or false if failed
 * @throws ToDoListsPlatformException
 */

public Boolean updateToDoListItem(ToDoListItem item) throws ToDoListsPlatformException;
}
