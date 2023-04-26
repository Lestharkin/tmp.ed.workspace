package lestharkin.rmi.adapter;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import lestharkin.interfaces.ILinkedList;
import lestharkin.app.port.AppointmentControllerPort;
import lestharkin.domain.Appointment;
import lestharkin.domain.Bean;
import lestharkin.rmi.port.AppointmentRMIPort;

public class AppointmentRMIAdapter extends UnicastRemoteObject implements AppointmentRMIPort {
  private AppointmentControllerPort appointmentController;

  public AppointmentRMIAdapter(AppointmentControllerPort appointmentController) throws RemoteException {
    this.appointmentController = appointmentController;
  }

  @Override
  public Bean<Appointment, String> openAppointment(Appointment appointment) throws RemoteException {
    if (appointment == null) {
      return new Bean<>(null, "404");
    }
    return appointmentController.openAppointment(appointment);
  }

  @Override
  public Bean<Appointment, String> getAppointmentById(String id) throws RemoteException {
    if (id == null) {
      return new Bean<>(null, "404");
    }
    return appointmentController.getAppointmentById(id);
  }

  @Override
  public Bean<Boolean, String> cancelAppointmentById(String id) throws RemoteException {
    if (id == null) {
      return new Bean<>(null, "404");
    }
    return appointmentController.cancelAppointmentById(id);
  }

  @Override
  public Bean<ILinkedList<Appointment>, String> getAppointments() throws RemoteException {
    Bean<ILinkedList<Appointment>, String> appointmentBean = appointmentController.getAppointments();
    if (appointmentBean.getData() == null || appointmentBean.getData().size() < 1) {
      return new Bean<>(null, "501");
    }
    return appointmentBean;
  }

  @Override
  public Bean<Boolean, String> closeAppointmentById(String id) throws RemoteException {
    if (id == null) {
      return new Bean<>(null, "404");
    }
    return appointmentController.closeAppointmentById(id);
  }
}
