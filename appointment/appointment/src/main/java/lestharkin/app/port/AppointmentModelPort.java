package lestharkin.app.port;

import lestharkin.interfaces.ILinkedList;
import lestharkin.domain.Appointment;

public interface AppointmentModelPort {
  public Appointment openAppointment(Appointment appointment);

  public Appointment getAppointmentById(String id);

  public boolean cancelAppointmentById(String id);

  public ILinkedList<Appointment> getAppointments();

  public boolean closeAppointmentById(String id);
}
