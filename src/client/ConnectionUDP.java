package client;

import Common.TransmissionObject;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.ArrayList;

public class ConnectionUDP extends Thread{


    public static ArrayList<TransmissionObject> discoverMachines(String archiveName) {

        ArrayList<TransmissionObject> transmissionObjects = new ArrayList<TransmissionObject>();
        String hostMulticast = "224.0.0.1";
        int port = 9000;

        try {

            //Group Multicast
            InetAddress group = InetAddress.getByName(hostMulticast);
            System.out.println(group.isMulticastAddress());
            MulticastSocket multicastSocket = new MulticastSocket(port);
            multicastSocket.joinGroup(group);

            //Send
            byte[] bufferSend = archiveName.getBytes();
            DatagramPacket packet = new DatagramPacket(bufferSend, bufferSend.length, group, port);
            multicastSocket.send(packet);

            //receive
            byte[] bufferReceive = new byte[50];
            DatagramPacket packetReceive;
            while((packetReceive = new DatagramPacket(bufferReceive, bufferReceive.length)).getLength() != 0){

                //transform
                byte[] data = packetReceive.getData();
                ByteArrayInputStream in = new ByteArrayInputStream(data);
                ObjectInputStream is = new ObjectInputStream(in);

                //Add in array
                transmissionObjects.add( (TransmissionObject) is.readObject());

            }

            //close
            multicastSocket.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        //return
        return transmissionObjects;
    }
}
