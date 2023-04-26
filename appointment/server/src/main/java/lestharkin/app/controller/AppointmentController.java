package lestharkin.app.controller;

import lestharkin.interfaces.ILinkedList;
import lestharkin.app.model.AppointmentModel;
import lestharkin.app.port.AppointmentControllerPort;
import lestharkin.domain.Appointment;
import lestharkin.domain.Bean;

public class AppointmentController implements AppointmentControllerPort {
  private AppointmentModel appointmentModel;

  public AppointmentController(AppointmentModel appointmentModel) {
    this.appointmentModel = appointmentModel;
  }

  public Bean<Appointment, String> openAppointment(Appointment appointment) {
    Appointment appModel = this.appointmentModel.openAppointment(appointment);
    if (appModel == null) {
      return new Bean<>(null, "501");
    }
    return new Bean<>(appModel, "200");
  }

  public Bean<Appointment, String> getAppointmentById(String id) {
    Appointment appModel = appointmentModel.getAppointmentById(id);
    if (appModel == null) {
      return new Bean<>(null, "501");
    }
    return new Bean<>(appModel, "200");
  }

  public Bean<Boolean, String> cancelAppointmentById(String id) {
    boolean appModel = appointmentModel.cancelAppointmentById(id);
    return new Bean<>(appModel, "200");
  }

  public Bean<ILinkedList<Appointment>, String> getAppointments() {
    ILinkedList<Appointment> appointmentList = appointmentModel.getAppointments();
    if (appointmentList == null || appointmentList.size() < 1) {
      return new Bean<>(null, "501");
    }
    return new Bean<>(appointmentList, "200");
  }

  public Bean<Boolean, String> closeAppointmentById(String id) {
    boolean appModel = appointmentModel.closeAppointmentById(id);
    return new Bean<>(appModel, "200");
  }
}
