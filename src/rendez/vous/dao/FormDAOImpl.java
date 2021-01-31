package rendez.vous.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import rendez.vous.entity.Form;
import rendez.vous.entity.User;

@Repository
public class FormDAOImpl implements FormDAO
{
	
	@Autowired
    private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Form> getForms()
	{
		// get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        
        // create a query
        Query<Form> query = currentSession.createQuery("from Form", Form.class);
        
        
        // execute the query and get the results list
        List<Form> forms = query.getResultList();
                        
        //return the results
        return forms;
	}

	@Override
	@Transactional
	public void saveForm(Form theForm)
	{
		// get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        
        // if user already exists update
		if (theForm.getId() != 0) 
		{
			currentSession.update(theForm);
		} 
		
		// else add user to database
		else 
		{
			currentSession.save(theForm);
		}
	}
	
	@Override
	@Transactional
	public Form getForm(int id)
	{
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// get and return User
		Form form = currentSession.get(Form.class, id);
			
		return form;
	}
	
	@Override
	@Transactional
	public void deleteForm(int id)
	{
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// find the User
		Form Form = currentSession.get(Form.class, id);

		// delete User
		currentSession.delete(Form);
	}

}