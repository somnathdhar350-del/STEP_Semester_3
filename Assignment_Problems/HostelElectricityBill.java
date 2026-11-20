
import java.util.*;

abstract class Room {
    protected String type;
    protected int units;

    public Room(String type, int units) {
        this.type = type;
        this.units = units;
    }

    public String getType() {
        return type;
    }

    public abstract double calculateBill();
}

class SingleRoom extends Room {
    public SingleRoom(int units) {
        super("SINGLE", units);
    }

    @Override
    public double calculateBill() {
        return units * 8.0;
    }
}

class SharedRoom extends Room {
    private int occupants;

    public SharedRoom(int units, int occupants) {
        super("SHARED", units);
        this.occupants = occupants;
    }

    @Override
    public double calculateBill() {
        return (units * 6.0) / occupants;
    }
}

class ACRoom extends Room {
    public ACRoom(int units) {
        super("AC", units);
    }

    @Override
    public double calculateBill() {
        return (units * 10.0) + 200.0;
    }
}

public class HostelElectricityBill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Room> rooms = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int units = sc.nextInt();
            switch (type) {
                case "SINGLE":
                    rooms.add(new SingleRoom(units));
                    break;
                case "SHARED":
                    int occupants = sc.nextInt();
                    rooms.add(new SharedRoom(units, occupants));
                    break;
                case "AC":
                    rooms.add(new ACRoom(units));
                    break;
            }
        }

        double total = 0;
        for (Room r : rooms) {
            double bill = r.calculateBill();
            total += bill;
            System.out.printf("%s: %.2f%n", r.getType(), bill);
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}