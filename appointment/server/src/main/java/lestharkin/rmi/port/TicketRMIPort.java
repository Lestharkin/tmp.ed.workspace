package lestharkin.rmi.port;

import java.rmi.Remote;
import java.rmi.RemoteException;

import lestharkin.domain.Ticket;

public interface TicketRMIPort extends Remote {
  public Ticket openTicket() throws RemoteException;

  public boolean closeTicket(String id) throws RemoteException;
}
