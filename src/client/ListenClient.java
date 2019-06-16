package client;

import Common.ListenJJorge;
import Common.TransmissionObject;

import java.util.ArrayList;
import java.util.List;

public class ListenClient {

    //Singleton
    private static ListenClient instance;

    private ListenClient(){}

    public static synchronized ListenClient getInstance(){
        return (instance == null)? instance = new ListenClient() : instance;
    }


    //Listeners
    private List<ListenJJorge> listeners = new ArrayList<ListenJJorge>();

    public void addListener(ListenJJorge toAdd){
        listeners.add(toAdd);
    }

    public void sendToListeners(TransmissionObject transmissionObject){

        for (ListenJJorge l : listeners)
            l.clientReceive(transmissionObject);
    }
}
