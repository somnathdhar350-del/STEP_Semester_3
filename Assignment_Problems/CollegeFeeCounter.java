
import java.util.*;

interface BusUser {
    double TRANSPORT_FEE = 12000.0;

    default double getTransportFee() {
        return TRANSPORT_FEE;
    }
}

abstract class Student {
    protected String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract double calculateBaseFee();
}

class DayScholar extends Student implements BusUser {
    public DayScholar(String name) {
        super(name);
    }

    @Override
    public double calculateBaseFee() {
        return 40000.0;
    }
}

class Hosteller extends Student {
    public Hosteller(String name) {
        super(name);
    }

    @Override
    public double calculateBaseFee() {
        return 40000.0 + 60000.0;
    }
}

class Scholar extends Student implements BusUser {
    public Scholar(String name) {
        super(name);
    }

    @Override
    public double calculateBaseFee() {
        return 20000.0;
    }
}

public class CollegeFeeCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            switch (type) {
                case "DAY_SCHOLAR":
                    students.add(new DayScholar(name));
                    break;
                case "HOSTELLER":
                    students.add(new Hosteller(name));
                    break;
                case "SCHOLAR":
                    students.add(new Scholar(name));
                    break;
            }
        }

        double totalCollected = 0;
        for (Student s : students) {
            double fee = s.calculateBaseFee();
            if (s instanceof BusUser) {
                fee += ((BusUser) s).getTransportFee();
            }
            totalCollected += fee;
            System.out.printf("%s: %.2f%n", s.getName(), fee);
        }
        System.out.printf("Total Collected: %.2f%n", totalCollected);
        sc.close();
    }
}