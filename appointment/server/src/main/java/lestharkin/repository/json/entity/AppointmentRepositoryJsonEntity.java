package lestharkin.repository.json.entity;

import java.io.Serializable;

public class AppointmentRepositoryJsonEntity implements Serializable {
  private String id;
  private String customer;
  private String date;
  private String description;
  private String closed;

  public AppointmentRepositoryJsonEntity() {
    this.id = "";
    this.customer = "";
    this.date = "";
    this.description = "";
    this.closed = "";
  }

  public AppointmentRepositoryJsonEntity(String id, String customer, String date, String description, String closed) {
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

  public String getCustomer() {
    return customer;
  }

  public void setCustomer(String customer) {
    this.customer = customer;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getClosed() {
    return closed;
  }

  public void setClosed(String closed) {
    this.closed = closed;
  }

  @Override
  public String toString() {
    return "AppointmentRepositoryJsonEntity [id=" + id + ", customer=" + customer + ", date=" + date + ", description="
        + description + ", closed=" + closed + "]";
  }

}
