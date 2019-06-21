package client;

import common.TransmissionObject;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class SocketUDP {

    public void send(TransmissionObject obj) {

        String hostMulticast = "224.0.0.1";
        int port = 9000;

        try {

            //Group Multicast
            InetAddress group = InetAddress.getByName(hostMulticast);
            System.out.println(group.isMulticastAddress());
            MulticastSocket multicastSocket = new MulticastSocket(port);
            multicastSocket.joinGroup(group);

            //Transform Object to Byte Array
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(obj);

            //Send
            byte[] bufferSend = baos.toByteArray();
            DatagramPacket packet = new DatagramPacket(bufferSend, bufferSend.length, group, port);
            multicastSocket.send(packet);
        }
        catch (Exception e)
        {
            System.out.println("Error JJorgeClient::class");
            e.printStackTrace();
        }
    }
}
