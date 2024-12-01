package org.example;

interface TransportFactory {
    public TransportBuilder createTransportBuilder();
}

class CarBuilderFactory implements TransportFactory {
    @Override public TransportBuilder createTransportBuilder() {
        return new CarBuilder();
    }
}

class PlaneBuilderFactory implements TransportFactory {
    @Override public TransportBuilder createTransportBuilder() {
        return new PlaneBuilder();
    }
}

class BoatBuilderFactory implements TransportFactory {
    @Override public TransportBuilder createTransportBuilder() {
        return new BoatBuilder();
    }
}