package contest01;

import java.util.Arrays;

public class UserManagerImpl implements IUserManager {
	
	private final static int MAX_SIZE = 100;
	private User[] userList = new User[MAX_SIZE];
	private int size = 0;
	private UserManagerImpl() {}
	private static IUserManager instance = new UserManagerImpl();
	public static IUserManager getInstance () {
		return instance;
	}
	
	@Override
	public void add(User user) {
		if (size < MAX_SIZE)
		userList[size++] = user;
	}

	@Override
	public User getUser(String id) {
		for (int i = 0; i < size; i++) {
			if (userList[i].getId().equals(id)) {
				return userList[i];
			}
		}
		return null;
	}

	@Override
	public void modify(String id, String email) {
		for (int i = 0; i < size; i++) {
			if (userList[i].getId().equals(id)) {
				userList[i].setEmail(email);
			}
		}
	}

	@Override
	public void delete(String id) {
		for (int i = 0; i < size; i++) {
			if (userList[i].getId().equals(id)) {
				int n = size - i -1;
				System.arraycopy(userList, i + 1, userList, i, n);
				userList[--size] = null;
			}
		}
	}

	@Override
	public User[] getUsers() {
		return Arrays.copyOf(userList, size);
	}
	
}
