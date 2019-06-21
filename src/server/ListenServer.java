package server;

import common.ListenJJorge;
import common.TransmissionObject;

import java.util.ArrayList;
import java.util.List;

public class ListenServer {

    //Singleton
    private static ListenServer instance;

    private ListenServer(){}

    public static synchronized ListenServer getInstance(){
        return (instance == null)? instance = new ListenServer() : instance;
    }


    //Listeners
    private List<ListenJJorge> listeners = new ArrayList<ListenJJorge>();

    public void addListener(ListenJJorge toAdd){
        listeners.add(toAdd);
    }

    public void sendToListeners(TransmissionObject transmissionObject){

        for (ListenJJorge l : listeners)
            l.serverReceive(transmissionObject);
    }
}
