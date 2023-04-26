package lestharkin.repository.json.adapter;

import lestharkin.interfaces.ILinkedList;
import lestharkin.domain.Ticket;
import lestharkin.repository.port.TicketRepositoryPort;

public class TicketRepositoryJsonAdapter implements TicketRepositoryPort<Ticket> {

  @Override
  public Ticket getById(String id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getById'");
  }

  @Override
  public ILinkedList<Ticket> getAll() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getAll'");
  }

  @Override
  public Ticket save(Ticket ticket) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'save'");
  }

  @Override
  public Ticket update(Ticket ticket) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'update'");
  }

  @Override
  public boolean delete(String id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'delete'");
  }
  
}
