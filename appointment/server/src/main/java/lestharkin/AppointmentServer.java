package lestharkin;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import lestharkin.app.controller.AppointmentController;
import lestharkin.rmi.adapter.AppointmentRMIAdapter;
import lestharkin.rmi.server.RMIServer;
import lestharkin.shared.environment.Environment;

public class AppointmentServer {
    public static void main(String[] args) {        
        try {
            Map<String, String> properties = Environment.getInstance().getVariables();
            AppointmentRMIAdapter appointmentRMIAdapter = new AppointmentRMIAdapter(new AppointmentController());
            RMIServer appointmentServer = new RMIServer(properties.get("IP"), properties.get("PORT0"), properties.get("SERVICE0"), appointmentRMIAdapter);

            RMIServer ticketServer = new RMIServer(properties.get("IP"), properties.get("PORT1"), properties.get("SERVICE1"), appointmentRMIAdapter);

            Thread[] threadList = {new Thread(appointmentServer), new Thread(ticketServer)};
            
            for (Thread thread : threadList) {
                thread.start();
            }
            Logger.getLogger("Server").log(Level.INFO, "Server is running...");
        } catch (Exception e) {
            Logger.getLogger("Server").log(Level.WARNING, e.getMessage(), e);
        }
    }    
}
