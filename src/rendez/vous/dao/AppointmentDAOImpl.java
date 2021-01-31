package rendez.vous.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import rendez.vous.entity.Appointment;

@Repository
public class AppointmentDAOImpl implements AppointmentDAO
{
	@Autowired
    private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<Appointment> getAppointments()
	{
		// get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        
        // create a query
        Query<Appointment> query = currentSession.createQuery("from Appointment", Appointment.class);
        
        // execute the query and get the results list
        List<Appointment> appointments = query.getResultList();
                        
        // return the results
        return appointments;
	}

	@Override
	@Transactional
	public void saveAppointment(Appointment theAppointment)
	{
		// get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        
        // Update Appointment
		currentSession.update(theAppointment);
	}
}