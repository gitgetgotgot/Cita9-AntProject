package org.example;

abstract class TransportBuilder {
    //common
    protected String vendor;
    protected String model;
    protected String color;
    protected float price;
    protected int year;
    //car
    protected String engine;
    protected int doors;
    //plane
    protected int engines;
    protected int seats;
    //boat
    protected boolean has_motor;
    protected boolean has_sail;

    public TransportBuilder set_vendor(String vendor) {
        this.vendor = vendor;
        return this;
    }
    public TransportBuilder set_model(String model) {
        this.model = model;
        return this;
    }
    public TransportBuilder set_color(String color) {
        this.color = color;
        return this;
    }
    public TransportBuilder set_price(float price) {
        this.price = price;
        return this;
    }
    public TransportBuilder set_year(int year) {
        this.year = year;
        return this;
    }
    public TransportBuilder set_engine(String engine) {
        this.engine = engine;
        return this;
    }
    public TransportBuilder set_doors_count(int doors) {
        this.doors = doors;
        return this;
    }
    public TransportBuilder set_engines_count(int engines) {
        this.engines = engines;
        return this;
    }
    public TransportBuilder set_seats(int seats) {
        this.seats = seats;
        return this;
    }
    public TransportBuilder set_motor(boolean has_motor) {
        this.has_motor = has_motor;
        return this;
    }
    public TransportBuilder set_sail(boolean has_sail) {
        this.has_sail = has_sail;
        return this;
    }
    public abstract Transport build();
}

class CarBuilder extends TransportBuilder {
    @Override public Transport build() {
        return new Car(vendor, model, color, price, year, engine, doors);
    }
}

class PlaneBuilder extends TransportBuilder {
    @Override public Transport build() {
        return new Plane(vendor, model, color, price, year, engines, seats);
    }
}

class BoatBuilder extends TransportBuilder {
    @Override public Transport build() {
        return new Boat(vendor, model, color, price, year, has_motor, has_sail);
    }
}