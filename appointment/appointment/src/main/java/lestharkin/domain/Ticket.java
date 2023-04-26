package lestharkin.domain;

import java.io.Serializable;

public class Ticket implements Serializable {
  private static final long serialVersionUID = 51663576L;

  private int id;
  private Appointment appointment;

  public Ticket() {
    this.id = 0;
    this.appointment = null;
  }

  public Ticket(int id, Appointment appointmentId) {
    this.id = id;
    this.appointment = appointmentId;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Appointment getAppointmentId() {
    return appointment;
  }

  public void setAppointment(Appointment appointment) {
    this.appointment = appointment;
  }

  @Override
  public String toString() {
    return "Ticket [id=" + id + ", appointment=" + appointment + "]";
  }

}
