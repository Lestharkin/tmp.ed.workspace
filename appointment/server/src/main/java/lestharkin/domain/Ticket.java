package lestharkin.domain;

public class Ticket {
  private int id;
  private Appointment appointment;

  public Ticket() {
    this.id = 0;
    this.appointment = null;
  }

  public Ticket(int id, Appointment appointment) {
    this.id = id;
    this.appointment = appointment;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Appointment getAppointment() {
    return appointment;
  }

  public void setAppointment(Appointment appointment) {
    this.appointment = appointment;
  }

  
}
