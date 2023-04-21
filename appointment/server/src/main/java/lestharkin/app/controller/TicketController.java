package lestharkin.app.controller;

import java.io.Serializable;

import lestharkin.app.port.TicketControllerPort;
import lestharkin.domain.Ticket;

public class TicketController implements TicketControllerPort, Serializable{
  public Ticket getTicket(String appointmentId) {
    return null;
  }

}
