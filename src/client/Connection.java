package client;

import Common.TransmissionObject;
import server.ListenServer;


import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
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
            if(!(obj == null)) connReceive(obj);
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

        ListenServer.getInstance().sendToListeners(obj);
    }

    public void sendInMulticast(TransmissionObject obj){

        obj.setIPClient(SocketTCP.IPCLIENT);
        obj.setPortClient(SocketTCP.PORTCLIENT);

        new SocketUDP().send(obj);
    }

    public void send(TransmissionObject obj){

        try{
            obj.setIPClient(SocketTCP.IPCLIENT);
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




















    /*//variables and constructor
    private DatagramPacket packet = null;
    private Socket conection = null;

    public Connection(DatagramPacket packet) {
        this.packet = packet;
    }

    public Connection(Socket conection) {
        this.conection = conection;
    }

    *//*********************************************************************//*

    //Implements Methods

    @Override
    public TransmissionObject discoverMachines(String archiveName) {

        *//* TODO
        * Buscar e pasta/local do pc em busca do arquivo / arquuvio
        *
        * e retornar dentro do TransmissionObject as partes
        *
        * claro pode redirecionar pra outra classe se for o caso
        *
        * *//*


        return null;
    }

    @Override
    public ArrayList<TransmissionObject> receiver(TransmissionObject transmissionObject) {

        *//*
        * receiver aqui no servidor é :
        *
        * ler o objeto.getParts() e ir mandando de 1 em 1 peça para o IP e PORTA do objeto
        **//*

        return null;
    }

    @Override
    public ArrayList<TransmissionObject> send(TransmissionObject transmissionObject) {
        return null;
    }

    *//**********************************************************************//*

    //Run Thread

    @Override
    public void run() {

        if(!(this.packet == null)){
            multicastConnection();

        }
        else if (!(this.conection == null)){
            tcpConnection();
        }
    }

    private void multicastConnection(){
        try
        {
            //Receive packet
            byte[] data = this.packet.getData();
            ByteArrayInputStream in = new ByteArrayInputStream(data);
            ObjectInputStream is = new ObjectInputStream(in);

            //transform class
            TransmissionObject transmissionObject = ((TransmissionObject) is.readObject());

            //TransmissionObject to return
            TransmissionObject transmissionObjectSend = null;

            //Switch
            transmissionObjectSend  = this.discoverMachines(transmissionObject.getArchiveName());

            //Test and send
            if(transmissionObjectSend != null){
                sendTransmissionObject(transmissionObjectSend,this.packet.getAddress(),this.packet.getPort());
            }

        }
        catch (Exception e)
        {
            System.out.println("Error Connection::class");
            e.printStackTrace();
        }
    }

    private void tcpConnection(){

        try{

            //Get Connection TCP as object
            InputStream is = this.conection.getInputStream();
            ByteArrayInputStream bis = new ByteArrayInputStream(is.readAllBytes());
            ObjectInputStream ois = new ObjectInputStream(bis);

            //transform class
            TransmissionObject transmissionObject = ((TransmissionObject) ois.readObject());
            //Compare operation
            if(transmissionObject.getOperation() == 'R'){
                *//*
                TODO chamar função Receiver
                 *//*

            }
            else if (transmissionObject.getOperation() == 'S'){
                *//*
                TODO chamar função Send
                 *//*
            }

            //TransmissionObject to return
            TransmissionObject transmissionObjectSend = null;


        }
        catch (Exception e)
        {
            System.out.println("error Connection::class->tcpConnection");
            e.printStackTrace();
        }
    }


    private void sendTransmissionObject(TransmissionObject transmissionObject, InetAddress host, int port){

        try{

            Socket socket = new Socket(host, port);
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(transmissionObject);
            socket.close();
        }
        catch (Exception e)
        {
            System.out.println("error Connection::class->sendTransmissionObject");
            e.printStackTrace();
        }


    }*/
}

