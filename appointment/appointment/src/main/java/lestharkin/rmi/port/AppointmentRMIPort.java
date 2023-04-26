package lestharkin.rmi.port;

import java.rmi.Remote;
import java.rmi.RemoteException;

import lestharkin.domain.Appointment;
import lestharkin.domain.Bean;
import lestharkin.interfaces.ILinkedList;

public interface AppointmentRMIPort extends Remote {
  public Bean<Appointment, String> openAppointment(Appointment appointment) throws RemoteException;

  public Bean<Appointment, String> getAppointmentById(String id) throws RemoteException;

  public Bean<Boolean, String> cancelAppointmentById(String id) throws RemoteException;

  public Bean<ILinkedList<Appointment>, String> getAppointments() throws RemoteException;

  public Bean<Boolean, String> closeAppointmentById(String id) throws RemoteException;

}
