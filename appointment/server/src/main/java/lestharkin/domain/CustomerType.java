package lestharkin.domain;

public class CustomerType {

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

  


  
}
