package Class_Problems;

import java.util.*;

abstract class Transport {
    protected String type;
    protected double distance;

    public Transport(String type, double distance) {
        this.type = type;
        this.distance = distance;
    }

    public String getType() {
        return type;
    }

    public abstract double calculateFare();
}

class Bus extends Transport {
    public Bus(double distance) {
        super("BUS", distance);
    }

    @Override
    public double calculateFare() {
        return Math.min(10.0, 2.0 + 0.10 * distance);
    }
}

class Train extends Transport {
    public Train(double distance) {
        super("TRAIN", distance);
    }

    @Override
    public double calculateFare() {
        return 3.0 + 0.15 * distance;
    }
}

class Metro extends Transport {
    private double peakHourFactor;

    public Metro(double distance, double peakHourFactor) {
        super("METRO", distance);
        this.peakHourFactor = peakHourFactor;
    }

    @Override
    public double calculateFare() {
        return (1.50 + 0.20 * distance) * peakHourFactor;
    }
}

public class PublicTransportFare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Transport> journeys = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double distance = sc.nextDouble();
            switch (type) {
                case "BUS":
                    journeys.add(new Bus(distance));
                    break;
                case "TRAIN":
                    journeys.add(new Train(distance));
                    break;
                case "METRO":
                    double factor = sc.nextDouble();
                    journeys.add(new Metro(distance, factor));
                    break;
            }
        }

        double total = 0;
        for (Transport t : journeys) {
            double fare = t.calculateFare();
            total += fare;
            System.out.printf("%s: %.2f%n", t.getType(), fare);
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}