
import java.util.*;

abstract class Vehicle {
    protected String type;
    protected int hours;

    public Vehicle(String type, int hours) {
        this.type = type;
        this.hours = hours;
    }

    public String getType() {
        return type;
    }

    public abstract double calculateCharge();
}

class Bike extends Vehicle {
    public Bike(int hours) {
        super("BIKE", hours);
    }

    @Override
    public double calculateCharge() {
        return hours * 10.0;
    }
}

class Car extends Vehicle {
    public Car(int hours) {
        super("CAR", hours);
    }

    @Override
    public double calculateCharge() {
        return 30.0 + (hours - 1) * 20.0;
    }
}

class Truck extends Vehicle {
    public Truck(int hours) {
        super("TRUCK", hours);
    }

    @Override
    public double calculateCharge() {
        return Math.max(100.0, hours * 50.0);
    }
}

public class CampusParkingCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Vehicle> vehicles = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int hours = sc.nextInt();
            switch (type) {
                case "BIKE":
                    vehicles.add(new Bike(hours));
                    break;
                case "CAR":
                    vehicles.add(new Car(hours));
                    break;
                case "TRUCK":
                    vehicles.add(new Truck(hours));
                    break;
            }
        }

        double total = 0;
        for (Vehicle v : vehicles) {
            double charge = v.calculateCharge();
            total += charge;
            System.out.printf("%s: %.2f%n", v.getType(), charge);
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}