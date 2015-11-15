/**
 * 
 */
package model;


import org.hibernate.Query;
import org.hibernate.classic.Session;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.sun.istack.internal.logging.Logger;

/**
 * 
 * @author Moshe Shimon
 *
 */
public class HibernateToDoListDAO implements IToDoListDAO  {
	//logger instance
	static Logger logger = Logger.getLogger(HibernateToDoListDAO.class);

	//define vars
	private Session session;


	/**
	 * Singleton instance static var
	 */
	private static HibernateToDoListDAO instance;

	/**
	 * private constructor
	 */

	private HibernateToDoListDAO() {
		
	}




	//singleton implementation
	public static HibernateToDoListDAO getInstance() {
		if (instance == null) {
			instance = new HibernateToDoListDAO();
		}
		return instance;
	}





	/* (non-Javadoc)
	 * @see model.IToDoListDAO#addToDoListItem(model.ToDoListItem)
	 */
	@Override
	public Boolean addToDoListItem(ToDoListItem item) throws ToDoListsPlatformException {
		try{
			logger.info("Add item "+item.getId()+" "+item.getTitle());
			this.session = SessionFactoryAccess.getInstance().getSessionFactory().openSession();
			this.session.beginTransaction();
			this.session.save(item);
			this.session.getTransaction().commit();

		}catch (HibernateException e){
			if (this.session.getTransaction() != null) {
				this.session.getTransaction().rollback();
			}
			logger.info("Add item failed"+item.getId()+" "+item.getTitle());
			throw new ToDoListsPlatformException("Problem add item", e);
		} finally {
			this.session.close();
		}
		return true;
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