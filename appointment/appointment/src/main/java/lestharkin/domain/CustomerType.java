package lestharkin.domain;

import java.io.Serializable;

public class CustomerType implements Serializable {
  private static final long serialVersionUID = 14375132L;

  private int id;
  private String description;

  public CustomerType() {
    this.id = 0;
    this.description = "";
  }

  public CustomerType(int id, String description) {
    this.id = id;
    this.description = description;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public String toString() {
    return "CustomerType [id=" + id + ", description=" + description + "]";
  } 
  
}
