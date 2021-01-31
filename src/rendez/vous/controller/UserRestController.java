package rendez.vous.controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import rendez.vous.entity.User;
import rendez.vous.dao.UserDAO;

@Secured("ROLE_ADMIN")
@RestController
@RequestMapping("/api/users")
public class UserRestController 
{
	// inject the user dao
    @Autowired
    private UserDAO userDAO;
    
    
    // add new user
    @PostMapping("/add")
    public User addUser(@RequestBody User theUser) 
    {  
    		theUser.setId(0);
            userDAO.saveUser(theUser);
            return theUser;
    }
    
    @PutMapping("/update")
    public User updateUser(@RequestBody User theUser) 
    {
    	userDAO.saveUser(theUser);
            
    	return theUser;
    }


    
    // show all users
	@GetMapping("/show")
    public List<User> getUsers() 
	{
		List<User> users = userDAO.getUsers();
        return users;
    }
	
	
	// show one specific user
	@GetMapping("/show/{userId}")
    public User getUser(@PathVariable int userId) 
	{
		User theUser = userDAO.getUser(userId);
	
		if (theUser == null) 
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
		}
		return theUser;
    }
	
	@GetMapping("/showuser/{userName}")
    public User getUser(@PathVariable String userName) 
	{
		User theUser = userDAO.findUserByUsername(userName);
	
		if (theUser == null) 
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
		}
		return theUser;
    }
	
	
	// delete user
	@DeleteMapping("/delete/{userId}")
    public String deleteCustomer(@PathVariable int userId) 
	{
		User theUser = userDAO.getUser(userId);
            
		if (theUser == null) 
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
		}
		userDAO.deleteUser(userId);
		return "Deleted user id - " + userId;
	}
}