package model;

import com.sun.media.jfxmedia.logging.Logger;

public class ToDoListMain {

	public static void main(String[] args) {
		//		// TODO Auto-generated method stub
	//	try {
			//User user = new User("moshe","shimon",1245,"abcd");
		//	ToDoListItem item = new ToDoListItem(1,"test","test",1245);
	//		item.setDescription("check if update a");
		
			//	System.out.println(HibernateToDoListDAO.getInstance().addToDoListItem(new ToDoListItem(1,"TEST","TEST")));
		//	System.out.println(HibernateToDoListDAO.getInstance().updateToDoListItem(new ToDoListItem(2,"moshe","moshe")));
		//	System.out.println(HibernateToDoListDAO.getInstance().addToDoListItem(item));
		//	HibernateToDoListDAO.getInstance().getAllToDoListItem(1245);
	//	}catch (ToDoListsPlatformException e){
		//		e.printStackTrace();
			//	}
			//
			//			//	AuthenticationHandler.passAuthentication("mmm");
//					try{
//						User me =	HibernateAuthenticationDAO.getInstance().signInExistUser(1245, "abcd");
//						System.out.println(me.getUserLastName());
//				
//		//	AuthenticationHandler.getInstance().signUpNewUser(user);
//		//			AuthenticationHandler.getInstance().signInExistUser(user);
//			//
//		}catch(AuthenticationHandlerException e){
//			e.printStackTrace();

			//		}catch (ToDoListsPlatformException e){
			//			e.printStackTrace();
				
			try {
				HibernateAuthenticationDAO.getInstance().getAllUsers();
			} catch (AuthenticationHandlerException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			//	System.out.println(AuthenticationHandlerUtilitiesScala.passEncryption("mose"));
	//	}
//	}
	}
}
