package lestharkin.domain;

import java.io.Serializable;
import java.util.Date;

public class Appointment implements Serializable {
  private static final long serialVersionUID = 13202705L;

  private String id;
  private Customer customer;
  private Date date;
  private String description;
  private boolean closed;

  public Appointment() {
    this.id = "id";
    this.customer = null;
    this.date = null;
    this.description = "";
    this.closed = false;
  }

  public Appointment(String id, Customer customer, Date date, String description, boolean closed) {
    this.id = id;
    this.customer = customer;
    this.date = date;
    this.description = description;
    this.closed = closed;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public boolean isClosed() {
    return closed;
  }

  public void setClosed(boolean closed) {
    this.closed = closed;
  }

  @Override
  public String toString() {
    return "Appointment [id=" + id + ", customer=" + customer + ", date=" + date + ", description=" + description
        + ", closed=" + closed + "]";
  }

}
