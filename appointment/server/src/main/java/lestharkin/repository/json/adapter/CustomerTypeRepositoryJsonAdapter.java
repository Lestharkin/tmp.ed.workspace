package lestharkin.repository.json.adapter;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import lestharkin.interfaces.ILinkedList;
import lestharkin.singly.linkedlist.LinkedList;
import lestharkin.domain.CustomerType;
import lestharkin.repository.json.entity.CustomerTypeRepositoryJsonEntity;
import lestharkin.repository.port.CustomerTypeRepositoryPort;
import lestharkin.shared.environment.Environment;
import lestharkin.shared.file.json.adapter.FileJsonAdapter;
import lestharkin.shared.file.port.FilePort;

public class CustomerTypeRepositoryJsonAdapter implements CustomerTypeRepositoryPort<CustomerType> {
  private static final String PATH = Environment.getInstance().getVariables().get("DBPATH") + "customerType.json";

  @Override
  public CustomerType getById(String id) {
    FilePort<CustomerTypeRepositoryJsonEntity> jsonFileAdapter = FileJsonAdapter.getInstance();
    CustomerTypeRepositoryJsonEntity[] customerTypeEntities = jsonFileAdapter.getObjects(PATH,
        CustomerTypeRepositoryJsonEntity[].class);
    int byId = 0;
    for (CustomerTypeRepositoryJsonEntity customerTypeEntity : customerTypeEntities) {
      try {
        byId = Integer.parseInt(id);
        if (customerTypeEntity.getId() == byId) {
          return new CustomerType(customerTypeEntity.getId(), customerTypeEntity.getDescription());
        }
      } catch (Exception e) {
        Logger.getLogger(this.getClass().getSimpleName()).log(Level.WARNING, e.getMessage(), e);
      }
    }
    return null;
  }

  @Override
  public ILinkedList<CustomerType> getAll() {
    ILinkedList<CustomerType> customerTypeList = new LinkedList<>();
    try {
      FilePort<CustomerTypeRepositoryJsonEntity> jsonFileAdapter = FileJsonAdapter.getInstance();
      CustomerTypeRepositoryJsonEntity[] customerTypeEntities = jsonFileAdapter.getObjects(PATH,
          CustomerTypeRepositoryJsonEntity[].class);
      if (customerTypeEntities.length > 0) {
        for (int i = 0; i < customerTypeEntities.length; i++) {
          customerTypeList
              .add(new CustomerType(customerTypeEntities[i].getId(), customerTypeEntities[i].getDescription()));
        }
      }
    } catch (Exception e) {
      Logger.getLogger(this.getClass().getSimpleName()).log(Level.WARNING, e.getMessage(), e);
    }
    return customerTypeList;
  }

  @Override
  public CustomerType save(CustomerType customerType) {
    try {
      FilePort<CustomerTypeRepositoryJsonEntity> jsonFileAdapter = FileJsonAdapter.getInstance();
      CustomerTypeRepositoryJsonEntity[] customerTypeEntities = jsonFileAdapter.getObjects(PATH,
          CustomerTypeRepositoryJsonEntity[].class);
      ILinkedList<CustomerTypeRepositoryJsonEntity> customerTypeEntityList = new LinkedList<>();
      customerTypeEntityList.add(customerTypeEntities);
      int newId = customerTypeEntityList.getLast().getId() + 1;
      CustomerTypeRepositoryJsonEntity customerTypeEntity = new CustomerTypeRepositoryJsonEntity(newId,
          customerType.getDescription());
      customerTypeEntityList.add(customerTypeEntity);
      Object[] array = customerTypeEntityList.toArray();
      CustomerTypeRepositoryJsonEntity[] objects = Arrays.copyOf(array, array.length,
          CustomerTypeRepositoryJsonEntity[].class);
      jsonFileAdapter.writeObjects(PATH, objects);
      return getById(String.valueOf(newId));
    } catch (Exception e) {
      Logger.getLogger(this.getClass().getSimpleName()).log(Level.WARNING, e.getMessage(), e);
    }
    return null;
  }

  @Override
  public CustomerType update(CustomerType customerType) {
    ILinkedList<CustomerTypeRepositoryJsonEntity> customerTypeEntityList = new LinkedList<>();
    try {
      FilePort<CustomerTypeRepositoryJsonEntity> jsonFileAdapter = FileJsonAdapter.getInstance();
      CustomerTypeRepositoryJsonEntity[] customerTypeEntities = jsonFileAdapter.getObjects(PATH,
          CustomerTypeRepositoryJsonEntity[].class);
      if (customerTypeEntities.length > 0) {
        for (int i = 0; i < customerTypeEntities.length; i++) {
          if (customerTypeEntities[i].getId() == customerType.getId()) {
            customerTypeEntities[i].setDescription(customerType.getDescription());
          }
          customerTypeEntityList.add(customerTypeEntities[i]);
        }
      }
      Object[] array = customerTypeEntityList.toArray();
      CustomerTypeRepositoryJsonEntity[] objects = Arrays.copyOf(array, array.length,
          CustomerTypeRepositoryJsonEntity[].class);
      jsonFileAdapter.writeObjects(PATH, objects);
      return getById(String.valueOf(customerType.getId()));
    } catch (Exception e) {
      Logger.getLogger(this.getClass().getSimpleName()).log(Level.WARNING, e.getMessage(), e);
    }
    return null;
  }

  @Override
  public boolean delete(String id) {
    boolean successful = false;
    ILinkedList<CustomerTypeRepositoryJsonEntity> customerTypeEntityList = new LinkedList<>();
    try {
      FilePort<CustomerTypeRepositoryJsonEntity> jsonFileAdapter = FileJsonAdapter.getInstance();
      CustomerTypeRepositoryJsonEntity[] customerTypeEntities = jsonFileAdapter.getObjects(PATH,
          CustomerTypeRepositoryJsonEntity[].class);
      if (customerTypeEntities.length > 0) {
        for (int i = 0; i < customerTypeEntities.length; i++) {
          if (customerTypeEntities[i].getId() != Integer.parseInt(id)) {
            customerTypeEntityList.add(customerTypeEntities[i]);
          } else {
            successful = true;
          }
        }
      }
      Object[] array = customerTypeEntityList.toArray();
      CustomerTypeRepositoryJsonEntity[] objects = Arrays.copyOf(array, array.length,
          CustomerTypeRepositoryJsonEntity[].class);
      jsonFileAdapter.writeObjects(PATH, objects);
      return true;
    } catch (Exception e) {
      Logger.getLogger(this.getClass().getSimpleName()).log(Level.WARNING, e.getMessage(), e);
    }
    return successful;
  }

}
