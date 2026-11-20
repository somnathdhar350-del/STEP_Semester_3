
import java.util.*;

interface NightService {
    default double applyNightSurcharge(double baseFare) {
        return baseFare * 1.20;
    }
}

abstract class Cab {
    protected static final double MIN_FARE = 100.0;
    protected String type;
    protected double km;

    public Cab(String type, double km) {
        this.type = type;
        this.km = km;
    }

    public String getType() {
        return type;
    }

    protected abstract double getRatePerKm();

    public double calculateBaseFare() {
        return Math.max(MIN_FARE, km * getRatePerKm());
    }
}

class MiniCab extends Cab {
    public MiniCab(double km) {
        super("MINI", km);
    }

    @Override
    protected double getRatePerKm() {
        return 10.0;
    }
}

class SedanCab extends Cab implements NightService {
    public SedanCab(double km) {
        super("SEDAN", km);
    }

    @Override
    protected double getRatePerKm() {
        return 14.0;
    }
}

class SUVCab extends Cab implements NightService {
    public SUVCab(double km) {
        super("SUV", km);
    }

    @Override
    protected double getRatePerKm() {
        return 18.0;
    }
}

public class CityCabFareMeter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();

            Cab cab = null;
            switch (type) {
                case "MINI":
                    cab = new MiniCab(km);
                    break;
                case "SEDAN":
                    cab = new SedanCab(km);
                    break;
                case "SUV":
                    cab = new SUVCab(km);
                    break;
            }

            if (time.equals("NIGHT")) {
                if (cab instanceof NightService) {
                    double fare = ((NightService) cab).applyNightSurcharge(cab.calculateBaseFare());
                    total += fare;
                    System.out.printf("%s: %.2f%n", cab.getType(), fare);
                } else {
                    System.out.printf("%s: night service not available%n", cab.getType());
                }
            } else {
                double fare = cab.calculateBaseFare();
                total += fare;
                System.out.printf("%s: %.2f%n", cab.getType(), fare);
            }
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}