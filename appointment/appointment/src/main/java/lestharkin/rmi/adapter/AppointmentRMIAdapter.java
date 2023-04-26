package lestharkin.rmi.adapter;

import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

import lestharkin.interfaces.ILinkedList;
import lestharkin.domain.Appointment;
import lestharkin.domain.Bean;
import lestharkin.rmi.port.AppointmentRMIPort;

public class AppointmentRMIAdapter {
  private AppointmentRMIPort service;

  public AppointmentRMIAdapter(AppointmentRMIPort service) {
    this.service = service;
  }

  public Appointment openAppointment(Appointment appointment) {
    try {
      Bean<Appointment, String> result = service.openAppointment(appointment);
      return (result.getMessage().equals("200")) ? result.getData() : null;
    } catch (RemoteException e) {
      Logger.getLogger(this.getClass().getSimpleName()).log(Level.WARNING, e.getMessage(), e);
    }
    return null;
  }

  public Appointment getAppointmentById(String id) {
    try {
      Bean<Appointment, String> result = service.getAppointmentById(id);
      return (result.getMessage().equals("200")) ? result.getData() : null;
    } catch (RemoteException e) {
      Logger.getLogger(this.getClass().getSimpleName()).log(Level.WARNING, e.getMessage(), e);
    }
    return null;
  }

  public boolean cancelAppointmentById(String id) {
    try {
      Bean<Boolean, String> result = service.cancelAppointmentById(id);
      return result.getData();
    } catch (RemoteException e) {
      Logger.getLogger(this.getClass().getSimpleName()).log(Level.WARNING, e.getMessage(), e);
    }
    return false;
  }

  public ILinkedList<Appointment> getAppointments() {
    try {
      Bean<ILinkedList<Appointment>, String> result = service.getAppointments();
      return (result.getMessage().equals("200")) ? result.getData() : null;
    } catch (RemoteException e) {
      Logger.getLogger(this.getClass().getSimpleName()).log(Level.WARNING, e.getMessage(), e);
    }
    return null;
  }

  public boolean closeAppointmentById(String id) {
    try {
      Bean<Boolean, String> result = service.closeAppointmentById(id);
      return result.getData();
    } catch (RemoteException e) {
      Logger.getLogger(this.getClass().getSimpleName()).log(Level.WARNING, e.getMessage(), e);
    }
    return false;
  }
}
