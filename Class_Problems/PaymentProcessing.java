package Class_Problems;

import java.util.Scanner;

// Time Complexity: O(n)
public class PaymentProcessing {
    interface PaymentMode {
        double processPayment(double amount);
        String getModeName();
    }

    static class CashPayment implements PaymentMode {
        @Override
        public double processPayment(double amount) {
            return amount;
        }

        @Override
        public String getModeName() {
            return "Cash";
        }
    }

    static class CardPayment implements PaymentMode {
        @Override
        public double processPayment(double amount) {
            return amount + (amount * 0.02);
        }

        @Override
        public String getModeName() {
            return "Card";
        }
    }

    static class UpiPayment implements PaymentMode {
        @Override
        public double processPayment(double amount) {
            return amount;
        }

        @Override
        public String getModeName() {
            return "UPI";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PaymentMode[] modes = new PaymentMode[n];
        double[] amounts = new double[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            amounts[i] = sc.nextDouble();
            if (type.equalsIgnoreCase("Cash")) {
                modes[i] = new CashPayment();
            } else if (type.equalsIgnoreCase("Card")) {
                modes[i] = new CardPayment();
            } else {
                modes[i] = new UpiPayment();
            }
        }

        double grandTotal = 0.0;
        for (int i = 0; i < n; i++) {
            double processed = modes[i].processPayment(amounts[i]);
            double fee = processed - amounts[i];
            grandTotal += processed;
            System.out.println(modes[i].getModeName() + ": amount " + amounts[i]
                    + ", fee " + fee + ", processed " + processed);
        }
        System.out.println("Total Amount Processed: " + grandTotal);
        sc.close();
    }
}