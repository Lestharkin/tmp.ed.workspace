package lestharkin.app.model;

import lestharkin.app.port.AppointmentModelPort;
import lestharkin.domain.Appointment;
import lestharkin.domain.Customer;
import lestharkin.interfaces.ILinkedList;
import lestharkin.repository.port.AppointmentRepositoryPort;
import lestharkin.repository.port.CustomerRepositoryPort;

public class AppointmentModel implements AppointmentModelPort {
  private AppointmentRepositoryPort<Appointment> appointmentRepositoryAdapter;
  private CustomerRepositoryPort<Customer> customerRepositoryAdapter;

  public AppointmentModel(
      AppointmentRepositoryPort<Appointment> appointmentRepositoryAdapter,
      CustomerRepositoryPort<Customer> customerRepositoryAdapter) {
    this.appointmentRepositoryAdapter = appointmentRepositoryAdapter;
    this.customerRepositoryAdapter = customerRepositoryAdapter;
  }

  @Override
  public Appointment openAppointment(Appointment appointment) {
    Customer customer = customerRepositoryAdapter.getById(appointment.getCustomer().getId());
    if (customer == null) {
      return null;
    }
    return appointmentRepositoryAdapter.save(appointment);
  }

  @Override
  public Appointment getAppointmentById(String id) {
    return appointmentRepositoryAdapter.getById(id);
  }

  @Override
  public boolean cancelAppointmentById(String id) {
    return this.appointmentRepositoryAdapter.delete(id);
  }

  @Override
  public ILinkedList<Appointment> getAppointments() {
    return this.appointmentRepositoryAdapter.getAll();
  }

  @Override
  public boolean closeAppointmentById(String id) {
    Appointment appointmentRepo = this.appointmentRepositoryAdapter.getById(id);
    if (appointmentRepo == null) {
      return false;
    }
    appointmentRepo.setClosed(true);
    return this.appointmentRepositoryAdapter.update(appointmentRepo) != null;
  }

}
