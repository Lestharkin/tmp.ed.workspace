package lestharkin.app.port;

import java.io.Serializable;

import lestharkin.domain.Appointment;
import lestharkin.interfaces.ILinkedList;

public interface AppointmentModelPort extends Serializable {
  public Appointment openAppointment(Appointment appointment);

  public Appointment getAppointmentById(String id);

  public boolean cancelAppointmentById(String id);

  public ILinkedList<Appointment> getAppointments();

  public boolean closeAppointmentById(String id);
}
