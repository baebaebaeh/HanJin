package contest01;

public interface IUserManager {
	
	void add(User user);
	User getUser(String id);
	void modify(String id, String email);
	void delete(String id);
	User[] getUsers();
}
