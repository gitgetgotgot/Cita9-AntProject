package org.example;

import java.util.ArrayList;
import java.util.List;

public class TransportDatabase {
    private static TransportDatabase instance;
    private List<Transport> transports;

    private TransportDatabase() {
        transports = new ArrayList<>();
    }

    public static TransportDatabase getInstance() {
        if (instance == null) {
            instance = new TransportDatabase();
        }
        return instance;
    }

    public void addTransport(Transport t) {
        transports.add(t);
    }

    public List<Transport> getTransportList() {
        return transports;
    }
}
