package rendez.vous.dao;

import java.util.List;

import rendez.vous.entity.User;

public interface UserDAO 
{
	public List<User> getUsers();

	public void saveUser(User theUser);
	
	public User getUser(int id);
	public void deleteUser(int id);
	
	public User findUserByUsername(String username);
	
	public User save(User user);
}