package lestharkin.repository.json.adapter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Iterator;

import org.junit.jupiter.api.Test;

import lestharkin.interfaces.ILinkedList;
import lestharkin.interfaces.ILinkedListNode;
import lestharkin.domain.CustomerType;

class CustomerTypeRepositoryJsonAdapterTest {
  @Test
  void testGetAll() {
    CustomerTypeRepositoryJsonAdapter customerTypeRepositoryJsonAdapter = new CustomerTypeRepositoryJsonAdapter();
    ILinkedList<CustomerType> customerTypeList = customerTypeRepositoryJsonAdapter.getAll();
    Iterator<ILinkedListNode<CustomerType>> i = customerTypeList.iterator();
    assertEquals(new CustomerType(1, "normal").toString(), i.next().getObject().toString());
    assertEquals(new CustomerType(2, "premium").toString(), i.next().getObject().toString());
  }

  @Test
  void testGetById() {
    CustomerTypeRepositoryJsonAdapter customerTypeRepositoryJsonAdapter = new CustomerTypeRepositoryJsonAdapter();
    CustomerType customerTypeTest = customerTypeRepositoryJsonAdapter.getById("1");
    assertEquals(new CustomerType(1, "normal").toString(), customerTypeTest.toString());
  }

  @Test
  void testSave() {
    CustomerTypeRepositoryJsonAdapter customerTypeRepositoryJsonAdapter = new CustomerTypeRepositoryJsonAdapter();
    CustomerType customerTypeTestIn = new CustomerType(0, "test");
    CustomerType customerTypeTestOut = customerTypeRepositoryJsonAdapter.save(customerTypeTestIn);
    assertEquals(customerTypeTestIn.getDescription(), customerTypeTestOut.getDescription());
  }

  @Test
  void testUpdate() {
    CustomerTypeRepositoryJsonAdapter customerTypeRepositoryJsonAdapter = new CustomerTypeRepositoryJsonAdapter();
    CustomerType customerTypeTestIn = new CustomerType(3, "test33");
    CustomerType customerTypeTestOut = customerTypeRepositoryJsonAdapter.update(customerTypeTestIn);
    assertEquals(customerTypeTestIn.getDescription(), customerTypeTestOut.getDescription());
  }

  @Test
  void testDelete() {
    CustomerTypeRepositoryJsonAdapter customerTypeRepositoryJsonAdapter = new CustomerTypeRepositoryJsonAdapter();
    assertTrue(customerTypeRepositoryJsonAdapter.delete("3"));
  }
}
