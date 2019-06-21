package common;

public interface ListenJJorge {

    void clientReceive(TransmissionObject transmissionObject);

    void serverReceive(TransmissionObject transmissionObject);
}
