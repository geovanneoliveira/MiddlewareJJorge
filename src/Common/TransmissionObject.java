package Common;

import java.net.InetAddress;
import java.util.ArrayList;

public class TransmissionObject {

    private char operation; // Operation [ D -> DiscoverMachines, S -> send , R -> receive]

    private String archiveName;

    private InetAddress IPClient;
    private int portClient;

    private InetAddress IPServer;
    private int portServer;

    private ArrayList<Integer> parts;
    private byte[] pecas;

    //Constructor Future
    public TransmissionObject(){}

    public TransmissionObject(char operation, String archiveName, InetAddress IPClient, int portClient, InetAddress IPServer, int portServer, ArrayList<Integer> parts, byte[] pecas) {
        this.operation = operation;
        this.archiveName = archiveName;
        this.IPClient = IPClient;
        this.portClient = portClient;
        this.IPServer = IPServer;
        this.portServer = portServer;
        this.parts = parts;
        this.pecas = pecas;
    }

    public InetAddress getIPClient() {
        return IPClient;
    }

    public void setIPClient(InetAddress IPClient) {
        this.IPClient = IPClient;
    }

    public int getPortClient() {
        return portClient;
    }

    public void setPortClient(int portClient) {
        this.portClient = portClient;
    }

    public InetAddress getIPServer() {
        return IPServer;
    }

    public void setIPServer(InetAddress IPServer) {
        this.IPServer = IPServer;
    }

    public int getPortServer() {
        return portServer;
    }

    public void setPortServer(int portServer) {
        this.portServer = portServer;
    }

    public char getOperation() {
        return operation;
    }

    public void setOperation(char operation) {
        this.operation = operation;
    }

    public String getArchiveName() {
        return archiveName;
    }

    public void setArchiveName(String archiveName) {
        this.archiveName = archiveName;
    }

    public ArrayList<Integer> getParts() {
        return parts;
    }

    public void setParts(ArrayList<Integer> parts) {
        this.parts = parts;
    }

    public byte[] getPecas() {
        return pecas;
    }

    public void setPecas(byte[] pecas) {
        this.pecas = pecas;
    }
}
