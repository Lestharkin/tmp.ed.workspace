package lestharkin.rmi.adapter;

import java.util.Date;

import lestharkin.app.controller.ServerController;
import lestharkin.domain.Appointment;
import lestharkin.domain.Customer;
import lestharkin.rmi.port.AppointmentRMIPort;

public class AppointmentRMIAdapter implements AppointmentRMIPort {
  private ServerController serverController;

  public AppointmentRMIAdapter(ServerController serverController) {
    this.serverController = serverController;
  }

  @Override
  public Appointment openAppointment(Customer customer, Date date, String description) {
    return this.serverController.openAppointment(customer, date, description);
  }

  @Override
  public boolean closeAppointment(String id) {
    return this.serverController.closeAppointment(id);
  }

  @Override
  public boolean cancelAppointment(String id) {
    return this.serverController.cancelAppointment(id);
  }

  @Override
  public Appointment getAppointmentById(String id) {
    return this.serverController.getAppointmentById(id);
  }

  @Override
  public Appointment[] getAppointmentAll() {
    return this.serverController.getAppointments();
  }
  
}
