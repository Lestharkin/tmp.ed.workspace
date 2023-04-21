package lestharkin.app.port;

import java.util.Date;

import lestharkin.domain.Appointment;
import lestharkin.domain.Customer;

public interface AppointmentControllerPort {
  public Appointment openAppointment(Customer customer, Date date, String description);

  public boolean closeAppointmentById(String id);

  public boolean cancelAppointmentById(String id);

  public Appointment getAppointmentById(String id);

  public Appointment[] getAppointments();

}
