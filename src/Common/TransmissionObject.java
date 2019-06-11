package Common;

import java.net.InetAddress;
import java.util.ArrayList;

public class TransmissionObject {

    private char operation; // Operation [ D -> DiscoverMachines, S -> send , R -> receive]

    private String archiveName;

    private InetAddress address;

    private int port;

    private ArrayList<Integer> parts;

    private ArrayList<Byte[]> pecas;

    public TransmissionObject(InetAddress address, ArrayList<Byte[]> pecas) {
        this.address = address;
        this.pecas = pecas;
    }

    public TransmissionObject(char operation, InetAddress address, ArrayList<Integer> parts) {
        this.operation = operation;
        this.address = address;
        this.parts = parts;
    }

    public TransmissionObject(char operation, String archiveName) {
        this.operation = operation;
        this.archiveName = archiveName;
    }

    public String getArchiveName() {
        return archiveName;
    }

    public void setArchiveName(String archiveName) {
        this.archiveName = archiveName;
    }

    public char getOperation() {
        return operation;
    }

    public void setOperation(char operation) {
        this.operation = operation;
    }

    public InetAddress getAddress() {
        return address;
    }

    public void setAddress(InetAddress address) {
        this.address = address;
    }

    public ArrayList<Integer> getParts() {
        return parts;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void setParts(ArrayList<Integer> parts) {
        this.parts = parts;
    }

    public ArrayList<Byte[]> getPecas() {
        return pecas;
    }

    public void setPecas(ArrayList<Byte[]> pecas) {
        this.pecas = pecas;
    }
}
