package client;

import common.TransmissionObject;


import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Connection extends Thread {

    private Socket connection = null;

    public Connection(Socket connection) {
        this.connection = connection;
    }

    public Connection(){}

    @Override
    public void run() {

        if (!(this.connection == null)){
            TransmissionObject obj = connectionToObject();
            if(!(obj == null)){
                obj.setIPServer(connection.getInetAddress().getHostAddress());
                connReceive(obj);
            }
        }

    }


    private TransmissionObject connectionToObject() {

        TransmissionObject obj = null;

        try
        {
            //Get Connection TCP as object
            InputStream is = this.connection.getInputStream();
            ByteArrayInputStream bis = new ByteArrayInputStream(is.readAllBytes());
            ObjectInputStream ois = new ObjectInputStream(bis);

            //transform class
            obj = ((TransmissionObject) ois.readObject());
        }
        catch (Exception e)
        {
            System.out.println("Error Connection::class->connectionToObject");
            e.printStackTrace();
        }

        return obj;
    }

    private void connReceive(TransmissionObject obj){

        ListenClient.getInstance().sendToListeners(obj);
    }

    public void sendInMulticast(TransmissionObject obj){

        obj.setPortClient(SocketTCP.PORTCLIENT);

        new SocketUDP().send(obj);
    }

    public void send(TransmissionObject obj){

        try{
            obj.setPortClient(SocketTCP.PORTCLIENT);

            Socket socket = new Socket(obj.getIPServer(), obj.getPortServer());
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(obj);
            socket.close();
        }
        catch (Exception e)
        {
            System.out.println("error Connection::class->sendTransmissionObject");
            e.printStackTrace();
        }

    }

}

