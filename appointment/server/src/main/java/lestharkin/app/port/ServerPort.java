package lestharkin.app.port;

import java.util.Date;

import lestharkin.domain.Appointment;
import lestharkin.domain.Customer;
import lestharkin.domain.Ticket;

public interface ServerPort {
  public Appointment openAppointment(Customer customer, Date date, String description);

  public boolean closeAppointment(String id);

  public boolean cancelAppointment(String id);

  public Appointment getAppointmentById(String id);

  public Appointment[] getAppointments();

  public Ticket getTicket(String appointmentId);
}
