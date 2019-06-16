package server;

import Common.ListenJJorge;
import Common.TransmissionObject;

public class JJorgeServer {

    public JJorgeServer(ListenJJorge listenJJorge) {
        new SocketTCP().start();
        new SocketUDP().start();
        ListenServer.getInstance().addListener(listenJJorge);
    }

    public void send(TransmissionObject obj){

        new Connection().send(obj);
    }
}
