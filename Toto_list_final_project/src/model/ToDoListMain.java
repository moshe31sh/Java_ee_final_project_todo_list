package model;

public class ToDoListMain {

	public static void main(String[] args) {
//		// TODO Auto-generated method stub
		try {
	User user = new User("ohad","sasson",12345,"abc");
			
//	System.out.println(HibernateToDoListDAO.getInstance().addToDoListItem(new ToDoListItem(2,"tatata","bla")));
//		}catch (ToDoListsPlatformException e){
//			e.printStackTrace();
//		}

	//	AuthenticationHandler.passAuthentication("mmm");
//		try{
		AuthenticationHandler.getInstance().signUpNewUser(user);
		
		}catch(ToDoListsPlatformException e){
			e.printStackTrace();
		}
		
	}

}
