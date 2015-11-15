package model;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 * Access to SessionFactory , singleton implementation
 * @author Moshe Shimon
 *
 */

public class SessionFactoryAccess {

	private SessionFactory sessionFactory;

	/**
	 * Singleton SessionFactoryAccess instance static var
	 */
	private static SessionFactoryAccess instance; 

	/**
	 * private constructor
	 */

	private SessionFactoryAccess() {
		//creating factory for getting sessions
		sessionFactory =  new AnnotationConfiguration().configure().buildSessionFactory();

	}	

	//singleton implementation
	public static SessionFactoryAccess getInstance() {
		if (instance == null) {
			instance = new SessionFactoryAccess();
		}
		return instance;
	}

	/**
	 * sessionFactory getter
	 * @return the sessionFactory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
