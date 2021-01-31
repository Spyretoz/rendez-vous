package rendez.vous.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import rendez.vous.dao.UserDAO;
import rendez.vous.entity.User;

@Repository
public class UserDAOImpl implements UserDAO 
{
	
	@Autowired
    private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<User> getUsers() 
	{
		// get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        
        // create a query
        Query<User> query = currentSession.createQuery("from User", User.class);
        
        
        // execute the query and get the results list
        List<User> users = query.getResultList();
                        
        //return the results
        return users;
	}
	
	@Override
	@Transactional
	public void saveUser(User theUser)
	{		
		// get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        
        // if user already exists update
		if (theUser.getId() != 0) 
		{
			currentSession.update(theUser);
		} 
		
		// else add user to database
		else 
		{
			currentSession.save(theUser);
		}
	}
	
	
	
	@Override
	@Transactional
	public User getUser(int id) 
	{
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// get and return User
		User user = currentSession.get(User.class, id);
		
		return user;
	}
	
	@Override
	@Transactional
	public void deleteUser(int id) 
	{
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// find the User
		User User = currentSession.get(User.class, id);

		// delete User
		currentSession.delete(User);

	}
	
	@Override
	@Transactional
	public User findUserByUsername(String username) 
	{
		return sessionFactory.getCurrentSession().get(User.class, username);
	}

	@Override
	@Transactional
	public User save(User user) 
	{
		sessionFactory.getCurrentSession().save(user);
		return sessionFactory.getCurrentSession().get(User.class, user.getUsername());
	}
}