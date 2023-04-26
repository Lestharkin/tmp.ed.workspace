package lestharkin;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import lestharkin.interfaces.ILinkedList;
import lestharkin.singly.linkedlist.LinkedList;
import lestharkin.app.controller.AppointmentController;
import lestharkin.app.model.AppointmentModel;
import lestharkin.app.view.AppointmentJFrame;
import lestharkin.domain.Appointment;
import lestharkin.rmi.adapter.AppointmentRMIAdapter;
import lestharkin.rmi.client.RMIClient;
import lestharkin.rmi.port.AppointmentRMIPort;
import lestharkin.shared.environment.Environment;

public class AppointmentClient {
    public static void main(String[] args) {
        try {            
            Map<String, String> properties = Environment.getInstance().getVariables();
            RMIClient client = RMIClient.getInstance(properties.get("IP"), properties.get("PORT"),
                    properties.get("SERVICE"));
            client.connect();
            AppointmentController appController = new AppointmentController(new AppointmentModel(new AppointmentRMIAdapter((AppointmentRMIPort) client.getService())));
            ILinkedList<Appointment> list;
            if ((list = (LinkedList) appController.getAppointments()) != null) {
                System.out.println(list.getFirst().getDescription());
                AppointmentJFrame frame = new AppointmentJFrame(list);
                frame.setVisible(true);
            }
            System.out.println(appController.getAppointmentById("app0001").getDate().toString());
        } catch (Exception e) {
            Logger.getLogger("Server").log(Level.WARNING, e.getMessage(), e);
        }
    }
}
