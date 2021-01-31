package rendez.vous.dao;

import java.util.List;

import rendez.vous.entity.Appointment;

public interface AppointmentDAO 
{
	public List<Appointment> getAppointments();

	public void saveAppointment(Appointment theAppointment);
}
