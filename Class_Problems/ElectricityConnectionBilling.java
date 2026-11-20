package Class_Problems;

import java.util.*;

abstract class ElectricityConnection {
    protected String type;
    protected int units;

    public ElectricityConnection(String type, int units) {
        this.type = type;
        this.units = units;
    }

    public String getType() {
        return type;
    }

    public abstract double calculateBill();
}

class HomeConnection extends ElectricityConnection {
    public HomeConnection(int units) {
        super("HOME", units);
    }

    @Override
    public double calculateBill() {
        if (units <= 100) {
            return units * 5.0;
        }
        return (100 * 5.0) + ((units - 100) * 7.0);
    }
}

class ShopConnection extends ElectricityConnection {
    public ShopConnection(int units) {
        super("SHOP", units);
    }

    @Override
    public double calculateBill() {
        return (units * 8.0) + 100.0;
    }
}

class FactoryConnection extends ElectricityConnection {
    public FactoryConnection(int units) {
        super("FACTORY", units);
    }

    @Override
    public double calculateBill() {
        return Math.max(1000.0, units * 6.0);
    }
}

public class ElectricityConnectionBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<ElectricityConnection> connections = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int units = sc.nextInt();
            switch (type) {
                case "HOME":
                    connections.add(new HomeConnection(units));
                    break;
                case "SHOP":
                    connections.add(new ShopConnection(units));
                    break;
                case "FACTORY":
                    connections.add(new FactoryConnection(units));
                    break;
            }
        }

        double total = 0;
        for (ElectricityConnection c : connections) {
            double bill = c.calculateBill();
            total += bill;
            System.out.printf("%s: %.2f%n", c.getType(), bill);
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}