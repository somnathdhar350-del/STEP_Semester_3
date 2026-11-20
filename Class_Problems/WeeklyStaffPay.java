package Class_Problems;

import java.util.*;

abstract class Staff {
    protected String name;

    public Staff(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract double calculatePay();
}

class FullTimeStaff extends Staff {
    private double weeklySalary;

    public FullTimeStaff(String name, double weeklySalary) {
        super(name);
        this.weeklySalary = weeklySalary;
    }

    @Override
    public double calculatePay() {
        return weeklySalary;
    }
}

class HourlyStaff extends Staff {
    private double hours;
    private double rate;

    public HourlyStaff(String name, double hours, double rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }

    @Override
    public double calculatePay() {
        if (hours <= 40) {
            return hours * rate;
        }
        return (40 * rate) + ((hours - 40) * rate * 1.5);
    }
}

class InternStaff extends Staff {
    private double stipend;

    public InternStaff(String name, double stipend) {
        super(name);
        this.stipend = stipend;
    }

    @Override
    public double calculatePay() {
        return stipend;
    }
}

public class WeeklyStaffPay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Staff> staffList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            switch (type) {
                case "FULLTIME":
                    staffList.add(new FullTimeStaff(name, sc.nextDouble()));
                    break;
                case "HOURLY":
                    staffList.add(new HourlyStaff(name, sc.nextDouble(), sc.nextDouble()));
                    break;
                case "INTERN":
                    staffList.add(new InternStaff(name, sc.nextDouble()));
                    break;
            }
        }

        double totalPayroll = 0;
        for (Staff s : staffList) {
            double pay = s.calculatePay();
            totalPayroll += pay;
            System.out.printf("%s: %.2f%n", s.getName(), pay);
        }
        System.out.printf("Total Payroll: %.2f%n", totalPayroll);
        sc.close();
    }
}