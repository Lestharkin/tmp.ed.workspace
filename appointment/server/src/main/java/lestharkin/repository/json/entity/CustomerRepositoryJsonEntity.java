package lestharkin.repository.json.entity;

import java.io.Serializable;

public class CustomerRepositoryJsonEntity implements Serializable {
  private String id;
  private String names;
  private String lastNames;
  private String email;
  private String birthDate;
  private String customerType;

  public CustomerRepositoryJsonEntity() {
    this.id = "";
    this.names = "";
    this.lastNames = "";
    this.email = "";
    this.birthDate = "";
    this.customerType = "";
  }

  public CustomerRepositoryJsonEntity(String id, String names, String lastNames, String email, String birthDate,
      String customerType) {
    this.id = id;
    this.names = names;
    this.lastNames = lastNames;
    this.email = email;
    this.birthDate = birthDate;
    this.customerType = customerType;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getNames() {
    return names;
  }

  public void setNames(String names) {
    this.names = names;
  }

  public String getLastNames() {
    return lastNames;
  }

  public void setLastNames(String lastNames) {
    this.lastNames = lastNames;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(String birthDate) {
    this.birthDate = birthDate;
  }

  public String getCustomerType() {
    return customerType;
  }

  public void setCustomerType(String customerType) {
    this.customerType = customerType;
  }

  @Override
  public String toString() {
    return "CustomerRepositoryJsonEntity [id=" + id + ", names=" + names + ", lastNames=" + lastNames + ", email="
        + email + ", birthDate=" + birthDate + ", customerType=" + customerType + "]";
  }  

}
