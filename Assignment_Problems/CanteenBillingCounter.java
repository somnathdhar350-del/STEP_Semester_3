
import java.util.*;

abstract class Customer {
    protected String type;
    protected double billAmount;

    public Customer(String type, double billAmount) {
        this.type = type;
        this.billAmount = billAmount;
    }

    public String getType() {
        return type;
    }

    public abstract double calculateFinalAmount();
}

class StudentCustomer extends Customer {
    public StudentCustomer(double billAmount) {
        super("STUDENT", billAmount);
    }

    @Override
    public double calculateFinalAmount() {
        return billAmount * 0.90;
    }
}

class StaffCustomer extends Customer {
    public StaffCustomer(double billAmount) {
        super("STAFF", billAmount);
    }

    @Override
    public double calculateFinalAmount() {
        return billAmount * 0.95;
    }
}

class GuestCustomer extends Customer {
    public GuestCustomer(double billAmount) {
        super("GUEST", billAmount);
    }

    @Override
    public double calculateFinalAmount() {
        return billAmount + 10.0;
    }
}

public class CanteenBillingCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Customer> customers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();
            switch (type) {
                case "STUDENT":
                    customers.add(new StudentCustomer(amount));
                    break;
                case "STAFF":
                    customers.add(new StaffCustomer(amount));
                    break;
                case "GUEST":
                    customers.add(new GuestCustomer(amount));
                    break;
            }
        }

        double total = 0;
        for (Customer c : customers) {
            double finalAmt = c.calculateFinalAmount();
            total += finalAmt;
            System.out.printf("%s: %.2f%n", c.getType(), finalAmt);
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}