/**
 * 
 */
package model;

import com.sun.istack.internal.logging.Logger;

/**
 * 
 * @author Moshe Shimon
 *
 */
public class ToDoListDAO implements IToDoListDAO  {
	static Logger logger = Logger.getLogger(ToDoListDAO.class);
	
	/**
	 * Singleton instance static var
	 */
	 private static ToDoListDAO instance;
	 
	 /**
	  * private constructor
	  */
	 
	 private ToDoListDAO() {
		// TODO Auto-generated constructor stub
	}
	
	 
	   //singleton implementation
	    public static ToDoListDAO getInstance() {
	        if (instance == null) {
	            instance = new ToDoListDAO();
	        }
	        return instance;
	    }
	 
	 
	 
	 
	 
	/* (non-Javadoc)
	 * @see model.IToDoListDAO#addToDoListItem(model.ToDoListItem)
	 */
	@Override
	public Boolean addToDoListItem(ToDoListItem item) throws ToDoListsPlatformException {
		// TODO Auto-generated method stub
		logger.info("Add item "+item.getId()+" "+item.getTitle());
		return null;
	}

	/* (non-Javadoc)
	 * @see model.IToDoListDAO#deleteToDoListItem()
	 */
	@Override
	public Boolean deleteToDoListItem() throws ToDoListsPlatformException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see model.IToDoListDAO#getAllToDoListItem()
	 */
	@Override
	public ToDoListItem[] getAllToDoListItem() throws ToDoListsPlatformException {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
