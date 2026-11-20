
import java.util.*;

interface SaverModeSupported {
    default double applySaverMode(double units) {
        return units * 0.75;
    }
}

abstract class Appliance {
    protected String type;
    protected double powerWatts;
    protected double hours;

    public Appliance(String type, double powerWatts, double hours) {
        this.type = type;
        this.powerWatts = powerWatts;
        this.hours = hours;
    }

    public String getType() {
        return type;
    }

    public double calculateUnits() {
        return (powerWatts * hours) / 1000.0;
    }
}

class Fridge extends Appliance {
    public Fridge(double hours) {
        super("FRIDGE", 150.0, hours);
    }
}

class AC extends Appliance implements SaverModeSupported {
    public AC(double hours) {
        super("AC", 1500.0, hours);
    }
}

class TV extends Appliance {
    public TV(double hours) {
        super("TV", 100.0, hours);
    }
}

class Washer extends Appliance implements SaverModeSupported {
    public Washer(double hours) {
        super("WASHER", 500.0, hours);
    }
}

public class HomeApplianceEnergyReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double totalCost = 0;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            double hours = Double.parseDouble(parts[1]);
            boolean saverRequested = parts.length == 3 && parts[2].equals("SAVER");

            Appliance app = null;
            switch (type) {
                case "FRIDGE":
                    app = new Fridge(hours);
                    break;
                case "AC":
                    app = new AC(hours);
                    break;
                case "TV":
                    app = new TV(hours);
                    break;
                case "WASHER":
                    app = new Washer(hours);
                    break;
            }

            if (saverRequested) {
                if (app instanceof SaverModeSupported) {
                    double units = ((SaverModeSupported) app).applySaverMode(app.calculateUnits());
                    double cost = units * 8.0;
                    totalCost += cost;
                    System.out.printf("%s: Units=%.2f Cost=%.2f%n", app.getType(), units, cost);
                } else {
                    System.out.printf("%s: saver mode not supported%n", app.getType());
                }
            } else {
                double units = app.calculateUnits();
                double cost = units * 8.0;
                totalCost += cost;
                System.out.printf("%s: Units=%.2f Cost=%.2f%n", app.getType(), units, cost);
            }
        }
        System.out.printf("Total Cost: %.2f%n", totalCost);
        sc.close();
    }
}