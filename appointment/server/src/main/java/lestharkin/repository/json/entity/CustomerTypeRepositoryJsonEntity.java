package lestharkin.repository.json.entity;

import java.io.Serializable;

public class CustomerTypeRepositoryJsonEntity implements Serializable {
  private int id;
  private String description;

  public CustomerTypeRepositoryJsonEntity() {
    this.id = 0;
    this.description = "";
  }

  public CustomerTypeRepositoryJsonEntity(int id, String description) {
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
    return "CustomerTypeRepositoryJsonEntity [id=" + id + ", description=" + description + "]";
  }
  
}
