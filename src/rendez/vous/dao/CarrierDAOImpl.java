package rendez.vous.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import rendez.vous.dao.CarrierDAO;
import rendez.vous.entity.Carrier;
import rendez.vous.entity.Form;

@Repository
public class CarrierDAOImpl implements CarrierDAO 
{
	
	@Autowired
    private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<Carrier> getCarriers()
	{
		// get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        
        // create a query
        Query<Carrier> query = currentSession.createQuery("from Carrier", Carrier.class);
        
        
        // execute the query and get the results list
        List<Carrier> carriers = query.getResultList();
                        
        //return the results
        return carriers;
	}

	@Override
	@Transactional
	public void saveCarrier(Carrier theCarrier)
	{
		// get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        
        // if user already exists update
		if (theCarrier.getId() != 0) 
		{
			currentSession.update(theCarrier);
		} 
		
		// else add user to database
		else 
		{
			currentSession.save(theCarrier);
		}
	}
	
	@Override
	@Transactional
	public Carrier getCarrier(int id)
	{
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// get and return User
		Carrier carrier = currentSession.get(Carrier.class, id);
				
		return carrier;
	}
	
	@Override
	@Transactional
	public void deleteCarrier(int id) 
	{
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// find the User
		Carrier Carrier = currentSession.get(Carrier.class, id);

		// delete User
		currentSession.delete(Carrier);
	}

}
