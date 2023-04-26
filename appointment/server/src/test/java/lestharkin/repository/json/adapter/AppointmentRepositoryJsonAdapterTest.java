package lestharkin.repository.json.adapter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

import lestharkin.interfaces.ILinkedList;
import lestharkin.interfaces.ILinkedListNode;
import lestharkin.domain.Appointment;
import lestharkin.domain.Customer;
import lestharkin.domain.CustomerType;

class AppointmentRepositoryJsonAdapterTest {
  @Test
  void testGetAll() {
    AppointmentRepositoryJsonAdapter appointmentRepositoryJsonAdapter = new AppointmentRepositoryJsonAdapter();
    ILinkedList<Appointment> appointmentList = appointmentRepositoryJsonAdapter.getAll();
    assertTrue(appointmentList.size() > 0);
    Iterator<ILinkedListNode<Appointment>> i = appointmentList.iterator();
    try {
      assertEquals(
          new Appointment(
              "app0001",
              new Customer(
                  "cus0001",
                  "Juan",
                  "Perez",
                  "juanperez@test.com",
                  new SimpleDateFormat("yyyy-MM-dd").parse("1990-01-01"),
                  new CustomerType(1, "normal")),
              new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2023-05-02 08:00:00"),
              "description 1",
              false).toString(),
          i.next().getObject().toString());
    } catch (Exception e) {
      Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
    }
  }

  @Test
  void testGetById() {
    AppointmentRepositoryJsonAdapter appointmentRepositoryJsonAdapter = new AppointmentRepositoryJsonAdapter();
    Appointment appointment = appointmentRepositoryJsonAdapter.getById("app0001");
    try {
      assertEquals(
          new Appointment(
              "app0001",
              new Customer(
                  "cus0001",
                  "Juan",
                  "Perez",
                  "juanperez@test.com",
                  new SimpleDateFormat("yyyy-MM-dd").parse("1990-01-01"),
                  new CustomerType(1, "normal")),
              new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2023-05-02 08:00:00"),
              "description 1",
              false).toString(),
          appointment.toString());
    } catch (Exception e) {
      Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
    }
  }

  @Test
  void testSave() {
    AppointmentRepositoryJsonAdapter appointmentRepositoryJsonAdapter = new AppointmentRepositoryJsonAdapter();
    Appointment appointmentTestIn;
    CustomerRepositoryJsonAdapter customerRepositoryJsonAdapter = new CustomerRepositoryJsonAdapter();
    Customer customer = customerRepositoryJsonAdapter.getById("cus0004");
    try {
      appointmentTestIn = new Appointment(
          null,
          customer,
          new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2023-06-18 16:30:00"),
          "description 4+", false);
      Appointment appointmentTestOut = appointmentRepositoryJsonAdapter.save(appointmentTestIn);
      appointmentTestIn.setId(appointmentTestOut.getId());
      assertEquals(appointmentTestIn.toString(), appointmentTestOut.toString());
    } catch (Exception e) {
      Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
    }
  }

  @Test
  void testUpdate() {
    AppointmentRepositoryJsonAdapter appointmentRepositoryJsonAdapter = new AppointmentRepositoryJsonAdapter();
    Appointment appointmentTestIn;
    CustomerRepositoryJsonAdapter customerRepositoryJsonAdapter = new CustomerRepositoryJsonAdapter();
    Customer customer = customerRepositoryJsonAdapter.getById("cus0004");
    try {
      appointmentTestIn = new Appointment(
          "app0005",
          customer,
          new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2023-06-07 16:30:00"),
          "description 5+", true);
      Appointment appointmentTestOut = appointmentRepositoryJsonAdapter.update(appointmentTestIn);
      appointmentTestIn.setId(appointmentTestOut.getId());
      assertEquals(appointmentTestIn.toString(), appointmentTestOut.toString());
    } catch (Exception e) {
      Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
    }
  }

  @Test
  void testDelete() {
    AppointmentRepositoryJsonAdapter appointmentRepositoryJsonAdapter = new AppointmentRepositoryJsonAdapter();
    assertTrue(appointmentRepositoryJsonAdapter.delete("app0005"));
  }
}
