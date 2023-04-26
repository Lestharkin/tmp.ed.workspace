package lestharkin.repository.json.adapter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import lestharkin.interfaces.ILinkedList;
import lestharkin.singly.linkedlist.LinkedList;
import lestharkin.domain.Customer;
import lestharkin.domain.CustomerType;
import lestharkin.repository.json.entity.CustomerRepositoryJsonEntity;
import lestharkin.repository.port.CustomerRepositoryPort;
import lestharkin.shared.environment.Environment;
import lestharkin.shared.file.json.adapter.FileJsonAdapter;
import lestharkin.shared.file.port.FilePort;

public class CustomerRepositoryJsonAdapter implements CustomerRepositoryPort<Customer> {
  private static final String PATH = Environment.getInstance().getVariables().get("DBPATH") + "customer.json";
  private static final String DATEFMT = Environment.getInstance().getVariables().get("DBDATEFMT");

  @Override
  public Customer getById(String id) {
    FilePort<CustomerRepositoryJsonEntity> jsonFileAdapter = FileJsonAdapter.getInstance();
    CustomerRepositoryJsonEntity[] customerEntities = jsonFileAdapter.getObjects(PATH,
        CustomerRepositoryJsonEntity[].class);
    for (CustomerRepositoryJsonEntity customerEntity : customerEntities) {
      if (customerEntity.getId().equals(id)) {
        CustomerTypeRepositoryJsonAdapter customerTypeJsonAdapter = new CustomerTypeRepositoryJsonAdapter();
        CustomerType customerType = customerTypeJsonAdapter.getById(customerEntity.getCustomerType());
        try {
          return new Customer(
              customerEntity.getId(),
              customerEntity.getNames(),
              customerEntity.getLastNames(),
              customerEntity.getEmail(),
              new SimpleDateFormat(DATEFMT).parse(customerEntity.getBirthDate()),
              customerType);
        } catch (ParseException e) {
          Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
      }
    }
    return null;
  }

  @Override
  public ILinkedList<Customer> getAll() {
    ILinkedList<Customer> customerList = new LinkedList<>();
    try {
      FilePort<CustomerRepositoryJsonEntity> jsonFileAdapter = FileJsonAdapter.getInstance();
      CustomerRepositoryJsonEntity[] customerEntities = jsonFileAdapter.getObjects(PATH,
          CustomerRepositoryJsonEntity[].class);
        if (customerEntities.length > 0) {
        CustomerTypeRepositoryJsonAdapter customerTypeJsonAdapter = new CustomerTypeRepositoryJsonAdapter();
        CustomerType customerType = null;
        for (int i = 0; i < customerEntities.length; i++) {
          customerType = customerTypeJsonAdapter.getById(customerEntities[i].getCustomerType());
          customerList.add(
              new Customer(customerEntities[i].getId(),
                  customerEntities[i].getNames(),
                  customerEntities[i].getLastNames(),
                  customerEntities[i].getEmail(),
                  new SimpleDateFormat(DATEFMT).parse(customerEntities[i].getBirthDate()),
                  customerType));
        }
      }
    } catch (Exception e) {
      Logger.getLogger(this.getClass().getSimpleName()).log(Level.WARNING, e.getMessage(), e);
    }
    return customerList;
  }

  @Override
  public Customer save(Customer customer) {
    String pre = "cus";
    try {
      FilePort<CustomerRepositoryJsonEntity> jsonFileAdapter = FileJsonAdapter.getInstance();
      CustomerRepositoryJsonEntity[] customerEntities = jsonFileAdapter.getObjects(PATH,
          CustomerRepositoryJsonEntity[].class);
      ILinkedList<CustomerRepositoryJsonEntity> customerEntityList = new LinkedList<>();
      customerEntityList.add(customerEntities);
      String[] split = (customerEntityList.getLast().getId()).split(pre);
      int newId = Integer.parseInt(split[1]) + 1 + (int) Math.pow(10, split[1].length());
      String newIdE = String.valueOf(newId);
      String newIdString = pre + newIdE.substring(1, newIdE.length());
      CustomerRepositoryJsonEntity customerEntity = new CustomerRepositoryJsonEntity(
          newIdString,
          customer.getNames(),
          customer.getLastNames(),
          customer.getEmail(),
          new SimpleDateFormat(DATEFMT).format(customer.getBirthDate()),
          String.valueOf(customer.getCustomerType().getId()));
      customerEntityList.add(customerEntity);
      Object[] array = customerEntityList.toArray();
      CustomerRepositoryJsonEntity[] objects = Arrays.copyOf(array, array.length, CustomerRepositoryJsonEntity[].class);
      jsonFileAdapter.writeObjects(PATH, objects);
      return getById(newIdString);
    } catch (Exception e) {
      Logger.getLogger(this.getClass().getSimpleName()).log(Level.WARNING, e.getMessage(), e);
    }
    return null;
  }

  @Override
  public Customer update(Customer customer) {
    ILinkedList<CustomerRepositoryJsonEntity> customerEntityList = new LinkedList<>();
    try {
      FilePort<CustomerRepositoryJsonEntity> jsonFileAdapter = FileJsonAdapter.getInstance();
      CustomerRepositoryJsonEntity[] customerEntities = jsonFileAdapter.getObjects(PATH,
          CustomerRepositoryJsonEntity[].class);
      if (customerEntities.length > 0) {
        for (int i = 0; i < customerEntities.length; i++) {
          if (customerEntities[i].getId().equals(customer.getId())) {
            customerEntities[i].setNames(customer.getNames());
            customerEntities[i].setLastNames(customer.getLastNames());
            customerEntities[i].setEmail(customer.getEmail());
            customerEntities[i].setBirthDate(new SimpleDateFormat(DATEFMT).format(customer.getBirthDate()));
            customerEntities[i].setCustomerType(String.valueOf(customer.getCustomerType().getId()));
          }
          customerEntityList.add(customerEntities[i]);
        }
      }
      Object[] array = customerEntityList.toArray();
      CustomerRepositoryJsonEntity[] objects = Arrays.copyOf(array, array.length, CustomerRepositoryJsonEntity[].class);
      jsonFileAdapter.writeObjects(PATH, objects);
      return getById(customer.getId());
    } catch (Exception e) {
      Logger.getLogger(this.getClass().getSimpleName()).log(Level.WARNING, e.getMessage(), e);
    }
    return null;
  }

  @Override
  public boolean delete(String id) {
    boolean successful = false;
    ILinkedList<CustomerRepositoryJsonEntity> customerEntityList = new LinkedList<>();
    try {
      FilePort<CustomerRepositoryJsonEntity> jsonFileAdapter = FileJsonAdapter.getInstance();
      CustomerRepositoryJsonEntity[] customerEntities = jsonFileAdapter.getObjects(PATH,
          CustomerRepositoryJsonEntity[].class);
      if (customerEntities.length > 0) {
        for (int i = 0; i < customerEntities.length; i++) {
          if (!customerEntities[i].getId().equals(id)) {
            customerEntityList.add(customerEntities[i]);
          } else {
            successful = true;
          }
        }
      }
      Object[] array = customerEntityList.toArray();
      CustomerRepositoryJsonEntity[] objects = Arrays.copyOf(array, array.length, CustomerRepositoryJsonEntity[].class);
      jsonFileAdapter.writeObjects(PATH, objects);
      return successful;
    } catch (Exception e) {
      Logger.getLogger(this.getClass().getSimpleName()).log(Level.WARNING, e.getMessage(), e);
    }
    return successful;
  }

}
