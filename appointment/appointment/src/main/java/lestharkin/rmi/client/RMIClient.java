package lestharkin.rmi.client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RMIClient {
  private static RMIClient instance;
  private String url;
  private Remote service;

  private RMIClient(String ip, String port, String serviceName) {
    this.service = null;
    this.url = "rmi://" + ip + ":" + port + "/" + serviceName;
  }

  public static RMIClient getInstance(String ip, String port, String serviceName) {
    if (instance ==  null) {
      RMIClient.instance = new RMIClient(ip, port, serviceName);
    }
    return RMIClient.instance;
  }

  public void connect() {
    try {
      service = Naming.lookup(url);
    } catch (MalformedURLException | RemoteException | NotBoundException e) {
      Logger.getLogger(this.getClass().getSimpleName()).log(Level.WARNING, e.getMessage(), e);
    }
  }

  public Remote getService() {
    return service;
  }
}
