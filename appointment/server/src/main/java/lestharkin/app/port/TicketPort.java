package lestharkin.app.port;

import lestharkin.domain.Ticket;

public interface TicketPort {
  public Ticket getTicket(String appointmentId);
}
