
import java.util.*;

abstract class Ticket {
    protected static final double CONVENIENCE_FEE = 20.0;
    protected String seatType;
    protected int count;

    public Ticket(String seatType, int count) {
        this.seatType = seatType;
        this.count = count;
    }

    public String getSeatType() {
        return seatType;
    }

    protected abstract double getBasePrice();

    public double calculateAmount() {
        return count * (getBasePrice() + CONVENIENCE_FEE);
    }
}

class RegularTicket extends Ticket {
    public RegularTicket(int count) {
        super("REGULAR", count);
    }

    @Override
    protected double getBasePrice() {
        return 150.0;
    }
}

class PremiumTicket extends Ticket {
    public PremiumTicket(int count) {
        super("PREMIUM", count);
    }

    @Override
    protected double getBasePrice() {
        return 250.0;
    }
}

class ReclinerTicket extends Ticket {
    public ReclinerTicket(int count) {
        super("RECLINER", count);
    }

    @Override
    protected double getBasePrice() {
        return 400.0;
    }
}

public class MovieTicketCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Ticket> tickets = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String seat = sc.next();
            int count = sc.nextInt();
            switch (seat) {
                case "REGULAR":
                    tickets.add(new RegularTicket(count));
                    break;
                case "PREMIUM":
                    tickets.add(new PremiumTicket(count));
                    break;
                case "RECLINER":
                    tickets.add(new ReclinerTicket(count));
                    break;
            }
        }

        double total = 0;
        for (Ticket t : tickets) {
            double amount = t.calculateAmount();
            total += amount;
            System.out.printf("%s: %.2f%n", t.getSeatType(), amount);
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}