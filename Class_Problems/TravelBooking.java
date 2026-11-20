package Class_Problems;

import java.util.*;

abstract class TravelTicket {
    protected static final double BOOKING_FEE = 50.0;
    protected String mode;
    protected double distanceKm;

    public TravelTicket(String mode, double distanceKm) {
        this.mode = mode;
        this.distanceKm = distanceKm;
    }

    public String getMode() {
        return mode;
    }

    protected abstract double calculateBaseFare();

    public double calculateTotalFare() {
        return calculateBaseFare() + BOOKING_FEE;
    }
}

class BusTicket extends TravelTicket {
    public BusTicket(double distanceKm) {
        super("BUS", distanceKm);
    }

    @Override
    protected double calculateBaseFare() {
        return distanceKm * 2.0;
    }
}

class TrainTicket extends TravelTicket {
    public TrainTicket(double distanceKm) {
        super("TRAIN", distanceKm);
    }

    @Override
    protected double calculateBaseFare() {
        return distanceKm * 1.5;
    }
}

class FlightTicket extends TravelTicket {
    public FlightTicket(double distanceKm) {
        super("FLIGHT", distanceKm);
    }

    @Override
    protected double calculateBaseFare() {
        return 2500.0 + (distanceKm * 4.0);
    }
}

public class TravelBooking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<TravelTicket> bookings = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String mode = sc.next();
            double distance = sc.nextDouble();
            switch (mode) {
                case "BUS":
                    bookings.add(new BusTicket(distance));
                    break;
                case "TRAIN":
                    bookings.add(new TrainTicket(distance));
                    break;
                case "FLIGHT":
                    bookings.add(new FlightTicket(distance));
                    break;
            }
        }

        for (TravelTicket t : bookings) {
            System.out.printf("%s: %.2f%n", t.getMode(), t.calculateTotalFare());
        }
        sc.close();
    }
}