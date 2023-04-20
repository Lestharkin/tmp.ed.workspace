package lestharkin.rmi.adapter;

import lestharkin.domain.Appointment;
import lestharkin.rmi.port.AppointmentRMIPort;

public class AppointmentRMIAdapter implements AppointmentRMIPort {

  @Override
  public Appointment openAppointment() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'openAppointment'");
  }

  @Override
  public boolean closeAppointment(String id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'closeAppointment'");
  }

  @Override
  public boolean cancelAppointment(String id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'cancelAppointment'");
  }

  @Override
  public Appointment getAppointmentById(String id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getAppointmentById'");
  }

  @Override
  public Appointment[] getAppointmentAll() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getAppointmentAll'");
  }
  
}
