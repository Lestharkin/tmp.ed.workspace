package lestharkin.app.controller;

import java.io.Serializable;
import java.util.Date;

import lestharkin.app.port.AppointmentControllerPort;
import lestharkin.domain.Appointment;
import lestharkin.domain.Customer;
import lestharkin.domain.CustomerType;

public class AppointmentController implements AppointmentControllerPort, Serializable {

  public Appointment openAppointment(Customer customer, Date date, String description) {
    return null;
  }

  public boolean closeAppointmentById(String id) {
    return false;
  }

  public boolean cancelAppointmentById(String id) {
    return false;
  }

  public Appointment getAppointmentById(String id) {
    return new Appointment(
        id,
        new Customer("test1", "John", "Doe", "jhon@test.com", new Date(), new CustomerType(0, "Regular")),
        new Date(),
        "Test appointment");
  }

  public Appointment[] getAppointments() {
    return null;
  }

}
