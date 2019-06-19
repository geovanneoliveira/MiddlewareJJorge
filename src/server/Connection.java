package server;

import Common.TransmissionObject;


import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.Socket;

public class Connection extends Thread {

    private DatagramPacket packet = null;
    private Socket connection = null;

    public Connection(DatagramPacket packet) {
        this.packet = packet;
    }

    public Connection(Socket connection) {
        this.connection = connection;
    }

    public Connection() {
    }

    @Override
    public void run() {

        if (!(this.packet == null)) {
            TransmissionObject obj = packetToObject();
            if (!(obj == null)) {
                obj.setIPClient(packet.getAddress().getHostAddress());
                connReceive(obj);
            }
        } else if (!(this.connection == null)) {
            TransmissionObject obj = connectionToObject();
            if (!(obj == null)) {
                obj.setIPClient(connection.getInetAddress().getHostAddress());
                connReceive(obj);
            }
        }

    }

    private TransmissionObject packetToObject() {

        TransmissionObject obj = null;

        try {
            //Receive packet
            byte[] data = this.packet.getData();
            ByteArrayInputStream in = new ByteArrayInputStream(data);
            ObjectInputStream is = new ObjectInputStream(in);

            //transform class
            obj = ((TransmissionObject) is.readObject());

        } catch (Exception e) {
            System.out.println("Error Connection::class->packetToObject");
            e.printStackTrace();
        }

        return obj;
    }

    private TransmissionObject connectionToObject() {

        TransmissionObject obj = null;

        try {
            //Get Connection TCP as object
            InputStream is = this.connection.getInputStream();
            ByteArrayInputStream bis = new ByteArrayInputStream(is.readAllBytes());
            ObjectInputStream ois = new ObjectInputStream(bis);

            //transform class
            obj = ((TransmissionObject) ois.readObject());
        } catch (Exception e) {
            System.out.println("Error Connection::class->connectionToObject");
            e.printStackTrace();
        }

        return obj;
    }

    private void connReceive(TransmissionObject obj) {

        ListenServer.getInstance().sendToListeners(obj);
    }

    public void send(TransmissionObject obj) {

        try {
            obj.setPortServer(SocketTCP.PORTSERVER);

            Socket socket = new Socket(obj.getIPClient(), obj.getPortClient());
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(obj);
            socket.close();
        } catch (Exception e) {
            System.out.println("error Connection::class->sendTransmissionObject");
            e.printStackTrace();
        }

    }
}