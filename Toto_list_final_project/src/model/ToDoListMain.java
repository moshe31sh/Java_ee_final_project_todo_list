package model;

public class ToDoListMain {

	public static void main(String[] args) {
		//		// TODO Auto-generated method stub
		try {
			User user = new User("moshe","shimon",1245,"abcd");
			//
			//		//	System.out.println(HibernateToDoListDAO.getInstance().addToDoListItem(new ToDoListItem()));
			//			//		}catch (ToDoListsPlatformException e){
			//			//			e.printStackTrace();
			//			//		}
			//
			//			//	AuthenticationHandler.passAuthentication("mmm");
			//			//		try{
		//	AuthenticationHandler.getInstance().signUpNewUser(user);
					AuthenticationHandler.getInstance().signInExistUser(user);
			//
		}catch(AuthenticationHandlerException e){
			e.printStackTrace();

			//		}catch (ToDoListsPlatformException e){
			//			e.printStackTrace();
			//		}


			//	System.out.println(AuthenticationHandlerUtilitiesScala.passEncryption("mose"));
		}
	}
}
