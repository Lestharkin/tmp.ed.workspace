package lestharkin.app.controller;

import java.util.Date;

import lestharkin.domain.Appointment;
import lestharkin.domain.Customer;
import lestharkin.domain.CustomerType;
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
    return new Appointment(
      id,
      new Customer("test1", "John", "Doe", "jhon@test.com", new Date(), new CustomerType(0, "Regular")),
      new Date(),
      "Test appointment"
    );
  }

  public Appointment[] getAppointments() {
    return null;
  }

  public Ticket getTicket(String appointmentId) {
    return null;
  }

  


}
