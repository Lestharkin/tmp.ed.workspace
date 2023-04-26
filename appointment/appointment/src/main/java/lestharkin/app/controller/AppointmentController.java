package lestharkin.app.controller;

import lestharkin.interfaces.ILinkedList;
import lestharkin.app.port.AppointmentModelPort;
import lestharkin.domain.Appointment;

public class AppointmentController {
  private AppointmentModelPort appointmentModel;
  
  public AppointmentController(AppointmentModelPort appointmentModel) {
    this.appointmentModel = appointmentModel;
  }

  public Appointment openAppointment(Appointment appointment)  {
    return appointmentModel.openAppointment(appointment);
  }

  public Appointment getAppointmentById(String id) {
    return appointmentModel.getAppointmentById(id);
  }

  public boolean cancelAppointmentById(String id) {
    return appointmentModel.cancelAppointmentById(id);
  }

  public ILinkedList<Appointment> getAppointments() {
    return appointmentModel.getAppointments();
  }

  public boolean closeAppointmentById(String id) {
    return appointmentModel.closeAppointmentById(id);
  }
}
