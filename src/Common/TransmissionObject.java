package Common;

import java.io.Serializable;
import java.util.ArrayList;

public class TransmissionObject implements Serializable {

    private char operation; // Operation [ D -> DiscoverMachines, S -> send , R -> receive]

    private String archiveName;

    private String IPClient;
    private int portClient;

    private String IPServer;
    private int portServer;

    private ArrayList<Integer> parts;
    private byte[] pecas;

    //Constructor Future
    public TransmissionObject(){}

    public TransmissionObject(char operation, String archiveName, String IPClient, int portClient, String IPServer, int portServer, ArrayList<Integer> parts, byte[] pecas) {
        this.operation = operation;
        this.archiveName = archiveName;
        this.IPClient = IPClient;
        this.portClient = portClient;
        this.IPServer = IPServer;
        this.portServer = portServer;
        this.parts = parts;
        this.pecas = pecas;
    }

    public String getIPClient() {
        return IPClient;
    }

    public void setIPClient(String IPClient) {
        this.IPClient = IPClient;
    }

    public int getPortClient() {
        return portClient;
    }

    public void setPortClient(int portClient) {
        this.portClient = portClient;
    }

    public String getIPServer() {
        return IPServer;
    }

    public void setIPServer(String IPServer) {
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
