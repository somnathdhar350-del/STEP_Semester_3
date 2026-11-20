package Class_Problems;
import java.util.*;

abstract class Delivery {
    protected String type;
    protected double weight;
    protected double distance;

    public Delivery(String type, double weight, double distance) {
        this.type = type;
        this.weight = weight;
        this.distance = distance;
    }

    public String getType() {
        return type;
    }

    public abstract double calculateFee();
}

class StandardDelivery extends Delivery {
    public StandardDelivery(double weight, double distance) {
        super("STANDARD", weight, distance);
    }

    @Override
    public double calculateFee() {
        return 5.0 + (0.50 * weight) + (0.10 * distance);
    }
}

class ExpressDelivery extends Delivery {
    public ExpressDelivery(double weight, double distance) {
        super("EXPRESS", weight, distance);
    }

    @Override
    public double calculateFee() {
        return 15.0 + (1.00 * weight) + (0.20 * distance);
    }
}

class InternationalDelivery extends Delivery {
    private double customsFee;

    public InternationalDelivery(double weight, double distance, double customsFee) {
        super("INTERNATIONAL", weight, distance);
        this.customsFee = customsFee;
    }

    @Override
    public double calculateFee() {
        return 25.0 + (2.00 * weight) + (0.50 * distance) + customsFee;
    }
}

public class DeliveryFeeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Delivery> deliveries = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double distance = sc.nextDouble();
            switch (type) {
                case "STANDARD":
                    deliveries.add(new StandardDelivery(weight, distance));
                    break;
                case "EXPRESS":
                    deliveries.add(new ExpressDelivery(weight, distance));
                    break;
                case "INTERNATIONAL":
                    double customs = sc.nextDouble();
                    deliveries.add(new InternationalDelivery(weight, distance, customs));
                    break;
            }
        }

        double total = 0;
        for (Delivery d : deliveries) {
            double fee = d.calculateFee();
            total += fee;
            System.out.printf("%s: %.2f%n", d.getType(), fee);
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}