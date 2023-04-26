package lestharkin.domain;

import java.io.Serializable;
import java.util.Date;

public class Customer implements Serializable {
  private static final long serialVersionUID = 3502564L;

  private String id;
  private String names;
  private String lastNames;
  private String email;
  private Date birthDate;
  private CustomerType customerType;

  public Customer() {
    this.id = "id";
    this.names = "";
    this.lastNames = "";
    this.email = "";
    this.birthDate = new Date();
    this.customerType = null;
  }

  public Customer(String id, String names, String lastNames, String email, Date birthDate, CustomerType customerType) {
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

  public Date getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(Date birthDate) {
    this.birthDate = birthDate;
  }

  public CustomerType getCustomerType() {
    return customerType;
  }

  public void setCustomerType(CustomerType customerType) {
    this.customerType = customerType;
  }

  @Override
  public String toString() {
    return "Customer [id=" + id + ", names=" + names + ", lastNames=" + lastNames + ", email=" + email + ", birthDate="
        + birthDate + ", customerType=" + customerType + "]";
  }
  
}
