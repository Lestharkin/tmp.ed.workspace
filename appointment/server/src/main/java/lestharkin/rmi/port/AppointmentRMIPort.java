package lestharkin.rmi.port;

import lestharkin.domain.Appointment;

public interface AppointmentRMIPort {
  public Appointment openAppointment();
  public boolean closeAppointment(String id);
  public boolean cancelAppointment(String id);
  public Appointment getAppointmentById(String id);
  public Appointment[] getAppointmentAll();
}
