package model;

/**
 * Deals with todo list exception.
 * Inheritance for Exception java class.
 * @author Moshe Shimon
 *
 */
public class ToDoListsPlatformException extends Exception{


	/**
	 * constructor
	 * @param msg
	 */
	public ToDoListsPlatformException(String msg) {
		super(msg);
	}
	/**
	 * ToDoListsPlatformException 
	 * @param msg
	 * @param throwable
	 */
	public ToDoListsPlatformException(String msg, Throwable throwable) {
		super(msg,throwable);
	}

}
