package Class_Problems;

import java.util.*;

abstract class Payment {
    protected String type;
    protected double amount;

    public Payment(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public abstract double calculateFinalAmount();
}

class CardPayment extends Payment {
    public CardPayment(double amount) {
        super("CARD", amount);
    }

    @Override
    public double calculateFinalAmount() {
        return amount * 1.02;
    }
}

class WalletPayment extends Payment {
    public WalletPayment(double amount) {
        super("WALLET", amount);
    }

    @Override
    public double calculateFinalAmount() {
        return amount * 1.01;
    }
}

class BankTransferPayment extends Payment {
    public BankTransferPayment(double amount) {
        super("BANKTRANSFER", amount);
    }

    @Override
    public double calculateFinalAmount() {
        return amount;
    }
}

public class PaymentSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Payment> payments = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();
            switch (type) {
                case "CARD":
                    payments.add(new CardPayment(amount));
                    break;
                case "WALLET":
                    payments.add(new WalletPayment(amount));
                    break;
                case "BANKTRANSFER":
                    payments.add(new BankTransferPayment(amount));
                    break;
            }
        }

        double total = 0;
        for (Payment p : payments) {
            double adjusted = p.calculateFinalAmount();
            total += adjusted;
            System.out.printf("%s: %.2f%n", p.getType(), adjusted);
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}