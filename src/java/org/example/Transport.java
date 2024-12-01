package org.example;

abstract class Transport {
    protected String vendor;
    protected String model;
    protected String color;
    protected float price;
    protected int year;
    public Transport(String vendor, String model, String color, float price, int year) {
        this.vendor = vendor;
        this.model = model;
        this.color = color;
        this.price = price;
        this.year = year;
    }

    public String getVendor() {
        return vendor;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public float getPrice() {
        return price;
    }

    public int getYear() {
        return year;
    }

    abstract public void showInfo();
}

class Car extends Transport {
    private String engine;
    private int doors;

    public Car(String vendor, String model, String color, float price, int year, String engine, int doors) {
        super(vendor, model, color, price, year);
        this.engine = engine;
        this.doors = doors;
    }

    public String getEngine() {
        return engine;
    }

    public int getDoors() {
        return doors;
    }

    @Override public void showInfo() {
        System.out.println("Car: " + vendor + " " + model + ", engine: " + engine + ", color: " + color +
                 ", doors: " + doors +  ", price: " + price + ", year: " + year);
    }
}

class Plane extends Transport {
    private int engines;
    private int seats;

    public Plane(String vendor, String model, String color, float price, int year, int engines, int seats) {
        super(vendor, model, color, price, year);
        this.engines = engines;
        this.seats = seats;
    }

    public int getEngines() {
        return engines;
    }

    public int getSeats() {
        return seats;
    }

    @Override public void showInfo() {
        System.out.println("Plane: " + vendor + " " + model + ", engines count: " + engines + ", color: " + color +
                ", seats: " + seats +  ", price: " + price + ", year: " + year);
    }
}

class Boat extends Transport {
    private boolean has_motor;
    private boolean has_sail;

    public Boat(String vendor, String model, String color, float price, int year, boolean has_motor, boolean has_sail) {
        super(vendor, model, color, price, year);
        this.has_motor = has_motor;
        this.has_sail = has_sail;
    }
    public boolean hasMotor() {
        return has_motor;
    }
    public boolean hasSail() {
        return has_sail;
    }
    @Override public void showInfo() {
        System.out.println("Boat: " + vendor + " " + model + ", has motor: " + has_motor + ", color: " + color +
                ", has sail: " + has_sail +  ", price: " + price + ", year: " + year);
    }
}