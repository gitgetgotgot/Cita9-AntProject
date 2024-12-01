package org.example;

import com.google.gson.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        TransportDatabase transports = TransportDatabase.getInstance();

        try (FileReader reader = new FileReader("C:\\Users\\AsusVivo\\IdeaProjects\\Sita_i_ris_lab9_ant\\src\\resources\\Transport.json")) {

            JsonArray jsonArray = JsonParser.parseReader(reader).getAsJsonArray();

            for (int i = 0; i < jsonArray.size(); i++) {
                JsonObject jsonObject = jsonArray.get(i).getAsJsonObject();

                String type = jsonObject.get("type").getAsString();
                String vendor = jsonObject.get("vendor").getAsString();
                String model = jsonObject.get("model").getAsString();
                String color = jsonObject.get("color").getAsString();
                float price = jsonObject.get("price").getAsFloat();
                int year = jsonObject.get("year").getAsInt();
                String engine = jsonObject.has("engine") ? jsonObject.get("engine").getAsString() : null;
                int doors = jsonObject.has("doors") ? jsonObject.get("doors").getAsInt() : 0;
                int engines = jsonObject.has("engines") ? jsonObject.get("engines").getAsInt() : 0;
                int seats = jsonObject.has("seats") ? jsonObject.get("seats").getAsInt() : 0;
                boolean has_motor = jsonObject.has("has_motor") && jsonObject.get("has_motor").getAsBoolean();
                boolean has_sail = jsonObject.has("has_sail") && jsonObject.get("has_sail").getAsBoolean();

                TransportFactory factory;
                if (type.equals("Car")) {
                    factory = new CarBuilderFactory();
                } else if (type.equals("Plane")) {
                    factory = new PlaneBuilderFactory();
                } else {
                    factory = new BoatBuilderFactory();
                }
                TransportBuilder builder = factory.createTransportBuilder();
                builder.set_vendor(vendor)
                .set_model(model)
                .set_color(color)
                .set_price(price)
                .set_year(year)
                .set_engine(engine)
                .set_doors_count(doors)
                .set_engines_count(engines)
                .set_seats(seats)
                .set_motor(has_motor)
                .set_sail(has_sail);

                transports.addTransport(builder.build());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Transport> transportsList = transports.getTransportList();
        System.out.println("All transport info");
        for (Transport t : transportsList) {
            t.showInfo();
            System.out.println("--------------------------------------------------------------------------------");
        }
        System.out.println();
        System.out.println("Transport that costs more than 100000");
        for (Transport t : transportsList) {
            if (t.getPrice() > 100000) {
                t.showInfo();
                System.out.println("--------------------------------------------------------------------------------");
            }
        }
        transportsList.sort(Comparator.comparingInt(Transport::getYear));
        System.out.println();
        System.out.println("List of transport sorted by year");
        for (Transport t : transportsList) {
            t.showInfo();
            System.out.println("--------------------------------------------------------------------------------");
        }
        System.out.println();
        System.out.println("List of only white transport");
        for (Transport t : transportsList) {
            if (t.getColor().equals("White")) {
                t.showInfo();
                System.out.println("--------------------------------------------------------------------------------");
            }
        }
        int cars = 0;
        int planes = 0;
        int boats = 0;
        int allCarsPrice = 0;
        int allPlanesPrice = 0;
        int allBoatsPrice = 0;
        for (Transport t : transportsList) {
            if (t instanceof Car) {
                cars++;
                allCarsPrice += t.getPrice();
            }
            else if (t instanceof Plane) {
                planes++;
                allPlanesPrice += t.getPrice();
            }
            else {
                boats++;
                allBoatsPrice += t.getPrice();
            }
        }
        System.out.println();
        System.out.println("Amount of eact transport type:\nCars: " + cars + ", Planes: " + planes + ", Boats: " + boats);
        System.out.println("Medium price of all cars = " + (allCarsPrice / (float)cars));
        System.out.println("Medium price of all planes = " + (allPlanesPrice / (float)planes));
        System.out.println("Medium price of all boats = " + (allBoatsPrice / (float)boats));
    }
}