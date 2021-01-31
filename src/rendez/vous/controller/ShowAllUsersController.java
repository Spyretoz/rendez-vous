package rendez.vous.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import rendez.vous.dao.UserDAO;
import rendez.vous.entity.User;

@Controller
@Secured("ROLE_ADMIN")
@RequestMapping("/showuser")
public class ShowAllUsersController 
{

	// inject the customer dao
    @Autowired
    private UserDAO userDAO;
    
    @RequestMapping("/list")
    public String listUsers(Model model) 
    {
    		model.addAttribute("pageTitle", "All Users");
    		
            // get customers from dao
            List<User> users = userDAO.getUsers();
            
            // add the customers to the model
            model.addAttribute("users", users);
            
            return "list-users";
    }   
}