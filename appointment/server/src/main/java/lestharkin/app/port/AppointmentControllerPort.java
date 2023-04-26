package lestharkin.app.port;

import java.io.Serializable;

import lestharkin.interfaces.ILinkedList;
import lestharkin.domain.Appointment;
import lestharkin.domain.Bean;

public interface AppointmentControllerPort extends Serializable {
  public Bean<Appointment, String> openAppointment(Appointment appointment);

  public Bean<Appointment, String> getAppointmentById(String id);

  public Bean<Boolean, String> cancelAppointmentById(String id);

  public Bean<ILinkedList<Appointment>, String> getAppointments();

  public Bean<Boolean, String> closeAppointmentById(String id);
}
