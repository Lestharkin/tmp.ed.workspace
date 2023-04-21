package lestharkin.app.port;

import lestharkin.domain.Ticket;

public interface TicketControllerPort {
  public Ticket getTicket(String appointmentId);
}
