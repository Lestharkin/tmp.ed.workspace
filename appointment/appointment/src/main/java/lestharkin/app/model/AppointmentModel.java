package lestharkin.app.model;

import lestharkin.interfaces.ILinkedList;
import lestharkin.app.port.AppointmentModelPort;
import lestharkin.domain.Appointment;
import lestharkin.rmi.adapter.AppointmentRMIAdapter;

public class AppointmentModel implements AppointmentModelPort {
  private AppointmentRMIAdapter appointmentRMIAdapter;
  
  public AppointmentModel(AppointmentRMIAdapter appointmentRMIAdapter) {
    this.appointmentRMIAdapter = appointmentRMIAdapter;
  }
  @Override
  public Appointment openAppointment(Appointment appointment) {
    return appointmentRMIAdapter.openAppointment(appointment);
  }

  @Override
  public Appointment getAppointmentById(String id) {
    return appointmentRMIAdapter.getAppointmentById(id);
  }

  @Override
  public boolean cancelAppointmentById(String id) {
    return appointmentRMIAdapter.cancelAppointmentById(id);
  }

  @Override
  public ILinkedList<Appointment> getAppointments() {
    return appointmentRMIAdapter.getAppointments();
  }

  @Override
  public boolean closeAppointmentById(String id) {
    return appointmentRMIAdapter.closeAppointmentById(id);
  }
  
}
