package lestharkin.app.controller;

import java.util.Date;

import lestharkin.domain.Appointment;
import lestharkin.domain.Customer;
import lestharkin.domain.Ticket;

public class ServerController {
  

  public Appointment openAppointment(Customer customer, Date date, String description) {
    return null;
  }

  public boolean closeAppointment(String id) {
    return false;
  }

  public boolean cancelAppointment(String id) {
    return false;
  }

  public Appointment getAppointmentById(String id) {
    return null;
  }

  public Appointment[] getAppointments() {
    return null;
  }

  public Ticket getTicket(String appointmentId) {
    return null;
  }

  


}
