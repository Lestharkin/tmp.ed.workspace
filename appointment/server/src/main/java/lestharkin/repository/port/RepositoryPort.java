package lestharkin.repository.port;

import java.io.Serializable;

import lestharkin.interfaces.ILinkedList;

public interface RepositoryPort<T extends Serializable> extends Serializable {
  T getById(String id);

  ILinkedList<T> getAll();

  T save(T object);

  T update(T object);

  boolean delete(String id);
}
