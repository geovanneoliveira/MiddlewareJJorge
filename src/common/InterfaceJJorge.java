package common;

import java.util.ArrayList;

public interface InterfaceJJorge {

    TransmissionObject discoverMachines(String name);

    ArrayList<TransmissionObject> receiver(TransmissionObject transmissionObject);

    ArrayList<TransmissionObject> send(TransmissionObject transmissionObject);
}
