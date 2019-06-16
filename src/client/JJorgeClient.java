package client;


import Common.ListenJJorge;
import Common.TransmissionObject;

public class JJorgeClient{

    public JJorgeClient(ListenJJorge listenJJorge) {
        new SocketTCP().start();
        ListenClient.getInstance().addListener(listenJJorge);
    }

    public void discoverMachines(TransmissionObject obj){
        new Connection().sendInMulticast(obj);
    }

    public void send(TransmissionObject obj){
        new Connection().send(obj);
    }
}
