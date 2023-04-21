package lestharkin.rmi.port;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;

import lestharkin.domain.Appointment;
import lestharkin.domain.Customer;

public interface AppointmentRMIPort extends Remote {
  public Appointment openAppointment(Customer customer, Date date, String description) throws RemoteException;
  public boolean closeAppointmentById(String id) throws RemoteException;
  public boolean cancelAppointmentById(String id) throws RemoteException;
  public Appointment getAppointmentById(String id) throws RemoteException;
  public Appointment[] getAppointmentAll() throws RemoteException;
}
