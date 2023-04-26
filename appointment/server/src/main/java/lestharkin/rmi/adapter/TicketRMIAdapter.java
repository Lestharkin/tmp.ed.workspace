package lestharkin.rmi.adapter;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import lestharkin.app.controller.TicketController;
import lestharkin.domain.Ticket;
import lestharkin.rmi.port.TicketRMIPort;

public class TicketRMIAdapter extends UnicastRemoteObject implements TicketRMIPort {
  
  private TicketController ticketController;

  public TicketRMIAdapter(TicketController ticketController) throws RemoteException {
    this.ticketController = ticketController;
  }

  @Override
  public Ticket openTicket() throws RemoteException {
    return ticketController.openTicket();
  }

  @Override
  public boolean closeTicket(String id) throws RemoteException {
    return ticketController.closeTicket(id);
  }
}
