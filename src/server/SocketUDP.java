package server;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class SocketUDP extends Thread{


    public void run() {

        String hostMulticast = "224.0.0.1";
        int port = 9000;

        try
        {
            //Group Multicast
            InetAddress group = InetAddress.getByName(hostMulticast);
            System.out.println(group.isMulticastAddress());
            MulticastSocket multicastSocket = new MulticastSocket(port);
            multicastSocket.joinGroup(group);


            while (true){

                //Byte Array
                byte[] bufferReceive = new byte[1024];
                DatagramPacket packetReceive = new DatagramPacket(bufferReceive, bufferReceive.length);

                System.out.println("Wait Packet");
                multicastSocket.receive(packetReceive);

                System.out.println("Send to Process");
                new Connection(packetReceive).start();

            }
        }
        catch (Exception e)
        {
            System.out.println("Error SocketUDP::class");
            e.printStackTrace();
        }
    }
}
