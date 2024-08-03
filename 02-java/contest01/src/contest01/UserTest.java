package contest01;

public class UserTest {
	public static void main(String[] args) {
		
		IUserManager iUserManager = UserManagerImpl.getInstance();
		User user1 = new User("1", "1234", "김길동", "don21@gmail.com", 12);
		User user2 = new User("2", "1234", "홍길동", "don0421", 20);
		User user3 = new User("3", "1234", "홍길동", "don0421", 20);

		
		iUserManager.add(user1);
		iUserManager.add(user2);
		iUserManager.add(user3);
		User user4 = iUserManager.getUser("1");
		System.out.println(user4);
		// users = 유저들 3개가 들어간 users[] 0x100
		
		User[] users = iUserManager.getUsers();
		for (User user : users) {
			System.out.println(user);
		}
		
		
		
		System.out.println("*****************");
		iUserManager.delete("3");
		users = iUserManager.getUsers();
		for (User user : users) {
			System.out.println(user);
		}
		System.out.println("*****************");
		iUserManager.modify("2", "bae9954@naver.com");
		users = iUserManager.getUsers();
		for (User user : users) {
			System.out.println(user);
		}
		
	}
}
