package lestharkin.domain;

import java.io.Serializable;

public class Chair implements Serializable {
  private static final long serialVersionUID = 41217023L;

  private int id;
  private boolean status;

  public Chair() {
    this.id = 0;
    this.status = false;
  }

  public Chair(int id, boolean status) {
    this.id = id;
    this.status = status;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public boolean isStatus() {
    return status;
  }

  public void setStatus(boolean status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return "Chair [id=" + id + ", status=" + status + "]";
  }

}
