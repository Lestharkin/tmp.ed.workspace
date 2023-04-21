package lestharkin.rmi.adapter;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

import lestharkin.app.controller.AppointmentController;
import lestharkin.domain.Appointment;
import lestharkin.domain.Customer;
import lestharkin.rmi.port.AppointmentRMIPort;

public class AppointmentRMIAdapter extends UnicastRemoteObject implements AppointmentRMIPort {
  private AppointmentController serverController;

  public AppointmentRMIAdapter(AppointmentController serverController) throws RemoteException {
    this.serverController = serverController;
  }

  @Override
  public Appointment openAppointment(Customer customer, Date date, String description) throws RemoteException {
    return this.serverController.openAppointment(customer, date, description);
  }

  @Override
  public boolean closeAppointmentById(String id) throws RemoteException {
    return this.serverController.closeAppointmentById(id);
  }

  @Override
  public boolean cancelAppointmentById(String id) throws RemoteException {
    return this.serverController.cancelAppointmentById(id);
  }

  @Override
  public Appointment getAppointmentById(String id) throws RemoteException {
    return this.serverController.getAppointmentById(id);
  }

  @Override
  public Appointment[] getAppointmentAll() throws RemoteException {
    return this.serverController.getAppointments();
  }
  
}
