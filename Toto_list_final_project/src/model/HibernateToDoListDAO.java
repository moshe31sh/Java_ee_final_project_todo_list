/**
 * 
 */
package model;


import org.hibernate.Query;
import org.hibernate.classic.Session;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Iterator;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.sun.istack.internal.logging.Logger;

/**
 * IHibernateToDoListDAO implementation
 * @author Moshe Shimon
 *
 */
public class HibernateToDoListDAO implements IHibernateToDoListDAO  {
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
			try {
			this.session.close();
			}catch (HibernateException e){
				e.printStackTrace();
			}
			
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see model.IToDoListDAO#deleteToDoListItem()
	 */
	@Override
	public Boolean deleteToDoListItem(ToDoListItem item) throws ToDoListsPlatformException {
		try{
			logger.info("Delete item "+item.getId()+" "+item.getTitle());
			this.session = SessionFactoryAccess.getInstance().getSessionFactory().openSession();
			this.session.beginTransaction();
			this.session.delete(item);
			this.session.getTransaction().commit();

		}catch (HibernateException e){
			if (this.session.getTransaction() != null) {
				this.session.getTransaction().rollback();
			}
			logger.info("Add item failed"+item.getId()+" "+item.getTitle());
			throw new ToDoListsPlatformException("Problem add item", e);
		} finally {
			try {
				this.session.close();
				}catch (HibernateException e){
					e.printStackTrace();
				}
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see model.IToDoListDAO#getAllToDoListItem()
	 */
	@Override
	public Collection<ToDoListItem> getAllToDoListItem(int userId) throws ToDoListsPlatformException {
				
		ArrayList<ToDoListItem> arrayList = new ArrayList<ToDoListItem>();
		
		try{
			logger.info("Get items");
			this.session = SessionFactoryAccess.getInstance().getSessionFactory().openSession();
			List<ToDoListItem> itemLiset = session.createQuery("FROM ToDoListItem WHERE userId="+userId).list();
			Iterator i = itemLiset.iterator();
			while(i.hasNext()) 
			{
				ToDoListItem item = (ToDoListItem) i.next();
				arrayList.add(item);
			}
				
		}catch (HibernateException e){
						
			throw new ToDoListsPlatformException("Problem get all items", e);
		} finally {
			try {
				this.session.close();
				}catch (HibernateException e){
					e.printStackTrace();
				}
		}
		return arrayList;
	}




	/* (non-Javadoc)
	 * @see model.IToDoListDAO#updateToDoListItem()
	 */
	@Override
	public Boolean updateToDoListItem(ToDoListItem item) throws ToDoListsPlatformException {
		try{
			logger.info("update item "+item.getId()+" "+item.getTitle());
			this.session = SessionFactoryAccess.getInstance().getSessionFactory().openSession();
			this.session.beginTransaction();
			this.session.update(item);
			this.session.getTransaction().commit();

		}catch (HibernateException e){
			if (this.session.getTransaction() != null) {
				this.session.getTransaction().rollback();
			}
			logger.info("update item failed"+item.getId()+" "+item.getTitle());
			throw new ToDoListsPlatformException("Problem update item", e);
		} finally {
			try {
				this.session.close();
				}catch (HibernateException e){
					e.printStackTrace();
				}
		}
		return true;
	}



}
