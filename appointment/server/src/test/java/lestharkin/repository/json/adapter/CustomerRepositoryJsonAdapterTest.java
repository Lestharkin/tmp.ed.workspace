package lestharkin.repository.json.adapter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

import lestharkin.interfaces.ILinkedList;
import lestharkin.interfaces.ILinkedListNode;
import lestharkin.domain.Customer;
import lestharkin.domain.CustomerType;

class CustomerRepositoryJsonAdapterTest {
  @Test
  void testGetAll() {
    CustomerRepositoryJsonAdapter customerRepositoryJsonAdapter = new CustomerRepositoryJsonAdapter();
    ILinkedList<Customer> customerList = customerRepositoryJsonAdapter.getAll();
    assertTrue(customerList.size() > 0);
    Iterator<ILinkedListNode<Customer>> i = customerList.iterator();
    try {
      assertEquals(
          new Customer(
              "cus0001",
              "Juan",
              "Perez",
              "juanperez@test.com",
              new SimpleDateFormat("yyyy-MM-dd").parse("1990-01-01"),
              new CustomerType(1, "normal")).toString(),
          i.next().getObject().toString());
      assertEquals(
          new Customer(
              "cus0002",
              "pepa",
              "Fernandez",
              "pepafernandez@test.com",
              new SimpleDateFormat("yyyy-MM-dd").parse("1950-12-25"),
              new CustomerType(1, "normal")).toString(),
          i.next().getObject().toString());
      assertEquals(
          new Customer(
              "cus0003",
              "martha",
              "gonzález",
              "marthaken@test.com",
              new SimpleDateFormat("yyyy-MM-dd").parse("2001-02-17"),
              new CustomerType(2, "premium")).toString(),
          i.next().getObject().toString());
    } catch (ParseException e) {
      Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
    }
  }

  @Test
  void testGetById() {
    CustomerRepositoryJsonAdapter customerRepositoryJsonAdapter = new CustomerRepositoryJsonAdapter();
    Customer customer = customerRepositoryJsonAdapter.getById("cus0001");
    try {
      assertEquals(
          new Customer(
              "cus0001",
              "Juan",
              "Perez",
              "juanperez@test.com",
              new SimpleDateFormat("yyyy-MM-dd").parse("1990-01-01"),
              new CustomerType(1, "normal")).toString(),
          customer.toString());
    } catch (ParseException e) {
      Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
    }
  }

  @Test
  void testSave() {
    CustomerRepositoryJsonAdapter customerRepositoryJsonAdapter = new CustomerRepositoryJsonAdapter();
    Customer customerTestIn;
    try {
      customerTestIn = new Customer(
          null,
          "Mario",
          "Bros",
          "mariotest@test.com",
          new SimpleDateFormat("yyyy-MM-dd").parse("2001-05-15"),
          new CustomerType(1, "normal"));
      Customer customerTestOut = customerRepositoryJsonAdapter.save(customerTestIn);
      customerTestIn.setId(customerTestOut.getId());
      assertEquals(customerTestIn.toString(), customerTestOut.toString());
    } catch (ParseException e) {
      Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
    }
  }

  @Test
  void testUpdate() {
    CustomerRepositoryJsonAdapter customerRepositoryJsonAdapter = new CustomerRepositoryJsonAdapter();
    Customer customerTestIn;
    try {
      customerTestIn = new Customer(
          "cus0005",
          "Mario test2",
          "Bros test2",
          "mariotest@test.com",
          new SimpleDateFormat("yyyy-MM-dd").parse("1999-05-15"),
          new CustomerType(2, "premium"));
      Customer customerTestOut = customerRepositoryJsonAdapter.update(customerTestIn);
      assertEquals(customerTestIn.toString(), customerTestOut.toString());
    } catch (ParseException e) {
      Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
    }
  }

  @Test
  void testDelete() {
    CustomerRepositoryJsonAdapter customerRepositoryJsonAdapter = new CustomerRepositoryJsonAdapter();
    assertTrue(customerRepositoryJsonAdapter.delete("cus0005"));
  }
}
