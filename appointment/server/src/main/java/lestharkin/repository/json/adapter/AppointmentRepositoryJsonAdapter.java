package lestharkin.repository.json.adapter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import lestharkin.interfaces.ILinkedList;
import lestharkin.singly.linkedlist.LinkedList;
import lestharkin.domain.Appointment;
import lestharkin.domain.Customer;
import lestharkin.repository.json.entity.AppointmentRepositoryJsonEntity;
import lestharkin.repository.port.AppointmentRepositoryPort;
import lestharkin.shared.environment.Environment;
import lestharkin.shared.file.json.adapter.FileJsonAdapter;
import lestharkin.shared.file.port.FilePort;

public class AppointmentRepositoryJsonAdapter implements AppointmentRepositoryPort<Appointment> {
  private static final String PATH = Environment.getInstance().getVariables().get("DBPATH") + "appointment.json";
  private static final String DATEFMT = Environment.getInstance().getVariables().get("DBDATEFMT") + " "
      + Environment.getInstance().getVariables().get("DBTIMEFMT");

  @Override
  public Appointment getById(String id) {
    FilePort<AppointmentRepositoryJsonEntity> jsonFileAdapter = FileJsonAdapter.getInstance();
    AppointmentRepositoryJsonEntity[] appointmentEntities = jsonFileAdapter.getObjects(PATH,
        AppointmentRepositoryJsonEntity[].class);
    for (AppointmentRepositoryJsonEntity appointmentEntity : appointmentEntities) {
      if (appointmentEntity.getId().equals(id)) {
        CustomerRepositoryJsonAdapter customerJsonAdapter = new CustomerRepositoryJsonAdapter();
        Customer customer = customerJsonAdapter.getById(appointmentEntity.getCustomer());
        try {
          return new Appointment(
              appointmentEntity.getId(),
              customer,
              new SimpleDateFormat(DATEFMT).parse(appointmentEntity.getDate()),
              appointmentEntity.getDescription(),
              Boolean.parseBoolean(appointmentEntity.getClosed()));
        } catch (ParseException e) {
          Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
      }
    }
    return null;
  }

  @Override
  public ILinkedList<Appointment> getAll() {
    ILinkedList<Appointment> appointmentList = new LinkedList<>();
    try {
      FilePort<AppointmentRepositoryJsonEntity> jsonFileAdapter = FileJsonAdapter.getInstance();
      AppointmentRepositoryJsonEntity[] appointmentEntities = jsonFileAdapter.getObjects(PATH,
          AppointmentRepositoryJsonEntity[].class);
      if (appointmentEntities.length > 0) {
        CustomerRepositoryJsonAdapter customerJsonAdapter = new CustomerRepositoryJsonAdapter();
        Customer customer = null;
        for (int i = 0; i < appointmentEntities.length; i++) {
          customer = customerJsonAdapter.getById(appointmentEntities[i].getCustomer());
          appointmentList.add(
              new Appointment(
                  appointmentEntities[i].getId(),
                  customer,
                  new SimpleDateFormat(DATEFMT).parse(appointmentEntities[i].getDate()),
                  appointmentEntities[i].getDescription(),
                  Boolean.parseBoolean(appointmentEntities[i].getClosed())));
        }
      }
    } catch (Exception e) {
      Logger.getLogger(this.getClass().getSimpleName()).log(Level.WARNING, e.getMessage(), e);
    }
    return appointmentList;
  }

  @Override
  public Appointment save(Appointment appointment) {
    String pre = "app";
    try {
      FilePort<AppointmentRepositoryJsonEntity> jsonFileAdapter = FileJsonAdapter.getInstance();
      AppointmentRepositoryJsonEntity[] appointmentEntities = jsonFileAdapter.getObjects(PATH,
          AppointmentRepositoryJsonEntity[].class);
      ILinkedList<AppointmentRepositoryJsonEntity> appointmentEntityList = new LinkedList<>();
      appointmentEntityList.add(appointmentEntities);
      String[] split = (appointmentEntityList.getLast().getId()).split(pre);
      int newId = Integer.parseInt(split[1]) + 1 + (int) Math.pow(10, split[1].length());
      String newIdE = String.valueOf(newId);
      String newIdString = pre + newIdE.substring(1, newIdE.length());
      AppointmentRepositoryJsonEntity appointmentEntity = new AppointmentRepositoryJsonEntity(
          newIdString,
          appointment.getCustomer().getId(),
          new SimpleDateFormat(DATEFMT).format(appointment.getDate()),
          appointment.getDescription(),
          String.valueOf(appointment.isClosed()));
      appointmentEntityList.add(appointmentEntity);
      Object[] array = appointmentEntityList.toArray();
      AppointmentRepositoryJsonEntity[] objects = Arrays.copyOf(array, array.length,
          AppointmentRepositoryJsonEntity[].class);
      jsonFileAdapter.writeObjects(PATH, objects);
      return getById(newIdString);
    } catch (Exception e) {
      Logger.getLogger(this.getClass().getSimpleName()).log(Level.WARNING, e.getMessage(), e);
    }
    return null;
  }

  @Override
  public Appointment update(Appointment appointment) {
    ILinkedList<AppointmentRepositoryJsonEntity> appointmentEntityList = new LinkedList<>();
    try {
      FilePort<AppointmentRepositoryJsonEntity> jsonFileAdapter = FileJsonAdapter.getInstance();
      AppointmentRepositoryJsonEntity[] appointmentEntities = jsonFileAdapter.getObjects(PATH,
          AppointmentRepositoryJsonEntity[].class);
      if (appointmentEntities.length > 0) {
        for (int i = 0; i < appointmentEntities.length; i++) {
          if (appointmentEntities[i].getId().equals(appointment.getId())) {
            appointmentEntities[i].setCustomer(appointment.getCustomer().getId());
            appointmentEntities[i].setDate(new SimpleDateFormat(DATEFMT).format(appointment.getDate()));
            appointmentEntities[i].setDescription(appointment.getDescription());
            appointmentEntities[i].setClosed(String.valueOf(appointment.isClosed()));
          }
          appointmentEntityList.add(appointmentEntities[i]);
        }
      }
      Object[] array = appointmentEntityList.toArray();
      AppointmentRepositoryJsonEntity[] objects = Arrays.copyOf(array, array.length,
          AppointmentRepositoryJsonEntity[].class);
      jsonFileAdapter.writeObjects(PATH, objects);
      return getById(appointment.getId());
    } catch (Exception e) {
      Logger.getLogger(this.getClass().getSimpleName()).log(Level.WARNING, e.getMessage(), e);
    }
    return null;
  }

  @Override
  public boolean delete(String id) {
    boolean successful = false;
    ILinkedList<AppointmentRepositoryJsonEntity> appointmentEntityList = new LinkedList<>();
    try {
      FilePort<AppointmentRepositoryJsonEntity> jsonFileAdapter = FileJsonAdapter.getInstance();
      AppointmentRepositoryJsonEntity[] appointmentEntities = jsonFileAdapter.getObjects(PATH,
          AppointmentRepositoryJsonEntity[].class);
      if (appointmentEntities.length > 0) {
        for (int i = 0; i < appointmentEntities.length; i++) {
          if (!appointmentEntities[i].getId().equals(id)) {
            appointmentEntityList.add(appointmentEntities[i]);
          } else {
            successful = true;
          }
        }
      }
      Object[] array = appointmentEntityList.toArray();
      AppointmentRepositoryJsonEntity[] objects = Arrays.copyOf(array, array.length,
          AppointmentRepositoryJsonEntity[].class);
      jsonFileAdapter.writeObjects(PATH, objects);
      return successful;
    } catch (Exception e) {
      Logger.getLogger(this.getClass().getSimpleName()).log(Level.WARNING, e.getMessage(), e);
    }
    return successful;
  }
}
