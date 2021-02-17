package rendez.vous.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import rendez.vous.dao.FormDAO;
import rendez.vous.entity.Form;

@Secured("ROLE_CHIEF")
@RestController
@RequestMapping("/form")
public class FormRestController 
{
	// inject the form dao
    @Autowired
    private FormDAO formDAO;
    
    
    // add new form
    @PostMapping("/add")
    public Form addForm(@RequestBody Form theForm) 
    {  
    	theForm.setId(0);
    	formDAO.saveForm(theForm);
        return theForm;
    }

    
    // show all forms
	@GetMapping("/show")
    public List<Form> getForms() 
	{
		List<Form> forms = formDAO.getForms();
        return forms;
    }
	
	
	// show one specific form
	@GetMapping("/show/{formId}")
    public Form getForm(@PathVariable int formId) 
	{
		Form theForm = formDAO.getForm(formId);
	
		if (theForm == null) 
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "form not found");
		}
		return theForm;
    }
	
	
	// delete form
	@DeleteMapping("/delete/{formId}")
    public String deleteForm(@PathVariable int formId) 
	{
		Form theForm = formDAO.getForm(formId);
            
		if (theForm == null) 
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "form not found");
		}
		formDAO.deleteForm(formId);
		return "Deleted form id - " + formId;
	}
}