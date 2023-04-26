package lestharkin.app.controller;

import java.io.Serializable;

import lestharkin.domain.Ticket;

public class TicketController implements Serializable {

  private static TicketController instance;

  private TicketController() {
  }

  public static TicketController getInstance() {
    if (instance == null) {
      instance = new TicketController();
    }
    return instance;
  }

  public Ticket openTicket() {
    return new Ticket();
  }

  public boolean closeTicket(String id) {
    return id == null;
  }
  
}
